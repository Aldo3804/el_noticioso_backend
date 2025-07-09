package com.example.el_noticioso_backend.utilidades;


import com.example.el_noticioso_backend.dto.UsuarioDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ManejoExcepciones {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String,String>> errorDeConexionSQL(SQLException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("Error de conexion","Error al obtener datos de la base de datos");
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> correoDuplicado(DataIntegrityViolationException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Ya existe un usuario con ese correo.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}
