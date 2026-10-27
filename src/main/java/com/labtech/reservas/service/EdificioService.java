package com.labtech.reservas.service;

import com.labtech.reservas.model.Edificio;

import java.util.List;

public interface EdificioService {

    public List<Edificio> findAll();

    public Edificio findById(Integer id);

    public Edificio saveEdificio(Edificio edificio);

    public Edificio updateEdificio(Integer id, Edificio edificio);

    public void deleteEdificio(Integer id);
}
