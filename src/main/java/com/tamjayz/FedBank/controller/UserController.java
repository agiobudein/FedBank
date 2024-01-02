package com.tamjayz.FedBank.controller;

import com.tamjayz.FedBank.dto.BankResponse;
import com.tamjayz.FedBank.dto.CreditDebitRequest;
import com.tamjayz.FedBank.dto.EnquiryRequest;
import com.tamjayz.FedBank.dto.UserRequest;
import com.tamjayz.FedBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }

    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }

    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }

    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }

    @GetMapping("/name")
    public String namedEnquiry(EnquiryRequest request){
        return userService.namedEnquiry(request);
    }
}
