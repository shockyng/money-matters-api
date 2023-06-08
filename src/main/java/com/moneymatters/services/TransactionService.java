package com.moneymatters.services;

import com.moneymatters.data.dtos.TransactionDto;
import com.moneymatters.data.mappers.TransactionDtoMapper;
import com.moneymatters.data.models.Transaction;
import com.moneymatters.repositories.TransactionRepository;
import com.moneymatters.services.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final WalletService walletService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService, WalletService walletService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
        this.walletService = walletService;
    }

    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public List<Transaction> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction store(TransactionDto transactionDto) {
        userService.findById(transactionDto.getUser().getId());
        walletService.findById(transactionDto.getWallet().getId());

        return transactionRepository.save(TransactionDtoMapper.INSTANCE.toTransaction(transactionDto));


    }

    public Transaction update(Long id, TransactionDto transactionDto) {
        Transaction transaction = findById(id);

        Transaction transactionUpdated = TransactionDtoMapper.INSTANCE.toTransaction(transactionDto);
        transactionUpdated.setId(transaction.getId());

        return transactionRepository.save(transactionUpdated);
    }

    public void delete(Long id) {
        findById(id);
        transactionRepository.deleteById(id);
    }

    public Page<Transaction> findByTransactionType(Long id, Pageable pageable) {
        return transactionRepository.findByTransactionType(id, pageable);
    }
}
