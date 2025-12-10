package com.revature.user.service;

import com.revature.user.dao.UserRepository;
import com.revature.user.model.User;

public class UserService {
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUsetById(Long id){
        return userRepository.findById(id);
    }

    public boolean register (User user){
        if(userRepository.findByEmail(user.getEmail()) != null){
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
