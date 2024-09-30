package com.emtrafesa.controller;

import com.emtrafesa.dto.IniciarSesionDTO;
import com.emtrafesa.service.IniciarSesionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inicio")
public class IniciarSesionController {

    private final IniciarSesionService iniciarSesionService;

    public IniciarSesionController(IniciarSesionService iniciarSesionService) {
        this.iniciarSesionService = iniciarSesionService;
    }

    @PostMapping("/sesion")
    public ResponseEntity<String> iniciarSesion(@Valid @RequestBody IniciarSesionDTO iniciarSesionDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
        }
        return iniciarSesionService.iniciarSesion(iniciarSesionDTO);
    }
}
