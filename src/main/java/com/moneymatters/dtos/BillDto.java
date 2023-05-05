package com.moneymatters.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    private Double price;
    @NotEmpty
	private String name;
    @NotBlank
    private String description;
    private String paymentType;
    private Integer installments;
    private String dueDate;
    
}
