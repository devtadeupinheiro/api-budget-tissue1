package dev.tadeupinheiro.apibudgettissue.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ThreadRollRecordDto(
        @NotBlank String name,
        @NotNull BigDecimal costPriceRoll,
        @NotNull double size,
        @NotBlank String type
) {
}
