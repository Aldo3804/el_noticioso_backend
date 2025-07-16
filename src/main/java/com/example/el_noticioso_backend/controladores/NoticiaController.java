package com.example.el_noticioso_backend.controladores;


import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.entidades.Noticia;
import com.example.el_noticioso_backend.servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    private NoticiaServicio noticiaServicio;
    
    @GetMapping("/filtrar/{localia}")
    public ResponseEntity<List<NoticiaDTO>> filtrarPorLocalia(@PathVariable String localia){
        return ResponseEntity.ok(noticiaServicio.filtrarPorLocalia(localia));
    }

    @GetMapping("/inicio")
    public ResponseEntity<List<NoticiaDTO>> mostrarInicio(){
        return ResponseEntity.ok(noticiaServicio.mostrarInicio());
    }


}
