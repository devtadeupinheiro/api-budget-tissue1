package dev.tadeupinheiro.apibudgettissue.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ElasticRecordDto(
        String mark,
        @NotNull Float width,
        @NotNull Float length,
        @NotNull BigDecimal costPrice

        ) {
}
