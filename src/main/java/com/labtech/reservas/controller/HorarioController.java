package com.labtech.reservas.controller;

import com.labtech.reservas.common.response.ApiResponse;
import com.labtech.reservas.dto.HorarioDto;
import com.labtech.reservas.model.Horario;
import com.labtech.reservas.service.HorarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Horario>>> findAll() {

        return ResponseEntity.ok(ApiResponse.of(horarioService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Horario>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(ApiResponse.of(horarioService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Horario>> create(@Valid @RequestBody HorarioDto dto) {

        Horario horario = toEntity(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(horarioService.saveHorario(horario)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Horario>> update(@PathVariable Integer id, @Valid @RequestBody HorarioDto dto) {

        Horario horario = toEntity(dto);

        return ResponseEntity.ok(ApiResponse.of(horarioService.updateHorario(id, horario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        horarioService.deleteHorario(id);

        return ResponseEntity.noContent().build();
    }

    private Horario toEntity(HorarioDto dto) {
        Horario horario = new Horario();
        horario.setDescricao(dto.descricao());
        horario.setHorarioInicio(Time.valueOf(dto.horarioInicio()));
        horario.setHorarioFim(Time.valueOf(dto.horarioFim()));
        return horario;
    }
}
