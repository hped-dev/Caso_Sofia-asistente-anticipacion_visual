package com.casosofia.asistente.repository;

import com.casosofia.asistente.model.TransicionSimulada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransicionSimuladaRepository extends JpaRepository<TransicionSimulada, Long> {

    List<TransicionSimulada> findByActividadIdOrderByFechaDesc(Long actividadId);
}
