/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.entidades;

import br.com.munif.util.SuperEntidade;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;

/**
 *
 * @author munif
 */
@Audited
@Entity
public class Qualificacao extends SuperEntidade {

    @Temporal(TemporalType.TIMESTAMP)
    private Date quando;

    private String texto;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Producao producao;
  

    public Qualificacao() {
        quando = new Date();
    }

    public Date getQuando() {
        return quando;
    }

    public void setQuando(Date quando) {
        this.quando = quando;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }
    
    

}
