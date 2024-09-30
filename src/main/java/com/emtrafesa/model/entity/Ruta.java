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

    private String origen;
    private String destino;
    private LocalTime duracion;
    private Boolean tieneEscalas;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
}
