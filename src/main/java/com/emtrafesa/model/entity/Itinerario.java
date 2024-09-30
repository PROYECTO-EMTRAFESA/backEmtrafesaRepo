package com.emtrafesa.model.entity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "itinerario")
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    private LocalDate fechaViaje;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;

    @ElementCollection
    @CollectionTable(name = "precios_por_piso", joinColumns = @JoinColumn(name = "itinerario_id"))
    @Column(name = "precio")
    private List<Double> preciosPorPiso;  // Lista de precios para cada piso en este itinerario

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
}
