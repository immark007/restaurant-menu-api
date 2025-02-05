package com.mark.restaurant.menu.api.services;

import com.mark.restaurant.menu.api.domain.Cardapio;
import com.mark.restaurant.menu.api.dto.CreateCardapioDto;
import com.mark.restaurant.menu.api.repositories.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {
    @Autowired
    private CardapioRepository cardapioRepository;

    public Cardapio save(CreateCardapioDto cardapioDto) {
        Cardapio cardapio = new Cardapio(cardapioDto.nome());
        return cardapioRepository.save(cardapio);
    }

    public Page<Cardapio> findAll(Pageable pageable) {
        return cardapioRepository.findAll(pageable);
    }


}
