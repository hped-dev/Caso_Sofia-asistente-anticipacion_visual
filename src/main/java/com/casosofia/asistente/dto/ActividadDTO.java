package com.casosofia.asistente.dto;

public class ActividadDTO {

    private Long id;
    private String nombre;
    private String pictogramaClave;
    private String urlImagen;
    private Integer orden;
    private Integer duracionEstimadaMin;
    private Integer avisoCambioMin;

    public ActividadDTO() {}

    public ActividadDTO(Long id, String nombre, String pictogramaClave, String urlImagen,
                        Integer orden, Integer duracionEstimadaMin, Integer avisoCambioMin) {
        this.id = id;
        this.nombre = nombre;
        this.pictogramaClave = pictogramaClave;
        this.urlImagen = urlImagen;
        this.orden = orden;
        this.duracionEstimadaMin = duracionEstimadaMin;
        this.avisoCambioMin = avisoCambioMin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
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
}
