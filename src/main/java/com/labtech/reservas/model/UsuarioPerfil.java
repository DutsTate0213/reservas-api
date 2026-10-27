package com.labtech.reservas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_perfil")
@Getter
@Setter
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Perfil perfil;

}
