package com.mark.restaurant.menu.api.domain;

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
    private Type tipo;
}
