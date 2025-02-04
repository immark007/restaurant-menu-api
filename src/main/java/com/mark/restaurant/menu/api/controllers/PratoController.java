package com.mark.restaurant.menu.api.controllers;


import com.mark.restaurant.menu.api.domain.Pratos;
import com.mark.restaurant.menu.api.dto.CreatePratoDto;
import com.mark.restaurant.menu.api.services.PratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoController {
    @Autowired
    private PratosService pratosService;

    @PostMapping("/create")
    public ResponseEntity<Pratos> create(@RequestBody CreatePratoDto pratos){
        Pratos prato = pratosService.savePratos(pratos);
        return ResponseEntity.ok(prato);
    }

    @GetMapping("listar")
    public ResponseEntity<List<Pratos>> listar(){
        List<Pratos> pratos = pratosService.findAllPratos();
        return new ResponseEntity<>(pratos, HttpStatus.OK);
    }
}
