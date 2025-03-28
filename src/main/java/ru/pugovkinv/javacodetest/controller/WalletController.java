package ru.pugovkinv.javacodetest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pugovkinv.javacodetest.domain.Operation;
import ru.pugovkinv.javacodetest.domain.Wallet;
import ru.pugovkinv.javacodetest.dto.DtoMapper;
import ru.pugovkinv.javacodetest.dto.WalletDto;
import ru.pugovkinv.javacodetest.exception.WalletNotFoundException;
import ru.pugovkinv.javacodetest.service.WalletService;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Контроллер кошельков
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class WalletController {
    /**
     * Сервис для работы с кошельками
     */
    private final WalletService walletService;
    private final DtoMapper dtoMapper;

    /**
     * Получение кошелька по его айди
     * @param wallet_uuid айди кошелька
     * @return кошелек, если такого кошелька нет, то ошибка
     */
    @GetMapping("/wallets/{wallet_uuid}")
    public ResponseEntity<?> getWalletById(@PathVariable UUID wallet_uuid){
        Optional<Wallet> wallet = walletService.getWalletById(wallet_uuid);
        if (wallet.isEmpty()){
            return ResponseEntity.badRequest().body(new WalletNotFoundException("Кошелек с данным айди отсутствует в системе"));
        }
        return new ResponseEntity<>(dtoMapper.toWalletDto(wallet.get()), HttpStatus.OK);
    }
    @GetMapping("/wallets")
    public ResponseEntity<List<WalletDto>> getAllWallet(){
        List<WalletDto> dtoWallets = walletService.getAllWallet().stream()
                .map(dtoMapper::toWalletDto)
                .toList();
        return new ResponseEntity<>(dtoWallets, HttpStatus.OK);
    }

    @PostMapping("/wallet")
    public ResponseEntity<?> changeAmount(@RequestBody Operation operation){
        Optional<?> result = walletService.changeAmount(operation);
        if (result.get().getClass()== Wallet.class){
            return new ResponseEntity<>(dtoMapper.toWalletDto((Wallet) result.get()), HttpStatus.OK);
        }else
            return ResponseEntity.badRequest().body(result.get());
    }

}
