/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.negocio;

import br.com.munif.bereja.entidades.Qualificacao;
import br.com.munif.bereja.repositorio.QualificacaoRepositorio;
import br.com.munif.bereja.repositorio.Repositorio;


public class QualificacaoService extends Service<Qualificacao>{

    public QualificacaoService() {
        super(Qualificacao.class);
    }
 
    @Override
    protected Repositorio<Qualificacao> getRepositorio() {
        return new QualificacaoRepositorio();
    }
    
}
