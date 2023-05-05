package com.moneymatters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moneymatters.models.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    
}
