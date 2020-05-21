package com.gabchak.services.impl;

import com.gabchak.dto.WalletDto;
import com.gabchak.dto.mappers.WalletMapper;
import com.gabchak.models.Wallet;
import com.gabchak.repositories.WalletRepository;
import com.gabchak.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository,
                             WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }


    @Override
    public WalletDto insert(WalletDto walletDto) {
        Wallet wallet = walletMapper.map(walletDto, Wallet.class);
        Wallet savedWallet = walletRepository.save(wallet);
        return walletMapper.map(savedWallet, WalletDto.class);
    }

    @Override
    public Optional<WalletDto> findById(Integer id) {
        return walletRepository.findById(id)
                .map(wallet -> walletMapper.map(wallet, WalletDto.class));
    }

    @Override
    public List<WalletDto> findAll() {
        return walletMapper.mapAsList(walletRepository.findAll(), WalletDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        walletRepository.deleteById(id);
    }
}
