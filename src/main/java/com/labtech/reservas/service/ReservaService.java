package com.labtech.reservas.service;

import com.labtech.reservas.dto.ReservaDto;
import com.labtech.reservas.model.Reserva;

import java.util.List;

public interface ReservaService {

    public List<Reserva> findAll();

    public Reserva findById(Integer id);

    public Reserva saveReserva(ReservaDto dto);

    public Reserva updateReserva(Integer id, ReservaDto dto);

    public void deleteReserva(Integer id);
}
