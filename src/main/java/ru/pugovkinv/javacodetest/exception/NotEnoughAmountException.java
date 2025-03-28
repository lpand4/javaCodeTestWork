package ru.pugovkinv.javacodetest.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotEnoughAmountException extends RuntimeException{
    public NotEnoughAmountException(String message) {
        super(message);
    }
}
