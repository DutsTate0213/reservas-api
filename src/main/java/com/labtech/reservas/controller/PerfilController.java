package com.labtech.reservas.controller;

import com.labtech.reservas.common.response.ApiResponse;
import com.labtech.reservas.dto.PerfilDto;
import com.labtech.reservas.model.Perfil;
import com.labtech.reservas.service.PerfilService;
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
@RequestMapping("perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Perfil>>> findAll() {

        return ResponseEntity.ok(ApiResponse.of(perfilService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Perfil>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(ApiResponse.of(perfilService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Perfil>> create(@Valid @RequestBody PerfilDto dto) {

        Perfil perfil = new Perfil();
        perfil.setNome(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(perfilService.savePerfil(perfil)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Perfil>> update(@PathVariable Integer id, @Valid @RequestBody PerfilDto dto) {

        Perfil perfil = new Perfil();
        perfil.setNome(dto.nome());

        return ResponseEntity.ok(ApiResponse.of(perfilService.updatePerfil(id, perfil)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        perfilService.deletePerfil(id);

        return ResponseEntity.noContent().build();
    }
}
