package dev.tadeupinheiro.apibudgettissue.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRecordDto (
        @NotNull Integer idProduct,
    @NotBlank String name,
    @NotNull Float tissueConsumption,
    @NotNull Float threadConsumption,
    @NotNull Float elasticConsumption,
    @NotBlank String idThread,
    @NotNull BigDecimal buttonCost,
    @NotNull BigDecimal sewingCost,
    @NotNull BigDecimal finishingCost,
    @NotNull BigDecimal interliningCost,
    @NotNull Integer idStripConfiguration,
    @NotNull Integer idStripReflectiveTypes,
    @NotNull String color,
    @NotNull BigDecimal costPriceTissue,
    @Size(max = 30) String mark,
    @NotNull Float width,
    @NotNull Float length,
    @NotNull BigDecimal costPriceElastic

) {}
