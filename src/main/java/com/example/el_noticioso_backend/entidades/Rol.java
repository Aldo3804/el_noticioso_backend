package com.example.el_noticioso_backend.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "rol")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rol {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(length = 255, nullable = false)
    private String rol;

    @OneToMany(mappedBy = "rol")
    @ToString.Exclude
    private List<Usuario> usuarios;

    @Override
    public String toString() {
        return this.rol;
    }

}
