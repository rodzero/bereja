/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.util.Persistencia;
import br.com.munif.util.SuperEntidade;
import br.com.munif.util.AuditoriaRevisao;
import br.com.munif.util.RevisaoEObjeto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

/**
 *
 * @author munif
 */
public class Repositorio<T extends SuperEntidade> {

    protected Class<T> clazz;

    public Repositorio(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> consulta() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        return em.createQuery("from " + clazz.getSimpleName()).getResultList();
    }

    public T consulta(long id) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        return em.find(clazz, id);
    }

    public void excluir(T obj) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        em.remove(obj);

    }

    public T salvar(T obj) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        T aRetornar = em.merge(obj);
        return aRetornar;

    }

    public List<RevisaoEObjeto> listaVersoes(Long id) {
        List<RevisaoEObjeto> aRetornar = new ArrayList<>();
        AuditReader auditReader = AuditReaderFactory.get(Persistencia.getInstancia().getEntityManager());
        List<Number> revisoes = auditReader.getRevisions(clazz, id);
        for (Number n : revisoes) {
            AuditoriaRevisao auditoriaRevisao = Persistencia.getInstancia().getEntityManager()
                    .find(AuditoriaRevisao.class, n.longValue());
            Object object = auditReader.find(clazz, id, n.longValue());
            aRetornar.add(new RevisaoEObjeto(auditoriaRevisao, object));
        }
        return aRetornar;
    }

}

