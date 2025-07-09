package com.example.el_noticioso_backend.excepciones;

public class ExcepcionCorreo extends RuntimeException {
    public ExcepcionCorreo(String message) {
        super(message);
    }
}
