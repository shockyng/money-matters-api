package com.moneymatters.repositories;

import com.moneymatters.data.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT COUNT(s) FILTER(WHERE EXTRACT(MONTH FROM s.createdAt) = EXTRACT(MONTH FROM CURRENT DATE )) AS currentMonth, " +
            "(SELECT COUNT(*) FROM Sale s2 WHERE EXTRACT(MONTH FROM s2.createdAt) = (EXTRACT(MONTH FROM CURRENT DATE)-1)) as lastMonth FROM Sale s")
    String getSalesComparedToPastMonth();
}