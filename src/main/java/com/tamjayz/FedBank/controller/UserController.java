package com.tamjayz.FedBank.controller;

import com.tamjayz.FedBank.dto.*;
import com.tamjayz.FedBank.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User Account Management APIs")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Create new User Account",
            description = "Creating a new user and assigning a new account ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "http status 201 created"
    )
    @PostMapping("/users")
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }

    @PostMapping("/login")
    public BankResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }

    @PostMapping("/debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }

    @PostMapping("/transfer")
    public BankResponse transfer(@RequestBody TransferRequest request){
        return userService.transfer(request);
    }

    @Operation(
            summary = "Balance Enquiry",
            description = "Given an Account number and check how much in the account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http status 200 success"
    )

    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }

    @GetMapping("/name")
    public String namedEnquiry(EnquiryRequest request){
        return userService.namedEnquiry(request);
    }
}
