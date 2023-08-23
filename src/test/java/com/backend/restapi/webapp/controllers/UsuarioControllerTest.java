package com.backend.restapi.webapp.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.backend.restapi.webapp.dao.UsuarioDao;
import com.backend.restapi.webapp.models.Usuario;

//@WebMvcTest(UsuarioController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UsuarioDao usuarioDao;

    private List<Usuario> usuarios;

    @InjectMocks
    private UsuarioController usuarioController;

    // tests

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        usuarios = new ArrayList<>();
        // Crear un Usuario utilizando setters generados por Lombok
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("eduardo");
        usuario.setApellido("hernandez");
        usuario.setEmail("kratosedu18@gmail.com");
        usuario.setTelefono("9191695165");
        usuario.setPassword("nose");

        usuarios.add(usuario);

        // Configurar el comportamiento del mock
        when(usuarioDao.getUsuarios()).thenReturn(usuarios);
    }

    // get all users
    @Test
    
        public void testGetUser() throws Exception {
        when(usuarioDao.getUsuarios()).thenReturn(usuarios);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/usuarios"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("eduardo"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].apellido").value("hernandez"));
    }

    // Test delete user
    @Test
    public void testDeleteUser() throws Exception {
        // Configuration mock
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/usuarios/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //verify(usuarioDao, times(1)).eliminar(1L);
    }
}
