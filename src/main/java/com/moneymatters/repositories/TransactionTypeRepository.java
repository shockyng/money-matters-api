package com.moneymatters.repositories;

import com.moneymatters.data.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType,Long> {
}
