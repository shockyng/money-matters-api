package com.moneymatters.repositories;

import com.moneymatters.data.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);

    @Query("SELECT t FROM Transaction t WHERE t.transactionType.id = :id")
    Page<Transaction> findByTransactionType(Long id, Pageable pageable);
}
