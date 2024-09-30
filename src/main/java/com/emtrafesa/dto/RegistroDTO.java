package com.emtrafesa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

public class RegistroDTO {

    @Getter
    @Email(message = "El correo debe ser válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @Getter
    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

    @Getter
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Getter
    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @Getter
    @Pattern(regexp = "\\d{9}", message = "El teléfono debe contener exactamente 9 dígitos")
    private String telefono;

    @Getter
    private String experiencia;
}
