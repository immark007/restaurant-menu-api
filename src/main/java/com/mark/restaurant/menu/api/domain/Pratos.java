package com.mark.restaurant.menu.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mark.restaurant.menu.api.enums.Type;
import jakarta.persistence.*;

import java.math.BigDecimal;


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

    public Pratos() {
    }

    public Pratos(String nome, String imagemUrl, BigDecimal price, Type tipo, Cardapio cardapios) {
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.price = price;
        this.tipo = tipo;
        this.cardapios = cardapios;
    }

    public Cardapio getCardapios() {
        return cardapios;
    }

    public void setCardapios(Cardapio cardapios) {
        this.cardapios = cardapios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
}
