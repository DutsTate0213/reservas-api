package com.labtech.reservas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record HorarioDto(
        @NotNull @NotEmpty String descricao,
        @NotNull LocalTime horarioInicio,
        @NotNull LocalTime horarioFim) {
}
