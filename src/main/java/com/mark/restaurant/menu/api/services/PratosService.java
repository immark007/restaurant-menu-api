package com.mark.restaurant.menu.api.services;

import com.mark.restaurant.menu.api.domain.Cardapio;
import com.mark.restaurant.menu.api.domain.Pratos;
import com.mark.restaurant.menu.api.dto.CreatePratoDto;
import com.mark.restaurant.menu.api.repositories.CardapioRepository;
import com.mark.restaurant.menu.api.repositories.PratosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratosService {
    @Autowired
    private PratosRepository pratosRepository;

    @Autowired
    private CardapioRepository cardapioRepository;

    public Pratos savePratos(CreatePratoDto createPratoDto) {
        Cardapio cardapio = cardapioRepository.findById(createPratoDto.cardapioId())
                .orElseThrow(() -> new RuntimeException("Cardápio não encontrado"));

        Pratos prato = new Pratos(createPratoDto.nome(), createPratoDto.imagemUrl(), createPratoDto.price(), createPratoDto.tipo(), cardapio);

        return pratosRepository.save(prato);
    }

    public List<Pratos> findAllPratos() {
        return pratosRepository.findAll();
    }
}
