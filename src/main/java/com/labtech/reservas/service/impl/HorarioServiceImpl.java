package com.labtech.reservas.service.impl;

import com.labtech.reservas.model.Horario;
import com.labtech.reservas.repository.HorarioRepository;
import com.labtech.reservas.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> findAll() {

        return horarioRepository.findAll();
    }

    public Horario findById(Integer id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Horário não encontrado"));
    }

    public Horario saveHorario(Horario horario) {
        horario.setId(null);
        return horarioRepository.save(horario);
    }

    public Horario updateHorario(Integer id, Horario horario) {
        Horario existente = findById(id);
        existente.setDescricao(horario.getDescricao());
        existente.setHorarioInicio(horario.getHorarioInicio());
        existente.setHorarioFim(horario.getHorarioFim());
        return horarioRepository.save(existente);
    }

    public void deleteHorario(Integer id) {
        findById(id);
        horarioRepository.deleteById(id);
    }
}
