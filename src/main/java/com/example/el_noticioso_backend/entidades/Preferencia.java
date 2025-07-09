package com.example.el_noticioso_backend.entidades;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "preferencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preferencia")
    private int idPreferencia;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

}