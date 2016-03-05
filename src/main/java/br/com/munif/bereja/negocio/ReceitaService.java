/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.negocio;

import br.com.munif.bereja.entidades.Receita;
import br.com.munif.bereja.repositorio.ReceitaRepositorio;
import br.com.munif.bereja.repositorio.Repositorio;
import java.util.List;

public class ReceitaService extends Service<Receita>{

    public ReceitaService() {
        super(Receita.class);
    }
 
    @Override
    protected Repositorio<Receita> getRepositorio() {
        return new ReceitaRepositorio();
    }
    
    public List<Receita> filtra(String s){
        return ((ReceitaRepositorio)repositorio).filtra(s);
    }
    
    
    
    
}
