package com.tamjayz.FedBank.service;

import com.tamjayz.FedBank.dto.TransactionDto;
import com.tamjayz.FedBank.model.Transaction;

public interface TransactionService {

    void saveTransaction(TransactionDto transactionDto);
}
