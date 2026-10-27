package com.labtech.reservas.service.impl;

import com.labtech.reservas.model.Curso;
import com.labtech.reservas.repository.CursoRepository;
import com.labtech.reservas.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {

        return cursoRepository.findAll();
    }

    public Curso findById(Integer id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));
    }

    public Curso saveCurso(Curso curso) {
        curso.setId(null);
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Integer id, Curso curso) {
        Curso existente = findById(id);
        existente.setNome(curso.getNome());
        return cursoRepository.save(existente);
    }

    public void deleteCurso(Integer id) {
        findById(id);
        cursoRepository.deleteById(id);
    }
}
