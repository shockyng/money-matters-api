package com.moneymatters.data.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletDto {

    @Positive(message = "User id must be greater than 0")
    private Long userId;
    @NotBlank(message = "value cannot be null or blank.")
    private String name;

}