package com.mark.restaurant.menu.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mark.restaurant.menu.api.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pratos")
public class Pratos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "imagem_url")
    private String imagemUrl;
    private BigDecimal price;
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private Type tipo;

    @ManyToOne
    @JoinColumn(name = "cardapio_id", nullable = false)
    @JsonIgnore
    @JsonBackReference
    private Cardapio cardapios;


    public Pratos(String nome, String imagemUrl, BigDecimal price, Type tipo, Cardapio cardapios) {
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.price = price;
        this.tipo = tipo;
        this.cardapios = cardapios;
    }

}
