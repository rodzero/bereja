/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Qualificacao;
import br.com.munif.bereja.entidades.util.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;


public class QualificacaoRepositorio extends Repositorio<Qualificacao> {
    
       public QualificacaoRepositorio() {
        super(Qualificacao.class);
    }

    @Override
    public List<Qualificacao> consulta() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        return em.createQuery("from Qualificacao q order by q.quando").getResultList();
    }
    
}
