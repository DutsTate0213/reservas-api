package com.labtech.reservas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DisciplinaDto(@NotNull @NotEmpty String nome) {
}
