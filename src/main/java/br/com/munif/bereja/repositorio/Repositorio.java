/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.util.Persistencia;
import br.com.munif.util.SuperEntidade;
import br.com.munif.util.AuditoriaRevisao;
import br.com.munif.util.RevisaoEObjeto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

/**
 *
 * @author munif
 */
public class Repositorio<T extends SuperEntidade> {

    protected Class<T> clazz;

    protected final String consultaBasica;

    public Repositorio(Class<T> clazz) {
        this.clazz = clazz;
        consultaBasica = "from " + clazz.getSimpleName() + " obj where (obj.cervejaria is null or obj.cervejaria=:cervejaria) ";
    }

    public List<T> consulta() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        Query query = em.createQuery(consultaBasica);
        setaParametroTenancy(query);
        return query.getResultList();
    }

    protected void setaParametroTenancy(Query query) {
        query.setParameter("cervejaria", Persistencia.getInstancia().cervejaria.get());
    }

    public T consulta(long id) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        T object = em.find(clazz, id);
        verificaSeEhDono(object);
        return object;
    }

    public void excluir(T obj) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        verificaSeEhDono(obj);
        em.remove(obj);

    }

    public T salvar(T obj) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        T object = em.find(clazz, obj.getId());
        verificaSeEhDono(object);
        T aRetornar = em.merge(obj);
        return aRetornar;

    }

    public List<RevisaoEObjeto> listaVersoes(Long id) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        T object2 = em.find(clazz, id);
        verificaSeEhDono(object2);
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

    private void verificaSeEhDono(T object) {
        if (object==null){
            return;
        }
        Cervejaria cervejaria = Persistencia.getInstancia().cervejaria.get();
        if (cervejaria != null) {
            if (!cervejaria.equals(object.getCervejaria())) {
                throw new RuntimeException("Este registro não é seu!");
            }

        }
    }

}
