package com.mark.restaurant.menu.api.dto;

import com.mark.restaurant.menu.api.enums.Type;

import java.math.BigDecimal;

public record CreatePratoDto(
        String nome,
        String imagemUrl,
        BigDecimal price,
        Type tipo,
        Long cardapioId
) {
}
