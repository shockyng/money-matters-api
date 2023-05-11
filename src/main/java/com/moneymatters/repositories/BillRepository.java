package com.moneymatters.repositories;

import com.moneymatters.data.models.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT b FROM Bill b WHERE CONCAT(b.name, '') LIKE %?1%")
    Page<Bill> findAllByNamePaged(String name, Pageable pageable);

    @Query("SELECT b FROM Bill b WHERE CONCAT(b.description, '') LIKE %?1%")
    Page<Bill> findAllByDescriptionPaged(String description, Pageable pageable);

    @Query("SELECT b FROM Bill b WHERE CONCAT(b.paymentType, '') LIKE %?1%")
    Page<Bill> findAllByPaymentTypePaged(String paymentType, Pageable pageable);

    @Query("SELECT b FROM Bill b WHERE CONCAT(b.installments, '') LIKE %?1%")
    Page<Bill> findAllByInstallmentsPaged(Integer installments, Pageable pageable);

    @Query("SELECT b FROM Bill b WHERE CONCAT(b.dueDate, '') LIKE %?1%")
    Page<Bill> findAllByDueDatePaged(Date dueDate, Pageable pageable);

}