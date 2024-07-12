package dev.tadeupinheiro.apibudgettissue.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TissueRecordDto(
        @NotNull String color,
        @NotNull BigDecimal costPrice
        ) {
}
