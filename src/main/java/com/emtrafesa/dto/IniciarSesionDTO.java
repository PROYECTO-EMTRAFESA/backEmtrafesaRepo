package com.emtrafesa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class IniciarSesionDTO {

    @Getter
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @Getter
    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;
}
