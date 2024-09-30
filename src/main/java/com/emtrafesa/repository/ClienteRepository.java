package com.emtrafesa.repository;

import com.emtrafesa.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados, si es necesario
}
