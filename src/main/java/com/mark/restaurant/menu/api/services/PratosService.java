package com.mark.restaurant.menu.api.services;

import com.mark.restaurant.menu.api.domain.Cardapio;
import com.mark.restaurant.menu.api.domain.Pratos;
import com.mark.restaurant.menu.api.dto.CreatePratoDto;
import com.mark.restaurant.menu.api.exceptions.BadRequestExecption;
import com.mark.restaurant.menu.api.exceptions.NotFoundException;
import com.mark.restaurant.menu.api.repositories.CardapioRepository;
import com.mark.restaurant.menu.api.repositories.PratosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PratosService {
    @Autowired
    private PratosRepository pratosRepository;

    @Autowired
    private CardapioRepository cardapioRepository;

    @Transactional
    public Pratos savePratos(CreatePratoDto createPratoDto) {
        Cardapio cardapio = cardapioRepository.findById(createPratoDto.cardapioId())
                .orElseThrow(() -> new BadRequestExecption("Cardápio não encontrado"));

        Pratos prato = new Pratos(createPratoDto.nome(), createPratoDto.imagemUrl(), createPratoDto.price(), createPratoDto.tipo(), cardapio);

        return pratosRepository.save(prato);
    }

    public Page<Pratos> findAllPratos(Pageable pageable) {
        return pratosRepository.findAll(pageable);
    }

    public void deletePrato(Long id) {
        if(!pratosRepository.existsById(id)) {
            throw new NotFoundException("Prato não encontrado");
        }
        pratosRepository.deleteById(id);
    }

    public Optional<Pratos> findByName(String name) {
        if(pratosRepository.findByNome(name).isEmpty()) {
            throw  new NotFoundException("Prato não encontrado");
        }
        return pratosRepository.findByNome(name);
    }


}
