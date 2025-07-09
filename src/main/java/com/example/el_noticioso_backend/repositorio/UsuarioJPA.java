package com.example.el_noticioso_backend.repositorio;

import com.example.el_noticioso_backend.dto.UsuarioDTO;
import com.example.el_noticioso_backend.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioJPA extends JpaRepository<Usuario,Integer> {


    Optional<Usuario> findByCorreoElectronico(String correoElectronico);


}

