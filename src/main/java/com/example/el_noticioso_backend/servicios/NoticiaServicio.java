package com.example.el_noticioso_backend.servicios;

import com.example.el_noticioso_backend.dto.EtiquetaDTO;
import com.example.el_noticioso_backend.dto.NoticiaDTO;


import java.util.List;

public interface NoticiaServicio {

    void agregarNoticias(NoticiaDTO noticiaDTO);

    void eliminarNoticias(int idNoticia);

    List<NoticiaDTO> filtrarPorLocalia(String localia);

    List<NoticiaDTO> listarNoticias();

    List<NoticiaDTO> mostrarInicio();

    List<EtiquetaDTO> mostrarEtiquetas();

}
