package ru.pugovkinv.javacodetest.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.pugovkinv.javacodetest.enums.OperationType;

import java.util.UUID;

@Data
public class Operation {
    @NotNull
    private UUID id;
    @NotNull
    private OperationType operationType;
    @Positive
    private Long amount;
}
