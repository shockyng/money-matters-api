package com.moneymatters.data.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDto {

    @DecimalMin(value = "0.0", message = "Price must be greater than 0")
    @NotNull(message = "Price cannot be null")
    private Double price;

    @Size(min = 3, message = "Name must have 3 more caracter")
    private String name;

    private String description;

    @NotBlank(message = "Payment type is required.")
    private String paymentType;

    @PositiveOrZero(message = "Installments Must be greater than 0")
    private Integer installments;

    @NotBlank(message = "Due date type is required.")
    private String dueDate;
}