package com.moneymatters.data.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moneymatters.data.models.Bill;
import com.moneymatters.data.models.TransactionType;
import com.moneymatters.data.models.User;
import com.moneymatters.data.models.Wallet;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
public class TransactionDto {

    @NotNull(message = "User Id is required")
    private User user;

    @NotNull(message = "Wallet Id is required")
    private Wallet wallet;

    private Bill bill;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    @NotNull(message = "transactionType is required")
    private TransactionType transactionType;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime createdAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime updatedAt;

}
