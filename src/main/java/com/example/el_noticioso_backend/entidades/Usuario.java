package com.example.el_noticioso_backend.entidades;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @NotNull(message = "El nombre no puede estar vacio")
    @Size(min = 2,max = 255,message =  "El nombre no tiene suficientes caracteres")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "El nombre es invalido")
    @Column(name = "nombre",nullable = false, length = 255)
    private String nombre;

    @NotNull(message = "Los apellidos no pueden estar vacios")
    @Size(min = 2,max = 255,message =  "Los apellidos no tienen suficientes caracteres")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Los apellidos son invalidos")
    @Column(name = "apellido", nullable = false, length = 255)
    private String apellido;


    @NotNull(message = "El correo electronico no debe estar vacio")
    @Size(min=2,message = "El correo electronico no tienen los suficientes caracteres")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@(gmail|outlook)\\.com$", message = "El correo electrónico debe tener un formato válido")
    @Column(name = "correo_electronico", nullable = false, columnDefinition = "TEXT",unique = true)
    private String correoElectronico;

    @NotNull(message = "El telefono no puede estar vacio")
    @Size(min=9 ,max=9,message = "El telefono no es valido")
    @Column(name = "telefono",nullable = false, length = 9)
    private String telefono;

    @Size(min=8,message = "La contraseña debe tener mas de ocho caracteres")
    @Column(name = "contrasenia",nullable = false,length = 255)
    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    @ToString.Exclude
    private Rol rol;

}
