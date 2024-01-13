package com.juerodriguez.pruebaspring.controllers;

import com.juerodriguez.pruebaspring.dao.UserDAO;
import com.juerodriguez.pruebaspring.model.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Controlador de Usuario", description = "Una api para mostrar un Spring Boot Rest CRUD")
@RestController
@RequestMapping("user")
public class UsuarioControl {

    @Autowired
    private UserDAO userDAO;

    @Operation(
            summary = "Obtención de usuario por ID",
            description = "Escribir solamente el id")
    @GetMapping(value = "{user_id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("user_id") Integer user_id){
        Optional<Usuario> optionalUsuario= userDAO.findById(user_id);
        if (optionalUsuario.isPresent()){
            return ResponseEntity.ok(optionalUsuario.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Operation(
            summary = "Crear usuario",
            description = "Escribir todos los campos, el campo id no es obligatorio ya que se auto genera")
    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
        Usuario newuser = userDAO.save(usuario);
        return ResponseEntity.ok(newuser);
    }
}
