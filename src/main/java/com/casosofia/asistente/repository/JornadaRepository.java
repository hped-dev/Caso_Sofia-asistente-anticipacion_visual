package com.casosofia.asistente.repository;

import com.casosofia.asistente.model.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Long> {

    Optional<Jornada> findByFecha(LocalDate fecha);

    boolean existsByFecha(LocalDate fecha);
}
