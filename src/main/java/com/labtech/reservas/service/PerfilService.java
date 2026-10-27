package com.labtech.reservas.service;

import com.labtech.reservas.model.Perfil;

import java.util.List;

public interface PerfilService {

    public List<Perfil> findAll();

    public Perfil findById(Integer id);

    public Perfil savePerfil(Perfil perfil);

    public Perfil updatePerfil(Integer id, Perfil perfil);

    public void deletePerfil(Integer id);
}
