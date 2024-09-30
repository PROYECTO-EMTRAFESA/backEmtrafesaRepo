package com.emtrafesa.controller;

import com.emtrafesa.dto.RegistroDTO;
import com.emtrafesa.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping("/cliente")
    public ResponseEntity<String> registrarCliente(@Valid @RequestBody RegistroDTO registroDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
        }
        registroService.registrarCliente(registroDTO);
        return ResponseEntity.ok("Cliente registrado exitosamente");
    }

    @PostMapping("/empleado")
    public ResponseEntity<String> registrarEmpleado(@Valid @RequestBody RegistroDTO registroDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
        }
        registroService.registrarEmpleado(registroDTO);
        return ResponseEntity.ok("Empleado registrado exitosamente");
    }


}
