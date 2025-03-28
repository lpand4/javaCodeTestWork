package ru.pugovkinv.javacodetest.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Дто кошелька
 */
@Data
public class WalletDto {
    /**
     * Уникальный айди
     */
    private UUID id;
    /**
     * Сумма на кошельке
     */
    private Long amount;
}
