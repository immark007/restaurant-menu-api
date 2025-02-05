package com.mark.restaurant.menu.api.repositories;

import com.mark.restaurant.menu.api.domain.Pratos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PratosRepository extends JpaRepository<Pratos, Long> {
    Optional<Pratos> findByNome(String nome);
}
