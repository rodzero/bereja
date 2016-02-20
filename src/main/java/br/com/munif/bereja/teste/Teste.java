/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.teste;

import br.com.munif.bereja.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author munif
 */
public class Teste {
    
    public static void main(String ... args){
        
        EntityManager em = Persistence.createEntityManagerFactory("berejaPU").createEntityManager();
        for (int i=0;i<100;i++){
            Usuario usu=new Usuario();
            usu.setNome(""+i);
            em.persist(usu);
        }
        em.close();
    }
    
}
