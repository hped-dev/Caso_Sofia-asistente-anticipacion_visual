package com.casosofia.asistente.service;

import com.casosofia.asistente.model.TransicionSimulada;
import com.casosofia.asistente.repository.TransicionSimuladaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CambioRutinaService {

    private final TransicionSimuladaRepository transicionRepository;

    public CambioRutinaService(TransicionSimuladaRepository transicionRepository) {
        this.transicionRepository = transicionRepository;
    }

    public TransicionSimulada registrarCambio(Long actividadId, Integer minutosAnticipacion) {
        TransicionSimulada transicion = new TransicionSimulada();
        transicion.setActividadId(actividadId);
        transicion.setCompletada(false);
        return transicionRepository.save(transicion);
    }

    public TransicionSimulada marcarCompletada(Long actividadId) {
        TransicionSimulada transicion = new TransicionSimulada();
        transicion.setActividadId(actividadId);
        transicion.setCompletada(true);
        return transicionRepository.save(transicion);
    }
}
