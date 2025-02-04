package com.mark.restaurant.menu.api.repositories;

import com.mark.restaurant.menu.api.domain.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
