package dev.tadeupinheiro.apibudgettissue.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StripRecordDto (
        @NotNull Integer idStripConfiguration,
        @NotNull double sleeve,
        @NotNull double abdomenHorizontal,
        @NotNull double abdomenUprightDual
){
}
