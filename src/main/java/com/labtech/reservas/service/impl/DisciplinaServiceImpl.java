package com.labtech.reservas.service.impl;

import com.labtech.reservas.model.Disciplina;
import com.labtech.reservas.repository.DisciplinaRepository;
import com.labtech.reservas.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> findAll() {

        return disciplinaRepository.findAll();
    }

    public Disciplina findById(Integer id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));
    }

    public Disciplina saveDisciplina(Disciplina disciplina) {
        disciplina.setId(null);
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina updateDisciplina(Integer id, Disciplina disciplina) {
        Disciplina existente = findById(id);
        existente.setNome(disciplina.getNome());
        return disciplinaRepository.save(existente);
    }

    public void deleteDisciplina(Integer id) {
        findById(id);
        disciplinaRepository.deleteById(id);
    }
}
