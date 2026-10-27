package com.labtech.reservas.repository;

import com.labtech.reservas.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}
