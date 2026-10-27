package com.labtech.reservas.service.impl;

import com.labtech.reservas.dto.ReservaDto;
import com.labtech.reservas.model.Curso;
import com.labtech.reservas.model.Disciplina;
import com.labtech.reservas.model.Horario;
import com.labtech.reservas.model.Reserva;
import com.labtech.reservas.model.ReservaStatus;
import com.labtech.reservas.model.ReservaTipo;
import com.labtech.reservas.model.Sala;
import com.labtech.reservas.model.Usuario;
import com.labtech.reservas.repository.CursoRepository;
import com.labtech.reservas.repository.DisciplinaRepository;
import com.labtech.reservas.repository.HorarioRepository;
import com.labtech.reservas.repository.ReservaRepository;
import com.labtech.reservas.repository.ReservaStatusRepository;
import com.labtech.reservas.repository.ReservaTipoRepository;
import com.labtech.reservas.repository.SalaRepository;
import com.labtech.reservas.repository.UsuarioRepository;
import com.labtech.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaStatusRepository reservaStatusRepository;

    @Autowired
    private ReservaTipoRepository reservaTipoRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Reserva> findAll() {

        return reservaRepository.findAll();
    }

    public Reserva findById(Integer id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }

    public Reserva saveReserva(ReservaDto dto) {
        Reserva reserva = new Reserva();
        preencher(reserva, dto);
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Integer id, ReservaDto dto) {
        Reserva existente = findById(id);
        preencher(existente, dto);
        return reservaRepository.save(existente);
    }

    public void deleteReserva(Integer id) {
        findById(id);
        reservaRepository.deleteById(id);
    }

    private void preencher(Reserva reserva, ReservaDto dto) {
        reserva.setDescricaoAtividade(dto.descricaoAtividade());
        reserva.setDataReserva(dto.dataReserva());
        reserva.setUsuario(buscarUsuario(dto.usuarioId()));
        reserva.setReservaStatus(buscarReservaStatus(dto.reservaStatusId()));
        reserva.setReservaTipo(buscarReservaTipo(dto.reservaTipoId()));
        reserva.setHorario(buscarHorario(dto.horarioId()));
        reserva.setSala(buscarSala(dto.salaId()));
        reserva.setDisciplina(dto.disciplinaId() != null ? buscarDisciplina(dto.disciplinaId()) : null);
        reserva.setCurso(dto.cursoId() != null ? buscarCurso(dto.cursoId()) : null);
    }

    private Usuario buscarUsuario(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    private ReservaStatus buscarReservaStatus(Integer id) {
        return reservaStatusRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status de reserva não encontrado"));
    }

    private ReservaTipo buscarReservaTipo(Integer id) {
        return reservaTipoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de reserva não encontrado"));
    }

    private Horario buscarHorario(Integer id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Horário não encontrado"));
    }

    private Sala buscarSala(Integer id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));
    }

    private Disciplina buscarDisciplina(Integer id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));
    }

    private Curso buscarCurso(Integer id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));
    }
}
