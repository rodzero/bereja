/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.bereja.entidades.util.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author munif
 */
public class UsuarioRepositorio {

    public static List<Usuario> consultaUsuarios() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        return em.createQuery("from Usuario").getResultList();
    }

    public static Usuario consultaUsuario(long id) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();

        return em.find(Usuario.class, id);
    }

    public static void excluir(Usuario usuario) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();

        em.remove(usuario);

    }

    public static Usuario salvar(Usuario usuario) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();

        Usuario aRetornar = em.merge(usuario);

        return aRetornar;

    }

}
