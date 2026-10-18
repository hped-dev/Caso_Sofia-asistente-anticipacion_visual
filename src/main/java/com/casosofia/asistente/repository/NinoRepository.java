package com.casosofia.asistente.repository;

import com.casosofia.asistente.model.Nino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinoRepository extends JpaRepository<Nino, Long> {
}
