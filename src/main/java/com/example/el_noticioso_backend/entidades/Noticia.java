package com.example.el_noticioso_backend.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "noticia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private int idNoticia;

    @Column(name = "titulo_noticia", nullable = false, length = 255)
    private String titulo;

    @Column(name = "localia", nullable = false)
    private String localia;

    @Column(name = "resumen",nullable = false, columnDefinition = "TEXT")
    private String resumen;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(nullable = false)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "id_etiqueta", nullable = false)
    private Etiqueta etiqueta;


}
