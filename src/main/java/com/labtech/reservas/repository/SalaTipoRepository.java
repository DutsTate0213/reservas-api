package com.labtech.reservas.repository;

import com.labtech.reservas.model.SalaTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaTipoRepository extends JpaRepository<SalaTipo, Integer> {

}
