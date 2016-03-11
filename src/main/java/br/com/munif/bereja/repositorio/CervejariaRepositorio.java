/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.util.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rodolfo
 */
public class CervejariaRepositorio extends Repositorio<Cervejaria> {
    
    public CervejariaRepositorio() {
        super(Cervejaria.class);
    }
    
    @Override
    public List<Cervejaria> consulta() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        return em.createQuery("from Cervejaria c order by c.nome").getResultList();
    }
    
}
