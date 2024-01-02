package com.tamjayz.FedBank.service;

import com.tamjayz.FedBank.dto.BankResponse;
import com.tamjayz.FedBank.dto.CreditDebitRequest;
import com.tamjayz.FedBank.dto.EnquiryRequest;
import com.tamjayz.FedBank.dto.UserRequest;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);

    BankResponse balanceEnquiry(EnquiryRequest request);
    String namedEnquiry(EnquiryRequest request);

    BankResponse CreditAccount(CreditDebitRequest request);
}
