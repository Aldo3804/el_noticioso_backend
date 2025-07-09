package com.example.el_noticioso_backend.servicios;

import com.example.el_noticioso_backend.dto.FavoritoDTO;
import com.example.el_noticioso_backend.dto.NoticiaDTO;

import java.util.List;


public interface FavoritoServicio {


    List<NoticiaDTO> listarFavorito(Integer idUsuario);

    void aniadirFavorito(FavoritoDTO  favoritoDTO);

    void eliminarFavorito(FavoritoDTO favoritoDTO);


}
