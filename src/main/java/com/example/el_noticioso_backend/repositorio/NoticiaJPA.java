package com.example.el_noticioso_backend.repositorio;

import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaJPA extends JpaRepository<Noticia,Integer> {


    @Query("select n from Noticia n ")
    List<Noticia> listarNoticias();

    @Query("select n from Noticia n where n.localia= :localia")
    List<Noticia> filtrarPorLocalia(@Param("localia") String localia);

    @Query("select n from Noticia n order by rand() limit 5")
    List<Noticia> mostrarInicio();


}
