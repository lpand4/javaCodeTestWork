package ru.pugovkinv.javacodetest.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.pugovkinv.javacodetest.enums.OperationType;

import java.util.UUID;

/**
 * Операция о переводе
 */
@Data
public class Operation {
    /**
     * Уникальный айди кошелька
     */
    @NotNull
    private UUID id;
    /**
     * Тип операции
     */
    @NotNull
    private OperationType operationType;
    /**
     * Сумма перевода
     */
    @Positive
    private Long amount;
}
