package com.example.el_noticioso_backend.repositorio;

import com.example.el_noticioso_backend.entidades.Preferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenciaJPA extends JpaRepository<Preferencia,Integer> {
}
