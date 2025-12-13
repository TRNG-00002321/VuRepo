package com.revature.mock;

import java.util.Optional;

public class UserService {

    private final UserRepository repository;
    private final EmailClient emailClient;

    public UserService(UserRepository repository, EmailClient emailClient) {
        this.repository = repository;
        this.emailClient = emailClient;
    }

    public User getUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User createUser(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (repository.existsByEmail(email)) {
            throw new DuplicateUserException("Email already exists");
        }

        User user = new User(name, email);
        User savedUser = repository.save(user);

        emailClient.send(email, "Welcome!", "Your account was created.");

        return savedUser;
    }

    public int getActiveUsers() {
        return repository.findAllActive().size();
    }

    public long getUserCount() {
        return repository.count();
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String msg) { super(msg); }
    }

    public static class DuplicateUserException extends RuntimeException {
        public DuplicateUserException(String msg) { super(msg); }
    }
}