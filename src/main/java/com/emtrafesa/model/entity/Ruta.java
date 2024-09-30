package com.emtrafesa.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "ruta")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "duracion", length = 20, nullable = false) // Puede ser un texto que describa la duración (ej: "4h 30min")
    private LocalTime duracion;

    @Column(name = "tiene_escalas", nullable = false)
    private Boolean tieneEscalas;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
}
