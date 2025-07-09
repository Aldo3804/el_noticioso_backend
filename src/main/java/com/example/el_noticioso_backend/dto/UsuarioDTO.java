package com.example.el_noticioso_backend.dto;



public record UsuarioDTO(

        String nombre,
        String apellido,
        String correoElectronico,
        String telefono,
        String contrasenia,
        String rol
) {

}
