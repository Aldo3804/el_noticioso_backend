package com.example.el_noticioso_backend.servicios.impl;

import com.example.el_noticioso_backend.dto.FavoritoDTO;
import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.repositorio.FavoritoJPA;
import com.example.el_noticioso_backend.servicios.FavoritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class FavoritoServicioImpl implements FavoritoServicio {

    @Autowired
    private FavoritoJPA favoritoJPA;


    @Override
    public List<NoticiaDTO> listarFavorito(Integer idUsuario) {
        return favoritoJPA.listarNoticias(idUsuario);
    }

    @Override
    public void aniadirFavorito(FavoritoDTO favoritoDTO) {

        boolean existe = favoritoJPA.existeFavorito(favoritoDTO.idUsuario(), favoritoDTO.idNoticia());
        if(existe){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Favorito existente");
        }
        favoritoJPA.aniadirFavorito(favoritoDTO.idUsuario(),favoritoDTO.idNoticia());

    }

    @Override
    public void eliminarFavorito(FavoritoDTO favoritoDTO) {
        favoritoJPA.eliminarFavorito(favoritoDTO.idUsuario(),favoritoDTO.idNoticia());
    }


}
