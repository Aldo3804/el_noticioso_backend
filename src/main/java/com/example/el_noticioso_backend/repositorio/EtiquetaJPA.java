package com.example.el_noticioso_backend.repositorio;

import com.example.el_noticioso_backend.entidades.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaJPA extends JpaRepository<Etiqueta,Integer> {
}
