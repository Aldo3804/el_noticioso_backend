package com.example.el_noticioso_backend.controladores;



import com.example.el_noticioso_backend.dto.FavoritoDTO;
import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.servicios.FavoritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavoritosController {

    @Autowired
    private FavoritoServicio favoritoServicio;


    @GetMapping("/listar/{idUsuario}")
    public ResponseEntity<List<NoticiaDTO>> listarFavorito(@PathVariable Integer idUsuario) {
        List<NoticiaDTO> favoritos = favoritoServicio.listarFavorito(idUsuario);
        return ResponseEntity.ok(favoritos);
    }

    @PutMapping("/aniadir")
    public ResponseEntity<Void> aniadirFavorito(@RequestBody FavoritoDTO favoritoDTO) {
        favoritoServicio.aniadirFavorito(favoritoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarFavorito(@RequestBody FavoritoDTO  favoritoDTO) {
        favoritoServicio.eliminarFavorito(favoritoDTO);
        return ResponseEntity.ok().build();
    }

}
