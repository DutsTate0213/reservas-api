package com.labtech.reservas.service;

import com.labtech.reservas.model.Curso;

import java.util.List;

public interface CursoService {

    public List<Curso> findAll();

    public Curso findById(Integer id);

    public Curso saveCurso(Curso curso);

    public Curso updateCurso(Integer id, Curso curso);

    public void deleteCurso(Integer id);
}
