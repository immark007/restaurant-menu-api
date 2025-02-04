package com.mark.restaurant.menu.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateCardapioDto(
        @NotEmpty
        @NotBlank
        String nome
) {
}
