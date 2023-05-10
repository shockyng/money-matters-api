package com.moneymatters.data.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SaleDto {
    private Long userId;
    private Double price;
    private Boolean status;
    private int contractType;
}
