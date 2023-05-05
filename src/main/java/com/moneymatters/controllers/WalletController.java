package com.moneymatters.controllers;

import com.moneymatters.dtos.WalletDto;
import com.moneymatters.models.Wallet;
import com.moneymatters.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    public ResponseEntity<List<Wallet>> findAll() {
        List<Wallet> wallet = walletService.findAll();
        return ResponseEntity.ok().body(wallet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> findById(@PathVariable("id") Long id) {
        Wallet wallet = walletService.findById(id);
        return ResponseEntity.ok().body(wallet);
    }

    @PostMapping
    public ResponseEntity<Wallet> store(@RequestBody WalletDto walletDto) {
        Wallet wallet = walletService.store(walletDto);
        return ResponseEntity.ok().body(wallet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wallet> update(@PathVariable("id") Long id, @RequestBody WalletDto walletDto) {
        Wallet wallet = walletService.update(id, walletDto);
        return ResponseEntity.ok().body(wallet);
    }



}
