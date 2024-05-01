package com.github.lucasramallo.project.core.dtos;

import java.math.BigDecimal;

public record TransferRequestDTO(
        BigDecimal value,
        String payer,
        String payee
) {}
