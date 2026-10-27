package com.labtech.reservas.service.impl;

import com.labtech.reservas.model.Edificio;
import com.labtech.reservas.model.Sala;
import com.labtech.reservas.model.SalaTipo;
import com.labtech.reservas.repository.EdificioRepository;
import com.labtech.reservas.repository.SalaRepository;
import com.labtech.reservas.repository.SalaTipoRepository;
import com.labtech.reservas.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private SalaTipoRepository salaTipoRepository;

    public List<Sala> findAll() {

        return salaRepository.findAll();
    }

    public Sala findById(Integer id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));
    }

    public Sala saveSala(Sala sala, Integer edificioId, Integer salaTipoId) {
        sala.setId(null);
        sala.setEdificio(buscarEdificio(edificioId));
        sala.setSalaTipo(buscarSalaTipo(salaTipoId));
        return salaRepository.save(sala);
    }

    public Sala updateSala(Integer id, Sala sala, Integer edificioId, Integer salaTipoId) {
        Sala existente = findById(id);
        existente.setNome(sala.getNome());
        existente.setCapacidade(sala.getCapacidade());
        existente.setEdificio(buscarEdificio(edificioId));
        existente.setSalaTipo(buscarSalaTipo(salaTipoId));
        return salaRepository.save(existente);
    }

    public void deleteSala(Integer id) {
        findById(id);
        salaRepository.deleteById(id);
    }

    private Edificio buscarEdificio(Integer edificioId) {
        return edificioRepository.findById(edificioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Edifício não encontrado"));
    }

    private SalaTipo buscarSalaTipo(Integer salaTipoId) {
        return salaTipoRepository.findById(salaTipoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de sala não encontrado"));
    }
}
