package com.labtech.reservas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UsuarioDto(
        @NotNull @NotEmpty String nome,
        @NotNull @NotEmpty @Email String email,
        String telefone,
        @NotNull @NotEmpty String senha,
        Boolean ativo) {
}
