package com.moneymatters.data.mappers;

import com.moneymatters.data.dtos.SaleDto;
import com.moneymatters.data.models.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleDtoMapper {

    SaleDtoMapper INSTANCE = Mappers.getMapper(SaleDtoMapper.class);

    Sale toSale(SaleDto saleDto);

}