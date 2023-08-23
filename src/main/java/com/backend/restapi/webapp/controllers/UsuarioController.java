package com.backend.restapi.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.restapi.webapp.dao.UsuarioDao;
import com.backend.restapi.webapp.models.Usuario;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    //search with id TODO: Implementent find
    @GetMapping("api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable int id) {

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("eduardo");
        usuario.setApellido("Hm");
        usuario.setEmail("kratosedu18@gmail.com");
        usuario.setTelefono("9191695165");
        usuario.setPassword("nose");

        return usuario;
    }

    @RequestMapping(value="api/usuarios", method= RequestMethod.GET)
    public List<Usuario> getAllusuarios() {
        return usuarioDao.getUsuarios();
    }

    // create
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void createUser(@RequestBody Usuario usuario) {
         usuarioDao.createUser(usuario);
    }

    // delete controller
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }

}
