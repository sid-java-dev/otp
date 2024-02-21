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

    public void verifyOtp(String mobile, String otp) {
        System.out.println(smsOtpMapping);
        System.out.println(smsOtpMapping.get(mobile));
    }
}