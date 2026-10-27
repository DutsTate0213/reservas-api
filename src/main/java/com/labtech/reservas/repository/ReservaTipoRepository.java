package com.labtech.reservas.repository;

import com.labtech.reservas.model.ReservaTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaTipoRepository extends JpaRepository<ReservaTipo, Integer> {

}
