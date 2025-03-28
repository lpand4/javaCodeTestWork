package ru.pugovkinv.javacodetest.dto;

import org.springframework.stereotype.Component;
import ru.pugovkinv.javacodetest.domain.Wallet;

/**
 * Преоьразователь Dto в сущность и наоборот
 */
@Component
public class DtoMapper {

    /**
     * Преобразование кошелька в Дто
     * @param wallet кошелек
     * @return Дто кошелька
     */
    public WalletDto toWalletDto(Wallet wallet){
        WalletDto walletDto = new WalletDto();
        walletDto.setId(wallet.getId());
        walletDto.setAmount(wallet.getAmount());
        return walletDto;
    }

    /**
     * Преобразование из Дто в кошелек
     * @param walletDto Дто кошелька
     * @return кошелек
     */
    public Wallet toWallet(WalletDto walletDto){
        Wallet wallet = new Wallet();
        wallet.setId(walletDto.getId());
        wallet.setAmount(walletDto.getAmount());
        return wallet;
    }

}
