package com.juerodriguez.pruebaspring.services;

import com.juerodriguez.pruebaspring.dao.UserDAO;
import com.juerodriguez.pruebaspring.model.Usuario;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicesImp implements  UsuarioServices{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<Usuario> findAll() {
        return (List<Usuario>) userDAO.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return userDAO.save(usuario);
    }

    @Override
    public Usuario findByid(Integer id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {

    }
}
