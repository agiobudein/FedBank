package com.tamjayz.FedBank.service;

import com.tamjayz.FedBank.dto.BankResponse;
import com.tamjayz.FedBank.dto.UserRequest;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);
}
