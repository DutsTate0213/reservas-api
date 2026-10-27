package com.labtech.reservas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CursoDto(@NotNull @NotEmpty String nome) {
}
