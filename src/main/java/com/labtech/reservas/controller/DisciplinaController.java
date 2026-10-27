package com.labtech.reservas.controller;

import com.labtech.reservas.common.response.ApiResponse;
import com.labtech.reservas.dto.DisciplinaDto;
import com.labtech.reservas.model.Disciplina;
import com.labtech.reservas.service.DisciplinaService;
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

import java.util.List;

@RestController
@RequestMapping("disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Disciplina>>> findAll() {

        return ResponseEntity.ok(ApiResponse.of(disciplinaService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Disciplina>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(ApiResponse.of(disciplinaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Disciplina>> create(@Valid @RequestBody DisciplinaDto dto) {

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(disciplinaService.saveDisciplina(disciplina)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Disciplina>> update(@PathVariable Integer id, @Valid @RequestBody DisciplinaDto dto) {

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.nome());

        return ResponseEntity.ok(ApiResponse.of(disciplinaService.updateDisciplina(id, disciplina)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        disciplinaService.deleteDisciplina(id);

        return ResponseEntity.noContent().build();
    }
}
