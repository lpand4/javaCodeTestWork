package ru.pugovkinv.javacodetest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pugovkinv.javacodetest.domain.Operation;
import ru.pugovkinv.javacodetest.domain.Wallet;
import ru.pugovkinv.javacodetest.enums.OperationType;
import ru.pugovkinv.javacodetest.exception.NotEnoughAmountException;
import ru.pugovkinv.javacodetest.exception.WalletNotFoundException;
import ru.pugovkinv.javacodetest.repository.WalletRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Сервис работы с кошельками
 */
@Service
@RequiredArgsConstructor
public class WalletService {
    /**
     * Репозиторий кошельков
     */
    private final WalletRepository walletRepository;



    /**
     * Получение кошелька по айди
     * @param id нужный айди
     * @return кошелек с данным айди
     */
    public Optional<Wallet> getWalletById(UUID id){
        return walletRepository.findById(id);
    }

    /**
     * Получение списка кошельков
     * @return список кошельков
     */
    public List<Wallet> getAllWallet(){
        return walletRepository.findAll();
    }
    public void updateWallet(Wallet wallet){
        walletRepository.save(wallet);
    }

    @Transactional
    public Optional<?> changeAmount(Operation operation){
        if (getWalletById(operation.getId()).isPresent()){
            Wallet wallet = getWalletById(operation.getId()).get();
            if (operation.getOperationType().equals(OperationType.DEPOSIT)){
                Long resultAmount = wallet.getAmount() + operation.getAmount();
                wallet.setAmount(resultAmount);
                updateWallet(wallet);
            }
            if (operation.getOperationType().equals(OperationType.WITHDRAW)){
                Long resultAmount = wallet.getAmount() - operation.getAmount();
                if (resultAmount < 0){
                    return Optional.of(new NotEnoughAmountException("На кошельке недостаточно средств для проведения данной операции!"));
                }else {
                    wallet.setAmount(resultAmount);
                    updateWallet(wallet);
                }
            }
            return Optional.of(wallet);
        }else return Optional.of(new WalletNotFoundException("Кошелька с таким айди в системе не обнаружено!"));
    }

}
