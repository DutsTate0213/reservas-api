package com.labtech.reservas.service;

import com.labtech.reservas.model.Sala;

import java.util.List;

public interface SalaService {

    public List<Sala> findAll();

    public Sala findById(Integer id);

    public Sala saveSala(Sala sala, Integer edificioId, Integer salaTipoId);

    public Sala updateSala(Integer id, Sala sala, Integer edificioId, Integer salaTipoId);

    public void deleteSala(Integer id);
}
