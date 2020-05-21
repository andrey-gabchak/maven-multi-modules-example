package com.gabchak.services;

import com.gabchak.dto.WalletDto;

import java.util.List;
import java.util.Optional;

public interface WalletService {

    WalletDto insert(WalletDto walletDto);

    Optional<WalletDto> findById(Integer id);

    List<WalletDto> findAll();

    void deleteById(Integer id);
}
