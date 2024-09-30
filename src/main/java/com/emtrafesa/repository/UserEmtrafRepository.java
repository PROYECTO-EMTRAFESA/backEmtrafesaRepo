package com.emtrafesa.repository;

import com.emtrafesa.model.entity.UserEmtraf;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserEmtrafRepository extends JpaRepository<UserEmtraf, Long> {
    Optional<UserEmtraf> findByCorreo(String correo);
}

