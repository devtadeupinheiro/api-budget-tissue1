package dev.tadeupinheiro.apibudgettissue.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PaintingRecordDto(
        @NotNull Integer id,
        @NotBlank String size,
        @NotNull @Positive BigDecimal price

) {
}
