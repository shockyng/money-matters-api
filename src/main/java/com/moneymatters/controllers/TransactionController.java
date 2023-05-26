package com.moneymatters.controllers;

import com.moneymatters.data.dtos.TransactionDto;
import com.moneymatters.data.models.Transaction;
import com.moneymatters.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Transaction findById(@PathVariable("id") Long id) {
        return transactionService.findById(id);
    }

    @GetMapping("/type/{id}")
    public Page<Transaction> findByTransactionType(@PathVariable("id") Long id, Pageable pageable) {
        return transactionService.findByTransactionType(id, pageable);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> findByUserId(@PathVariable("userId") Long userId) {
        return transactionService.findByUserId(userId);
    }

    @PostMapping
    public Transaction store(@RequestBody TransactionDto transactionDto) {
        return transactionService.store(transactionDto);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable("id") Long id, @RequestBody TransactionDto transactionDto) {
        return transactionService.update(id, transactionDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        transactionService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }

}
