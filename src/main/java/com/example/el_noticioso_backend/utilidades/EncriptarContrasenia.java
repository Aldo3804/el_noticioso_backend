package com.example.el_noticioso_backend.utilidades;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarContrasenia {

    private String contrasenia;

    public EncriptarContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(contrasenia);
    }




}
