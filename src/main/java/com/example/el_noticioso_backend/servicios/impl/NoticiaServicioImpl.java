package com.example.el_noticioso_backend.servicios.impl;

import com.example.el_noticioso_backend.dto.EtiquetaDTO;
import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.entidades.Etiqueta;
import com.example.el_noticioso_backend.entidades.Noticia;
import com.example.el_noticioso_backend.repositorio.EtiquetaJPA;
import com.example.el_noticioso_backend.repositorio.NoticiaJPA;
import com.example.el_noticioso_backend.servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class NoticiaServicioImpl implements NoticiaServicio {


    @Autowired
    private NoticiaJPA noticiaJPA;

    @Autowired
    private EtiquetaJPA  etiquetaJPA;


    @Override
    public void agregarNoticias(NoticiaDTO noticiaDTO) {

        Noticia noticia =  mapeoEntidad(noticiaDTO);
        noticiaJPA.save(noticia);

    }

    @Override
    public void eliminarNoticias(int idNoticia) {
        noticiaJPA.deleteById(idNoticia);
    }


    @Override
    public List<NoticiaDTO> listarNoticias() {
         return noticiaJPA.listarNoticias()
                 .stream().map(this::mapeoDTO)
                 .collect(Collectors.toList());
    }

    @Override
    public List<NoticiaDTO> filtrarPorLocalia(String localia) {
        return noticiaJPA.filtrarPorLocalia(localia)
                .stream()
                .map(this::mapeoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NoticiaDTO> mostrarInicio(){
        return noticiaJPA.mostrarInicio()
                .stream()
                .map(this::mapeoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EtiquetaDTO> mostrarEtiquetas() {
        return etiquetaJPA.findAll()
                .stream()
                .map(this::mapeoDTO1)
                .collect(Collectors.toList());
    }


    //Mapeo de las clases NoticiaDTO y Noticia

    public Noticia mapeoEntidad(NoticiaDTO noticiaDTO){

        Noticia noticia = new Noticia();
        noticia.setTitulo(noticiaDTO.titulo());
        noticia.setResumen(noticiaDTO.resumen());
        noticia.setFechaPublicacion(noticiaDTO.fechaPublicacion());
        noticia.setImagenUrl(noticiaDTO.imagenUrl());
        noticia.setAutor(noticiaDTO.autor());
        noticia.setLocalia(noticiaDTO.localia());
        Etiqueta etiqueta = etiquetaJPA.findById(noticiaDTO.idEtiqueta())
                .orElseThrow(() -> new IllegalArgumentException("Etiqueta no encontrada"));

        noticia.setEtiqueta(etiqueta);


        return noticia;

    }


    public NoticiaDTO mapeoDTO(Noticia noticia){
        return new NoticiaDTO(
                noticia.getIdNoticia(),
                noticia.getTitulo(),
                noticia.getResumen(),
                noticia.getFechaPublicacion(),
                noticia.getImagenUrl(),
                noticia.getAutor(),
                noticia.getLocalia(),
                noticia.getEtiqueta().getIdEtiqueta()
        );
    }

    public EtiquetaDTO mapeoDTO1(Etiqueta  etiqueta){
        return new EtiquetaDTO(
                etiqueta.getIdEtiqueta(),
                etiqueta.getNombreEtiqueta()
        );

    }

}
