package com.moneymatters.data.mappers;

import com.moneymatters.data.dtos.SaleDto;
import com.moneymatters.data.models.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleDtoMapper {

    SaleDtoMapper INSTANCE = Mappers.getMapper(SaleDtoMapper.class);

    @Mapping(target = "user", source = "userId", ignore = true)
    Sale toSale(SaleDto saleDto);

}