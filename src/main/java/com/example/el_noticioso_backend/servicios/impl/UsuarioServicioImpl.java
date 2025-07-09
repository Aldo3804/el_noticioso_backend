package com.example.el_noticioso_backend.servicios.impl;

import com.example.el_noticioso_backend.dto.UsuarioDTO;
import com.example.el_noticioso_backend.entidades.Rol;
import com.example.el_noticioso_backend.entidades.Usuario;
import com.example.el_noticioso_backend.repositorio.RolJPA;
import com.example.el_noticioso_backend.repositorio.UsuarioJPA;
import com.example.el_noticioso_backend.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioServicioImpl implements UsuarioServicio, UserDetailsService {

    @Autowired
    private UsuarioJPA usuarioJPA;

    @Autowired
    private RolJPA rolJPA;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public void agregarUsuario(UsuarioDTO dto) {

        Usuario usuario = mapearEntidad(dto);

        if(usuarioJPA.findByCorreoElectronico(dto.correoElectronico()).isPresent()){
            throw new DataIntegrityViolationException("Ya existe un usuario registrado con ese correo.");
        }

        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));

        Rol rol = rolJPA.findById(2).orElseThrow(() -> new UsernameNotFoundException("El rol no existe"));
        usuario.setRol(rol);

        usuarioJPA.save(usuario);
    }

    @Override
    public void modificarUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = mapearEntidad(usuarioDTO);
        usuarioJPA.save(usuario);

    }

    @Override
    public void eliminarUsuario(UsuarioDTO dto) {
        Usuario usuario = mapearEntidad(dto);
        usuarioJPA.delete(usuario);
    }

    @Override
    public UsuarioDTO iniciarSesion(String correoElectronico, String contrasenia) {
        Usuario usuario = usuarioJPA.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new IllegalArgumentException("Correo no encontrado"));

        if (!passwordEncoder.matches(contrasenia, usuario.getContrasenia())) {
            throw new IllegalArgumentException("Contraseña inválida");
        }

        return mapearDTO(usuario);
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioJPA.findAll()
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer obtenerIdUsuario(String correoElectronico) {
        return usuarioJPA.findByCorreoElectronico(correoElectronico).stream().findFirst().get().getIdUsuario();
    }


    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {

        var usuario = usuarioJPA.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String rol = usuario.getRol().getRol();
        return User.builder()
                .username(usuario.getCorreoElectronico())
                .password(usuario.getContrasenia())
                .roles(rol.toUpperCase())
                .build();
    }

    // MÉTODOS DE MAPEADO MANUAL
    private Usuario mapearEntidad(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.nombre());
        usuario.setApellido(dto.apellido());
        usuario.setCorreoElectronico(dto.correoElectronico());
        usuario.setTelefono(dto.telefono());
        usuario.setContrasenia(dto.contrasenia());
        return usuario;
    }

    private UsuarioDTO mapearDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreoElectronico(),
                usuario.getTelefono(),
                usuario.getContrasenia(),
                usuario.getRol().toString()
        );
    }

}
