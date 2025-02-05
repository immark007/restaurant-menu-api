package com.mark.restaurant.menu.api.dto;

import com.mark.restaurant.menu.api.enums.UserRole;

public record RegisterDto(
        String email,
        String password,
        UserRole role
) {
}
