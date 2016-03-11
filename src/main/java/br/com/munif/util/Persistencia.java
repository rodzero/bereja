/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.util;

import br.com.munif.bereja.entidades.Cervejaria;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author munif
 */
public class Persistencia {

    private static Persistencia instancia = new Persistencia();

    public ThreadLocal<EntityManager> tlem = new ThreadLocal<>();
    
    public ThreadLocal<String> ip=new ThreadLocal<>();
    
    public ThreadLocal<String> login=new ThreadLocal<>();
    
    public ThreadLocal<Cervejaria> cervejaria=new ThreadLocal<>();
    
    public void destroy() {
        System.out.println("------------> Finalizando Persistencia");
        emf.close();
    }

    

    public static Persistencia getInstancia() {
        return instancia;
    }
    private final EntityManagerFactory emf;

    private Persistencia() {
        System.out.println("------------> Criando Persistencia");
        emf = Persistence.createEntityManagerFactory("berejaPU");
    }

    public EntityManager getEntityManager() {
        if (tlem.get() == null) {
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

    /**
     * Infere o tipo genérico de uma classe, por exemplo, em uma lista,
     * deseja-se saber o tipo que foi utilizado na lista.
     *
     * @param clazz Classe
     * @return Tipo genérico
     */
    public static Class<?> inferGenericType(Class<?> clazz) {
        return inferGenericType(clazz, 0);
    }

    /**
     * Infere um dos tipos genérico de uma classe, por exemplo, em um mapa,
     * deseja-se saber um dos dois tipos que foi utilizado no mapa.
     *
     * @param clazz Classe
     * @param index posição do tipo
     * @return Tipo genérico
     */
    public static Class<?> inferGenericType(Class<?> clazz, int index) {
        Type superClass = clazz.getGenericSuperclass();
        return (Class<?>) ((ParameterizedType) superClass).getActualTypeArguments()[index];
    }


}
