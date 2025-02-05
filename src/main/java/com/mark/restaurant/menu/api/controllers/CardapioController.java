package com.mark.restaurant.menu.api.controllers;

import com.mark.restaurant.menu.api.domain.Cardapio;
import com.mark.restaurant.menu.api.dto.CreateCardapioDto;
import com.mark.restaurant.menu.api.services.CardapioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {
    @Autowired
    private CardapioService cardapioService;

    @PostMapping("/create")
    public ResponseEntity<Cardapio> criarCardapio(@RequestBody @Valid CreateCardapioDto cardapioDto) {
        Cardapio cardapio = cardapioService.save(cardapioDto);
        return ResponseEntity.ok(cardapio);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Cardapio>> listarCardapio(Pageable pageable) {
        Page<Cardapio> cardapios = cardapioService.findAll(pageable);
        return ResponseEntity.ok(cardapios);
    }
}
