package com.moneymatters.data.mappers;

import com.moneymatters.data.dtos.BillDto;
import com.moneymatters.data.models.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Mapper
public interface BillDtoMapper {
    BillDtoMapper INSTANCE = Mappers.getMapper(BillDtoMapper.class);

    @Mapping(source = "dueDate", target = "dueDate", qualifiedByName = "stringToDate")
    Bill toBill(BillDto billDto);

    @Named("stringToDate")
    default Date stringToDate(String value) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = dateFormat.parse(value);
            return new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("Error during date updating");
        }
    }
}