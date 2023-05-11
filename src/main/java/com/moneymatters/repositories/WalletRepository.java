package com.moneymatters.repositories;

import com.moneymatters.data.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Query("SELECT w FROM Wallet w WHERE w.user = :userId")
    ArrayList<Wallet> walletFromUser(Long userId);
}