package com.otpexample.controller;

import com.otpexample.entity.User;
import com.otpexample.service.TwilioService;
import com.otpexample.service.TwilioSmsVerificationService;
import com.otpexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private TwilioService twilioService;
    @Autowired
    private TwilioSmsVerificationService twilioSmsVerificationService;
    @PostMapping("/register")
    public Map<String,String> registerUser(@RequestBody User user){
        userService.registerUser(user);
        return twilioService.sendOtpSms(user.getMobile());
    }
    @PostMapping("/verify-otp")
    public Map<String,String>verifyOtp(@RequestParam String mobile,@RequestParam String otp){

        return twilioSmsVerificationService.verifyOtp(mobile, otp);
    }

}
