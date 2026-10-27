package com.labtech.reservas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SalaDto(
        @NotNull @NotEmpty String nome,
        @NotNull @Positive Integer capacidade,
        @NotNull Integer edificioId,
        @NotNull Integer salaTipoId) {
}
