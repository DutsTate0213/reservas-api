package com.labtech.reservas.service.impl;

import com.labtech.reservas.model.Perfil;
import com.labtech.reservas.repository.PerfilRepository;
import com.labtech.reservas.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> findAll() {

        return perfilRepository.findAll();
    }

    public Perfil findById(Integer id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado"));
    }

    public Perfil savePerfil(Perfil perfil) {
        perfil.setId(null);
        return perfilRepository.save(perfil);
    }

    public Perfil updatePerfil(Integer id, Perfil perfil) {
        Perfil existente = findById(id);
        existente.setNome(perfil.getNome());
        return perfilRepository.save(existente);
    }

    public void deletePerfil(Integer id) {
        findById(id);
        perfilRepository.deleteById(id);
    }
}
