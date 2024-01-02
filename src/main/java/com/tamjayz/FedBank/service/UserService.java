package com.tamjayz.FedBank.service;

import com.tamjayz.FedBank.dto.*;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);

    BankResponse balanceEnquiry(EnquiryRequest request);
    String namedEnquiry(EnquiryRequest request);
    BankResponse debitAccount(CreditDebitRequest request);

    BankResponse creditAccount(CreditDebitRequest request);

    BankResponse transfer(TransferRequest request);
}
