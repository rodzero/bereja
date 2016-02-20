/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Receita;
import br.com.munif.bereja.entidades.util.Persistencia;

import javax.persistence.EntityManager;
import java.util.List;

public class ReceitaRepositorio extends Repositorio<Receita> {

    public ReceitaRepositorio() {
        super(Receita.class);
    }

    @Override
    public List<Receita> consulta() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        return em.createQuery("from Receita receita order by receita.nome").getResultList();
    }

}
