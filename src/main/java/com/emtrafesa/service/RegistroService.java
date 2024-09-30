package com.emtrafesa.service;

import com.emtrafesa.dto.RegistroDTO;
import com.emtrafesa.model.entity.Cliente;
import com.emtrafesa.model.entity.Empleado;
import com.emtrafesa.model.entity.UserEmtraf;
import com.emtrafesa.model.enums.TipoUsuario;
import com.emtrafesa.repository.ClienteRepository;
import com.emtrafesa.repository.EmpleadoRepository;
import com.emtrafesa.repository.UserEmtrafRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroService {

    private final UserEmtrafRepository userEmtrafRepository;
    private final ClienteRepository clienteRepository;
    private final EmpleadoRepository empleadoRepository;

    private static final Logger logger = LoggerFactory.getLogger(RegistroService.class);

    public RegistroService(UserEmtrafRepository userEmtrafRepository,
                           ClienteRepository clienteRepository,
                           EmpleadoRepository empleadoRepository) {
        this.userEmtrafRepository = userEmtrafRepository;
        this.clienteRepository = clienteRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public void registrarCliente(RegistroDTO registroDTO) {
        logger.info("Iniciando registro de cliente con correo: {}", registroDTO.getCorreo());

        UserEmtraf user = new UserEmtraf();
        user.setCorreo(registroDTO.getCorreo());

        user.setContrasena(registroDTO.getContrasena());
        user.setTipoUsuario(TipoUsuario.CLIENTE);
        userEmtrafRepository.save(user);

        Cliente cliente = new Cliente();
        cliente.setUserEmtraf(user);
        cliente.setTelefono(registroDTO.getTelefono());
        clienteRepository.save(cliente);

        logger.info("Cliente registrado exitosamente con correo: {}", registroDTO.getCorreo());
    }

    @Transactional
    public void registrarEmpleado(RegistroDTO registroDTO) {
        logger.info("Iniciando registro de empleado con correo: {}", registroDTO.getCorreo());

        UserEmtraf user = new UserEmtraf();
        user.setCorreo(registroDTO.getCorreo());

        // Guardar la contraseña tal cual, sin encriptación
        user.setContrasena(registroDTO.getContrasena());
        user.setTipoUsuario(TipoUsuario.EMPLEADO);
        userEmtrafRepository.save(user);

        Empleado empleado = new Empleado();
        empleado.setUserEmtraf(user);
        empleado.setExperiencia(registroDTO.getExperiencia());
        empleadoRepository.save(empleado);

        logger.info("Empleado registrado exitosamente con correo: {}", registroDTO.getCorreo());
    }
}
