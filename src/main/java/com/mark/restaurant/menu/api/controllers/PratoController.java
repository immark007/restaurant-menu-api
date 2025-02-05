package com.mark.restaurant.menu.api.controllers;


import com.mark.restaurant.menu.api.domain.Pratos;
import com.mark.restaurant.menu.api.dto.CreatePratoDto;
import com.mark.restaurant.menu.api.services.PratosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/pratos")
public class PratoController {
    @Autowired
    private PratosService pratosService;

    @PostMapping("/create")
    public ResponseEntity<Pratos> create(@RequestBody @Valid CreatePratoDto pratos){
        Pratos prato = pratosService.savePratos(pratos);
        return ResponseEntity.status(HttpStatus.CREATED).body(prato);
    }

    @GetMapping("listar")
    public ResponseEntity<Page<Pratos>> listar(Pageable pageable){
        Page<Pratos> pratos = pratosService.findAllPratos(pageable);
        return ResponseEntity.ok(pratos);
    }

    @DeleteMapping("/{pratoId}")
    public ResponseEntity<Void> delete(@PathVariable("pratoId") Long pratoId){
        pratosService.deletePrato(pratoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("buscar/{nome}")
    public ResponseEntity<Optional<Pratos>> buscarPorNome(@PathVariable("nome") String nome){
        Optional<Pratos> pratos = pratosService.findByName(nome);
        return ResponseEntity.ok(pratos);
    }
}
