package com.otpexample.service;

import com.otpexample.entity.User;
import com.otpexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public User getUserByMobile(String mobile) {
        User user = userRepository.findByMobile(mobile);
        return user;
    }

    public void verifyMobile(User user) {
        user.setMobileVerified(true);
        userRepository.save(user);
    }
}
