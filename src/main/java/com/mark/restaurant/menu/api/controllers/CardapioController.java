package com.mark.restaurant.menu.api.controllers;


import com.mark.restaurant.menu.api.domain.Cardapio;
import com.mark.restaurant.menu.api.dto.CreateCardapioDto;
import com.mark.restaurant.menu.api.services.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {
    @Autowired
    private CardapioService cardapioService;

    @PostMapping("/create")
    public ResponseEntity<Cardapio> criarCardapio(@RequestBody CreateCardapioDto cardapioDto) {
        Cardapio cardapio = cardapioService.save(cardapioDto);
        return ResponseEntity.ok(cardapio);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cardapio>> listarCardapio() {
        List<Cardapio> cardapios = cardapioService.findAll();
        return ResponseEntity.ok(cardapios);
    }
}
