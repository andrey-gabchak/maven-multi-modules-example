package com.gabchak.dto.mappers;

import com.gabchak.dto.WalletDto;
import com.gabchak.models.Currency;
import com.gabchak.models.Wallet;
import com.gabchak.repositories.CurrencyRepository;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper extends ConfigurableMapper {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public WalletMapper(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Wallet.class, WalletDto.class)
                .exclude("currency")
                .exclude("records")
                .customize(new CustomMapper<Wallet, WalletDto>() {
                    @Override
                    public void mapAtoB(Wallet wallet, WalletDto walletDto, MappingContext context) {
                        super.mapAtoB(wallet, walletDto, context);
                        walletDto.setCurrencyId(wallet.getCurrency().getId());
                    }

                    @Override
                    public void mapBtoA(WalletDto walletDto, Wallet wallet, MappingContext context) {
                        super.mapBtoA(walletDto, wallet, context);
                        Currency currency = currencyRepository.getOne(walletDto.getCurrencyId());
                        wallet.setCurrency(currency);
                    }
                })
                .byDefault()
                .register();
    }
}
