package com.example.el_noticioso_backend.utilidades;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorUI {


    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();


    public static <T> String validar(T objeto) {
        Set<ConstraintViolation<T>> errores = validator.validate(objeto);
        if (errores.isEmpty()) {
            return null;
        }
        // Concatenar mensajes de error
        return errores.stream()
                .map(error -> error.getPropertyPath() + ": " + error.getMessage())
                .collect(Collectors.joining(", "));
    }

}
