package com.moneymatters.services;

import com.moneymatters.data.dtos.TransactionDto;
import com.moneymatters.data.dtos.TransactionTypeDto;
import com.moneymatters.data.mappers.TransactionDtoMapper;
import com.moneymatters.data.models.Transaction;
import com.moneymatters.data.models.TransactionType;
import com.moneymatters.repositories.TransactionTypeRepository;
import com.moneymatters.services.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeService {

    private TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    public TransactionType findById(Long id) {
        return transactionTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public TransactionType store(TransactionTypeDto transactionTypeDto) {
        TransactionType transactionType = new TransactionType();
        transactionType.setName(transactionTypeDto.getName());
        return transactionTypeRepository.save(transactionType);
    }

}
