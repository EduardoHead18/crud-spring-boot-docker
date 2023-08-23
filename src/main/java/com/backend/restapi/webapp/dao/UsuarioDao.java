package com.backend.restapi.webapp.dao;

import java.util.List;

import com.backend.restapi.webapp.models.Usuario;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);
    void createUser(Usuario usuario);
    boolean verificarEmailPassword(Usuario usuario);
}

