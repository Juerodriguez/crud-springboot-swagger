package com.juerodriguez.pruebaspring.controllers;

import com.juerodriguez.pruebaspring.dao.UserDAO;
import com.juerodriguez.pruebaspring.model.Usuario;
import com.juerodriguez.pruebaspring.services.UsuarioServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Tag(name = "Controlador de Usuario", description = "Una api para mostrar un Spring Boot Rest CRUD")
@RestController
@RequestMapping("user")
public class UsuarioControl {

    @Autowired
    private UsuarioServices usuarioServices;

    @Operation(
            summary = "Obtención de usuario por ID",
            description = "Escribir solamente el id")
    @GetMapping(value = "{user_id}")
    public ResponseEntity<Object> getUsuario(@PathVariable("user_id") Integer user_id){
        try {
            Usuario data  = usuarioServices.findByid(user_id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Crear usuario",
            description = "Escribir todos los campos, el campo id no es obligatorio ya que se auto genera")
    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
        Usuario newuser =usuarioServices.save(usuario);
        return ResponseEntity.ok(newuser);
    }

    @Operation(
            summary = "Eliminacion de usuario por ID",
            description = "Escribir solamente el id")
    @DeleteMapping(value = "{user_id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable("user_id") Integer user_id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Usuario currentPerson = usuarioServices.findByid(user_id);
            usuarioServices.delete(currentPerson);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{user_id}")
    public ResponseEntity<Object> update(@RequestBody Usuario usuario, @PathVariable Integer user_id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            Usuario currentUser = usuarioServices.findByid(user_id);

            currentUser.setNombre(usuario.getNombre());
            currentUser.setApellido(usuario.getApellido());

            Usuario res = usuarioServices.save(usuario);

            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

