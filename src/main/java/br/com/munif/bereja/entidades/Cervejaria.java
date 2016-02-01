/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.entidades;

import br.com.munif.bereja.entidades.util.SuperEntidade;

/**
 *
 * @author munif
 */
public class Cervejaria extends SuperEntidade {

    private String nome;

    public Cervejaria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
