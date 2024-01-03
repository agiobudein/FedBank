package com.tamjayz.FedBank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {

    @Schema(
            name = "The User Account Name"
    )

    private String accountName;
    @Schema(
            name = "The User Account Balance"
    )
    private BigDecimal accountBalance;
    @Schema(
            name = "The User Account Number"
    )
    private String accountNumber;
}
