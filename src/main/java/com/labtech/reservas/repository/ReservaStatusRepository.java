package com.labtech.reservas.repository;

import com.labtech.reservas.model.ReservaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaStatusRepository extends JpaRepository<ReservaStatus, Integer> {

}
