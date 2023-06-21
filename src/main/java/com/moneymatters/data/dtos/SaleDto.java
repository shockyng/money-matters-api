package com.moneymatters.data.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDto {
    
    @DecimalMin(value = "0.0", message = "Price must be greater than 0")
    @NotNull(message = "Price cannot be null")
    private Double price;

    private Boolean status;

    @Positive(message = "Contract type must be greater than 0")
    private int contractType;
}