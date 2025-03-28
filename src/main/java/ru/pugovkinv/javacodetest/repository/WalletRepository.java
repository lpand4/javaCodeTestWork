package ru.pugovkinv.javacodetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pugovkinv.javacodetest.domain.Wallet;

import java.util.UUID;

/**
 * Репозиторий кошельков
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}
