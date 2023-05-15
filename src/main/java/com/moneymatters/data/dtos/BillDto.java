package com.moneymatters.data.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDto {

    private Double price;
    private String name;
    private String description;
    private String paymentType;
    private Integer installments;
    private String dueDate;

}