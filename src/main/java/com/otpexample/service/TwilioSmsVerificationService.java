package com.otpexample.service;

import com.otpexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TwilioSmsVerificationService {
    @Autowired
    private UserService userService;


   static final Map<String, String> smsOtpMapping = new HashMap<>();


    public Map<String,String> verifyOtp(String email, String otp) {
        String storedOtp = smsOtpMapping.get(email);
        Map<String, String> response = new HashMap<>();
        if (storedOtp != null && storedOtp.equals(otp)) {
            User user = userService.getUserByMobile(email);
            if (user != null) {
                userService.verifyMobile(user);
                smsOtpMapping.remove(email);
                response.put("status", "success");
                response.put("message", "Email verified successfully");
            } else {
                response.put("status", "error");
                response.put("message", "User not found");
            }
        } else {
            response.put("status", "error");
            response.put("message", "Invalid otp");
        }
        return response;
    }
}