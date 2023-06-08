package com.moneymatters.data.mappers;

import com.moneymatters.data.dtos.TransactionDto;
import com.moneymatters.data.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionDtoMapper {

    TransactionDtoMapper INSTANCE = Mappers.getMapper(TransactionDtoMapper.class);

    Transaction toTransaction(TransactionDto transactionDto);

}
