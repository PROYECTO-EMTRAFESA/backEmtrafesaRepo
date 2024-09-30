package com.emtrafesa.repository;

import com.emtrafesa.model.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Métodos personalizados, si es necesario
}
