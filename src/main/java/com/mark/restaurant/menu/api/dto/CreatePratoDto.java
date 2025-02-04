package com.mark.restaurant.menu.api.dto;

import com.mark.restaurant.menu.api.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

public record CreatePratoDto(
        @NotBlank @NotEmpty
        String nome,
        @URL
        @NotEmpty
        String imagemUrl,
        @Positive @NotEmpty
        BigDecimal price,
        Type tipo,
        Long cardapioId
) {
}
