package com.example.el_noticioso_backend.administrador;


import com.example.el_noticioso_backend.dto.EtiquetaDTO;
import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/noticia")
public class NoticiaAdminController {


    @Autowired
    private NoticiaServicio noticiaServicio;



    @PostMapping("/crear")
    public ResponseEntity<Void> crearNoticia(@RequestBody NoticiaDTO dto) {
        noticiaServicio.agregarNoticias(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{idNoticia}")
    public ResponseEntity<Void> eliminarNoticia(@PathVariable("idNoticia") Integer idNoticia) {
        noticiaServicio.eliminarNoticias(idNoticia);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NoticiaDTO>> listar(){
        return ResponseEntity.ok(noticiaServicio.listarNoticias());
    }

    @GetMapping("/listar/etiquetas")
    public ResponseEntity<List<EtiquetaDTO>> listarEtiquetas(){
        return ResponseEntity.ok(noticiaServicio.mostrarEtiquetas());
    }

}
