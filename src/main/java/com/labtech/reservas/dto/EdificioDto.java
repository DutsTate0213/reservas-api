package com.labtech.reservas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EdificioDto(@NotNull @NotEmpty String nome) {
}
