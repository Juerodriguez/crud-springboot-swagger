package com.juerodriguez.pruebaspring.controllers;

import com.juerodriguez.pruebaspring.dao.UserDAO;
import com.juerodriguez.pruebaspring.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UsuarioControl {

    @Autowired
    private UserDAO userDAO;

    @GetMapping(value = "{user_id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("user_id") Integer user_id){
        Optional<Usuario> optionalUsuario= userDAO.findById(user_id);
        if (optionalUsuario.isPresent()){
            return ResponseEntity.ok(optionalUsuario.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
        Usuario newuser = userDAO.save(usuario);
        return ResponseEntity.ok(newuser);
    }
}
