package com.casosofia.asistente.dto;

import java.time.LocalDate;
import java.util.List;

public class SecuenciaDTO {

    private LocalDate fecha;
    private List<ActividadDTO> actividades;

    public SecuenciaDTO() {}

    public SecuenciaDTO(LocalDate fecha, List<ActividadDTO> actividades) {
        this.fecha = fecha;
        this.actividades = actividades;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }
}
