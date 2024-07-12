package dev.tadeupinheiro.apibudgettissue.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record StripReflectiveTypesDto(
        @NotBlank String name,
        @NotNull @Positive BigDecimal price,
        @NotNull Float width,
        @NotBlank String typeTreatment,
        @NotBlank String typeMaterial
        ) {
}
