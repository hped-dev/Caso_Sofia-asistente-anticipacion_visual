package com.casosofia.asistente.repository;

import com.casosofia.asistente.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    List<Actividad> findByJornadaIdOrderByOrdenAsc(Long jornadaId);

    List<Actividad> findByJornadaIdAndActivoTrueOrderByOrdenAsc(Long jornadaId);
}
