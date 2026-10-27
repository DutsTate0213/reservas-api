package com.labtech.reservas.service;

import com.labtech.reservas.model.Disciplina;

import java.util.List;

public interface DisciplinaService {

    public List<Disciplina> findAll();

    public Disciplina findById(Integer id);

    public Disciplina saveDisciplina(Disciplina disciplina);

    public Disciplina updateDisciplina(Integer id, Disciplina disciplina);

    public void deleteDisciplina(Integer id);
}
