package com.revature.user;

import com.revature.user.dao.UserRepository;
import com.revature.user.model.User;
import com.revature.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    private User existingUser;
    private User newUser;

    @BeforeEach
    public void setUp() {
        existingUser = new User(1L, "Imran R", "imran@gmail.com");
        newUser = new User(null, "Sunni", "sunni@gmail.com");
    }

    @Test
    public void testUserById_positive() {
        // Arrange
        when(repository.findById(1L)).thenReturn(existingUser);

        // Act
        User foundUser = service.getUsetById(1L);

        // Assert
        Assertions.assertEquals("Imran R", foundUser.getName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testUserById_negative() {
        when(repository.findById(1L)).thenReturn(null);

        User foundUser = service.getUsetById(1L);

        Assertions.assertNull(foundUser);
        verify(repository, times(1)).findById(1L);
    }

    public void testSuccessRegistration(){

    }
}
