package com.labtech.reservas.controller;

import com.labtech.reservas.common.response.ApiResponse;
import com.labtech.reservas.dto.ReservaDto;
import com.labtech.reservas.model.Reserva;
import com.labtech.reservas.service.ReservaService;
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
@RequestMapping("reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Reserva>>> findAll() {

        return ResponseEntity.ok(ApiResponse.of(reservaService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Reserva>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(ApiResponse.of(reservaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Reserva>> create(@Valid @RequestBody ReservaDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(reservaService.saveReserva(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Reserva>> update(@PathVariable Integer id, @Valid @RequestBody ReservaDto dto) {

        return ResponseEntity.ok(ApiResponse.of(reservaService.updateReserva(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        reservaService.deleteReserva(id);

        return ResponseEntity.noContent().build();
    }
}
