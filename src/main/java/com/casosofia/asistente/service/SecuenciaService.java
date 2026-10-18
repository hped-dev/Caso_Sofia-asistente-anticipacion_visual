package com.casosofia.asistente.service;

import com.casosofia.asistente.dto.ActividadDTO;
import com.casosofia.asistente.dto.SecuenciaDTO;
import com.casosofia.asistente.model.Actividad;
import com.casosofia.asistente.model.Pictograma;
import com.casosofia.asistente.repository.ActividadRepository;
import com.casosofia.asistente.repository.JornadaRepository;
import com.casosofia.asistente.repository.PictogramaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.casosofia.asistente.model.Jornada;

@Service
@Transactional(readOnly = true)
public class SecuenciaService {

        private final JornadaRepository jornadaRepository;
        private final ActividadRepository actividadRepository;
        private final PictogramaRepository pictogramaRepository;

        public SecuenciaService(JornadaRepository jornadaRepository,
                        ActividadRepository actividadRepository,
                        PictogramaRepository pictogramaRepository) {
                this.jornadaRepository = jornadaRepository;
                this.actividadRepository = actividadRepository;
                this.pictogramaRepository = pictogramaRepository;
        }

        public SecuenciaDTO obtenerSecuenciaPorFecha(LocalDate fecha) {
                Jornada jornada = jornadaRepository.findByFecha(fecha)
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "No hay horario para la fecha: " + fecha));

                List<Actividad> actividades = actividadRepository
                                .findByJornadaIdAndActivoTrueOrderByOrdenAsc(jornada.getId());

                List<ActividadDTO> dtos = actividades.stream()
                                .map(this::toDto)
                                .collect(Collectors.toList());

                return new SecuenciaDTO(fecha, dtos);
        }

        private ActividadDTO toDto(Actividad actividad) {
                String urlImagen = pictogramaRepository.findByClave(actividad.getPictogramaClave())
                                .map(Pictograma::getUrlImagen)
                                .orElse("/img/pictogramas/placeholder.png");

                return new ActividadDTO(
                                actividad.getId(),
                                actividad.getNombre(),
                                actividad.getPictogramaClave(),
                                urlImagen,
                                actividad.getOrden(),
                                actividad.getDuracionEstimadaMin(),
                                actividad.getAvisoCambioMin());
        }
}
