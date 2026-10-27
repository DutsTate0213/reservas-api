package com.labtech.reservas.service.impl;

import com.labtech.reservas.model.Edificio;
import com.labtech.reservas.repository.EdificioRepository;
import com.labtech.reservas.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EdificioServiceImpl implements EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public List<Edificio> findAll() {

        return edificioRepository.findAll();
    }

    public Edificio findById(Integer id) {
        return edificioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Edifício não encontrado"));
    }

    public Edificio saveEdificio(Edificio edificio) {
        edificio.setId(null);
        return edificioRepository.save(edificio);
    }

    public Edificio updateEdificio(Integer id, Edificio edificio) {
        Edificio existente = findById(id);
        existente.setNome(edificio.getNome());
        return edificioRepository.save(existente);
    }

    public void deleteEdificio(Integer id) {
        findById(id);
        edificioRepository.deleteById(id);
    }
}
