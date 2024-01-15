package com.tamjayz.FedBank.controller;

import com.tamjayz.FedBank.dto.BankResponse;
import com.tamjayz.FedBank.dto.OtpRequest;
import com.tamjayz.FedBank.dto.OtpValidationRequest;
import com.tamjayz.FedBank.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("sendOtp")
    public BankResponse sendOtp(OtpRequest request){
        return otpService.sendOtp(request);
    }
    
    @PostMapping("validateOtp")
    public BankResponse validateOtp(OtpValidationRequest request){
        return otpService.validateOtp(request);
    }
}
