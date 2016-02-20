/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.negocio;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.bereja.repositorio.CervejariaRepositorio;
import br.com.munif.bereja.repositorio.Repositorio;

/**
 *
 * @author rodolfo
 */
public class CervejariaService extends Service<Cervejaria> {
    
    public CervejariaService() {
        super(Cervejaria.class);
    }
    
    @Override
    protected Repositorio<Cervejaria> getRepositorio() {
        return new CervejariaRepositorio();
    }
    
}
