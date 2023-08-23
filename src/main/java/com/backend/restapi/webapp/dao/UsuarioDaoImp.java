package com.backend.restapi.webapp.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.backend.restapi.webapp.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        List<Usuario> resultado = entityManager.createQuery(query).getResultList();
        return resultado;
    }
    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }
    @Override
    public void createUser(Usuario usuario) {
        // TODO Auto-generated method stub
        entityManager.merge(usuario);
    } 
    /**
     * @param usuario
     */
    @Override
    public boolean verificarEmailPassword(Usuario usuario){
        String query = "FROM Usuario WHERE email = :email AND password= :password";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .setParameter("password", usuario.getPassword())
                .getResultList();
        return !lista.isEmpty();


    }
}
