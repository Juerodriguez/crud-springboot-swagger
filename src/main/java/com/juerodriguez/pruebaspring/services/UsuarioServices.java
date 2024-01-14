package com.juerodriguez.pruebaspring.services;

import com.juerodriguez.pruebaspring.model.Usuario;

import java.util.List;

public interface UsuarioServices {
    public List<Usuario> findAll();

    public Usuario save(Usuario usuario);

    public Usuario findByid(Integer id);

    public void delete(Usuario usuario);
}
