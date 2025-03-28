package ru.pugovkinv.javacodetest.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UncorrectAmountException extends RuntimeException{
    public UncorrectAmountException(String message) {
        super(message);
    }
}
