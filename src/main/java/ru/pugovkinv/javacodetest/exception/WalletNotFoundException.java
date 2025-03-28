package ru.pugovkinv.javacodetest.exception;

import lombok.NoArgsConstructor;

/**
 * Ошибка отсутствия кошелька
 */
@NoArgsConstructor
public class WalletNotFoundException extends RuntimeException{
    public WalletNotFoundException(String message) {
        super(message);
    }
}
