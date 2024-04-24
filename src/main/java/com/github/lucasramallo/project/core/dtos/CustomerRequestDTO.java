package com.github.lucasramallo.project.core.dtos;

import com.github.lucasramallo.project.core.domain.customer.enums.CustomerType;

public record CustomerRequestDTO(
        String document,
        String name,
        String email,
        CustomerType type,
        String password

) {
}
