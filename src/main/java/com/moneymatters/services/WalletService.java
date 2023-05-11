package com.moneymatters.services;

import com.moneymatters.data.dtos.WalletDto;
import com.moneymatters.data.models.User;
import com.moneymatters.data.models.Wallet;
import com.moneymatters.repositories.WalletRepository;
import com.moneymatters.services.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final UserService userService;

    public WalletService(WalletRepository walletRepository, UserService userService) {
        this.walletRepository = walletRepository;
        this.userService = userService;
    }

    public ArrayList<Wallet> getByUser(Long id) {
        return (ArrayList<Wallet>) walletRepository.walletFromUser(id);
    }

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Wallet findById(Long id) {
        return walletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public Wallet store(WalletDto walletDto) {
        Wallet wallet = createWalletReceivingDto(walletDto);
        return walletRepository.save(wallet);
    }

    public Wallet update(Long id, WalletDto walletDto) {

        Wallet wallet = findById(id);
        wallet.setName(walletDto.getName());

        return walletRepository.save(wallet);
    }

    private Wallet createWalletReceivingDto(WalletDto walletDto) {
        Wallet wallet = new Wallet();

        User user = userService.findById(walletDto.getUserId());

        wallet.setName(walletDto.getName());
        wallet.setUser(user);

        return wallet;
    }
}