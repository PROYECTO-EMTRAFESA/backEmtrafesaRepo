package com.emtrafesa.model.entity;

import com.emtrafesa.model.enums.TipoServicio;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;  // Importa la clase Map

@Data
@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoServicio servicio;

    private String modelo;
    private int numeroPisos;

    @ElementCollection
    @CollectionTable(name = "asientos_por_piso", joinColumns = @JoinColumn(name = "bus_id"))
    @MapKeyColumn(name = "piso")
    @Column(name = "cantidad_asientos")
    private Map<Integer, Integer> cantidadAsientosPorPiso;

}
