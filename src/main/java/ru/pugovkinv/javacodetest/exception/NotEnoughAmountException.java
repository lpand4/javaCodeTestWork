package ru.pugovkinv.javacodetest.exception;

import lombok.NoArgsConstructor;

/**
 * Ошибка недосаточного кол-ва средств на кошельке
 */
@NoArgsConstructor
public class NotEnoughAmountException extends RuntimeException{
    public NotEnoughAmountException(String message) {
        super(message);
    }
}
