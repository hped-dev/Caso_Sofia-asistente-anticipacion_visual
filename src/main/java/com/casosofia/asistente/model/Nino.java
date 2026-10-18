package com.casosofia.asistente.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "nino")
public class Nino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreApodo;

    @Column(nullable = false, length = 30)
    private String temaPreferido; // "marino" | "transporte"

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    public Nino() {
        this.fechaCreacion = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreApodo() {
        return nombreApodo;
    }

    public void setNombreApodo(String nombreApodo) {
        this.nombreApodo = nombreApodo;
    }

    public String getTemaPreferido() {
        return temaPreferido;
    }

    public void setTemaPreferido(String temaPreferido) {
        this.temaPreferido = temaPreferido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
