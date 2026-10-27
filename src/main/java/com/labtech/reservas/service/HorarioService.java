package com.labtech.reservas.service;

import com.labtech.reservas.model.Horario;

import java.util.List;

public interface HorarioService {

    public List<Horario> findAll();

    public Horario findById(Integer id);

    public Horario saveHorario(Horario horario);

    public Horario updateHorario(Integer id, Horario horario);

    public void deleteHorario(Integer id);
}
