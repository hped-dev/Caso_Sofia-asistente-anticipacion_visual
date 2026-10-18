package com.casosofia.asistente.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jornada_id", nullable = false)
    private Jornada jornada;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String pictogramaClave;

    @Column(nullable = false)
    private Integer orden;

    @Column(nullable = false)
    private Integer duracionEstimadaMin;

    @Column(nullable = false)
    private Integer avisoCambioMin;

    @Column(nullable = false)
    private Boolean activo = true;

    public Actividad() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPictogramaClave() {
        return pictogramaClave;
    }

    public void setPictogramaClave(String pictogramaClave) {
        this.pictogramaClave = pictogramaClave;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getDuracionEstimadaMin() {
        return duracionEstimadaMin;
    }

    public void setDuracionEstimadaMin(Integer duracionEstimadaMin) {
        this.duracionEstimadaMin = duracionEstimadaMin;
    }

    public Integer getAvisoCambioMin() {
        return avisoCambioMin;
    }

    public void setAvisoCambioMin(Integer avisoCambioMin) {
        this.avisoCambioMin = avisoCambioMin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
