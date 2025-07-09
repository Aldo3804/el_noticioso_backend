package com.example.el_noticioso_backend.dto;

import java.time.LocalDate;

public record NoticiaDTO(
        int idNoticia,
        String titulo,
        String resumen,
        LocalDate fechaPublicacion,
        String imagenUrl,
        String autor,
        String localia,
        int idEtiqueta
){


}
