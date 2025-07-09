package com.example.el_noticioso_backend.controladores;

import com.example.el_noticioso_backend.dto.UsuarioDTO;
import com.example.el_noticioso_backend.servicios.UsuarioServicio;
import com.example.el_noticioso_backend.servicios.impl.UsuarioServicioImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioServicio usuarioServicio;


    @GetMapping("/buscar/{correo}")
    public ResponseEntity<Integer> buscarUsuario(@PathVariable String correo){
         return ResponseEntity.ok(usuarioServicio.obtenerIdUsuario(correo));
    }

    @PutMapping("/modificar")
    public ResponseEntity<UsuarioDTO> modificar(@RequestBody UsuarioDTO usuarioDTO){
        usuarioServicio.modificarUsuario(usuarioDTO);
        return ResponseEntity.ok().body(usuarioDTO);
    }


    @PostMapping("/crear")
    public ResponseEntity<Void> crear(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioServicio.agregarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/sesion")
    public ResponseEntity<?> iniciarSesion(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO usuarioAutenticado = usuarioServicio.iniciarSesion(usuarioDTO.correoElectronico(), usuarioDTO.contrasenia());
            return ResponseEntity.ok(usuarioAutenticado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }






}
