package com.labtech.reservas.controller;

import com.labtech.reservas.common.response.ApiResponse;
import com.labtech.reservas.dto.CursoDto;
import com.labtech.reservas.model.Curso;
import com.labtech.reservas.service.CursoService;
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
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Curso>>> findAll() {

        return ResponseEntity.ok(ApiResponse.of(cursoService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Curso>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(ApiResponse.of(cursoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Curso>> create(@Valid @RequestBody CursoDto dto) {

        Curso curso = new Curso();
        curso.setNome(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(cursoService.saveCurso(curso)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Curso>> update(@PathVariable Integer id, @Valid @RequestBody CursoDto dto) {

        Curso curso = new Curso();
        curso.setNome(dto.nome());

        return ResponseEntity.ok(ApiResponse.of(cursoService.updateCurso(id, curso)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        cursoService.deleteCurso(id);

        return ResponseEntity.noContent().build();
    }
}
