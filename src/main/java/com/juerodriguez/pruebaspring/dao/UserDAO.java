package com.juerodriguez.pruebaspring.dao;

import com.juerodriguez.pruebaspring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Usuario, Integer> {
}
