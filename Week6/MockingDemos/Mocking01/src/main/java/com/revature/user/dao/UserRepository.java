package com.revature.user.dao;

import com.revature.user.model.User;

public interface UserRepository {
    User findById(Long id);
    void save(User user);
    User findByEmail(String email);
}
