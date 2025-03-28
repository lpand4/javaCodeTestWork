package ru.pugovkinv.javacodetest.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Кошелек
 */
@Entity
@Data
@Table(name = "wallets")
public class Wallet {
    /**
     * Уникальный айди объекта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    /**
     * Сумма на кошельке
     */
    private Long amount;
}
