/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.entidades.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author munif
 */
public class Persistencia {

    private static Persistencia instancia = new Persistencia();

    public ThreadLocal<EntityManager> tlem=new ThreadLocal<>();

    public static Persistencia getInstancia() {
        return instancia;
    }
    private final EntityManagerFactory emf;

    private Persistencia() {
        emf = Persistence.createEntityManagerFactory("berejaPU");
    }

    public EntityManager getEntityManager() {
        if (tlem.get()==null){
            tlem.set(emf.createEntityManager());
        }
        return tlem.get();
    }
    public void destroyEntityManager() {
        tlem.get().close();
        tlem.remove();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        emf.close();
    }

}
