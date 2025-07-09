package com.example.el_noticioso_backend.repositorio;

import com.example.el_noticioso_backend.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolJPA extends JpaRepository<Rol,Integer> {

    Optional<Rol> findByRol(String rol);
}
