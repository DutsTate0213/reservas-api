package com.labtech.reservas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
@Table (name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer capacidade;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @ManyToOne
    @JoinColumn(name = "sala_tipo_id")
    private SalaTipo salaTipo;
}
