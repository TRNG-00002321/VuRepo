package com.revature.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
        import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private EmailClient emailClient;

    @InjectMocks
    private UserService userService;

    @Test
    void getUser_existingUser_returnsUser() {
        // Arrange
        User expected = new User("Vu", "vu@test.com");
        expected.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(expected));

        // Act
        User actual = userService.getUser(1L);

        // Assert
        assertEquals(expected, actual);
        assertEquals("Vu", actual.getName());

    }

    @Test
    void getUser_nonExistentUser_throwsException() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(UserService.UserNotFoundException.class,
                () -> userService.getUser(999L));
    }


    @Test
    void createUser_success_returnsSavedUser() {
        User saved = new User("Bob", "bob@test.com");
        saved.setId(10L);

        when(repository.existsByEmail("bob@test.com")).thenReturn(false);
        when(repository.save(any(User.class))).thenReturn(saved);

        User result = userService.createUser("Bob", "bob@test.com");

        assertEquals(10L, result.getId());
        verify(emailClient).send("bob@test.com", "Welcome!", "Your account was created.");
    }

    @Test
    void createUser_duplicateEmail_throwsException() {
        when(repository.existsByEmail("bob@test.com")).thenReturn(true);

        assertThrows(UserService.DuplicateUserException.class,
                () -> userService.createUser("Bob", "bob@test.com"));
    }

    @Test
    void getActiveUsers_returnsCorrectCount() {
        when(repository.findAllActive()).thenReturn(List.of(new User(), new User()));

        assertEquals(2, userService.getActiveUsers());
    }

    @Test
    void getUserCount_returnsRepositoryCount() {
        when(repository.count()).thenReturn(42L);

        assertEquals(42L, userService.getUserCount());
    }
}
