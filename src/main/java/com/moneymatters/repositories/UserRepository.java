package com.moneymatters.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moneymatters.data.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE CONCAT(u.email, '') LIKE %?1%")
    Page<User> findByEmail(String email, Pageable pageable);

    @Query("SELECT u FROM User u WHERE CONCAT(u.username, '') LIKE %?1%")
    Page<User> findByUsername(String username, Pageable pageable);
}
