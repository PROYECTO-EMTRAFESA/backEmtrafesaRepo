package com.emtrafesa.service;

import com.emtrafesa.dto.IniciarSesionDTO;
import com.emtrafesa.model.entity.UserEmtraf;
import com.emtrafesa.repository.UserEmtrafRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IniciarSesionService {

    private final UserEmtrafRepository userEmtrafRepository;

    public IniciarSesionService(UserEmtrafRepository userEmtrafRepository) {
        this.userEmtrafRepository = userEmtrafRepository;
    }

    public ResponseEntity<String> iniciarSesion(IniciarSesionDTO iniciarSesionDTO) {
        Optional<UserEmtraf> userOptional = userEmtrafRepository.findByCorreo(iniciarSesionDTO.getCorreo());

        if (userOptional.isPresent()) {
            UserEmtraf user = userOptional.get();
            // Aquí debes comparar la contraseña. Si no usas encriptación, compara directamente
            if (iniciarSesionDTO.getContrasena().equals(user.getContrasena())) {
                return ResponseEntity.ok("Inicio de sesión exitoso");
            } else {
                return ResponseEntity.badRequest().body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.badRequest().body("El correo no está registrado");
        }
    }
}
