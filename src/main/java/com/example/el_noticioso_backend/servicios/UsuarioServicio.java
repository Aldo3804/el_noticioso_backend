package com.example.el_noticioso_backend.servicios;

import com.example.el_noticioso_backend.dto.UsuarioDTO;
import com.example.el_noticioso_backend.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    void agregarUsuario(UsuarioDTO usuarioDTO);

    void modificarUsuario(UsuarioDTO usuarioDTO);

    void eliminarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO iniciarSesion(String correoElectronico, String password);

    List<UsuarioDTO> listarUsuarios();

    Integer obtenerIdUsuario(String correoElectronico);

}
