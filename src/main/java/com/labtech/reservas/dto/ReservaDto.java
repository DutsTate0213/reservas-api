package com.labtech.reservas.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ReservaDto(
        String descricaoAtividade,
        @NotNull LocalDate dataReserva,
        @NotNull Integer usuarioId,
        @NotNull Integer reservaStatusId,
        @NotNull Integer reservaTipoId,
        @NotNull Integer horarioId,
        @NotNull Integer salaId,
        Integer disciplinaId,
        Integer cursoId) {
}
