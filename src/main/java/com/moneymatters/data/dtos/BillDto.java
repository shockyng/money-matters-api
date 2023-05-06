package com.moneymatters.data.dtos;

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
    private String name;
    private String description;
    private String paymentType;
    private Integer installments;
    private String dueDate;

}
