package com.example.el_noticioso_backend.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "etiqueta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta")
    private Integer idEtiqueta;

    @Column(name = "nombre_etiqueta", nullable = false, length = 100)
    private String nombreEtiqueta;

}
