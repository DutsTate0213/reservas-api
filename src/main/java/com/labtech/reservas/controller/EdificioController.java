package com.labtech.reservas.controller;

import com.labtech.reservas.common.response.ApiResponse;
import com.labtech.reservas.dto.EdificioDto;
import com.labtech.reservas.model.Edificio;
import com.labtech.reservas.service.EdificioService;
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
@RequestMapping("edificio")
public class EdificioController {

    @Autowired
    private EdificioService edificioService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Edificio>>> findAll() {

        return ResponseEntity.ok(ApiResponse.of(edificioService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Edificio>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(ApiResponse.of(edificioService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Edificio>> create(@Valid @RequestBody EdificioDto dto) {

        Edificio edificio = new Edificio();
        edificio.setNome(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(edificioService.saveEdificio(edificio)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Edificio>> update(@PathVariable Integer id, @Valid @RequestBody EdificioDto dto) {

        Edificio edificio = new Edificio();
        edificio.setNome(dto.nome());

        return ResponseEntity.ok(ApiResponse.of(edificioService.updateEdificio(id, edificio)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        edificioService.deleteEdificio(id);

        return ResponseEntity.noContent().build();
    }
}
