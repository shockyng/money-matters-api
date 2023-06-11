package com.moneymatters.repositories;

import com.moneymatters.data.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE CONCAT(u.email, '') LIKE %?1%")
    Page<User> searchByEmail(String email, Pageable pageable);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE CONCAT(u.username, '') LIKE %?1%")
    Page<User> searchByUsername(String username, Pageable pageable);

    Optional<User> findByUsername(String username);

    @Query("SELECT COUNT(u) FILTER(WHERE EXTRACT(MONTH FROM u.createdAt) = EXTRACT(MONTH FROM CURRENT DATE )) AS currentMonth, " +
            "(SELECT COUNT(*) FROM User u2 WHERE EXTRACT(MONTH FROM u2.createdAt) = (EXTRACT(MONTH FROM CURRENT DATE)-1)) as lastMonth FROM User u")
    String usersFromMonth();
}