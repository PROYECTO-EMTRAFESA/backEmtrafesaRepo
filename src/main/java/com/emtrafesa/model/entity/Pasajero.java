package com.emtrafesa.model.entity;
import com.emtrafesa.model.enums.SEXO;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "pasajero")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;

    @Enumerated(EnumType.STRING)
    private SEXO sexo;
}

