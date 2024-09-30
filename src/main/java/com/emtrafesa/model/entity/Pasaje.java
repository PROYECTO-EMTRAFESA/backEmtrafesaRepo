package com.emtrafesa.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "pasaje")
public class Pasaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "itinerario_id")
    private Itinerario itinerario;

    private Date fechaCompra;
    private Double total;
    private String estado;

    @OneToOne
    @JoinColumn(name = "postergacion_id")
    private Postergacion postergacion;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

}
