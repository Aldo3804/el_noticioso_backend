package com.example.el_noticioso_backend.administrador;


import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.dto.UsuarioDTO;
import com.example.el_noticioso_backend.entidades.Usuario;
import com.example.el_noticioso_backend.servicios.NoticiaServicio;
import com.example.el_noticioso_backend.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/usuario")
public class UsuarioAdminController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listar(){
        return ResponseEntity.ok(usuarioServicio.listarUsuarios());
    }

}
