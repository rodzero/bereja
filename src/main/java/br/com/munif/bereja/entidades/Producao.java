/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.entidades;

import br.com.munif.util.SuperEntidade;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;

/**
 *
 * @author munif
 */
@Audited
@Entity
public class Producao extends SuperEntidade {

    @Temporal(TemporalType.TIMESTAMP)
    private Date quando;

    private String historico;

    private Integer quantidade;

    @ManyToOne
    private Receita receita;
    
    @OneToMany(mappedBy = "producao")
    private List<Qualificacao> qualificacoes;

    public Producao() {
        quando=new Date();
    }

    public List<Qualificacao> getQualificacoes() {
        return qualificacoes;
    }

    public void setQualificacoes(List<Qualificacao> qualificacoes) {
        this.qualificacoes = qualificacoes;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Date getQuando() {
        return quando;
    }

    public void setQuando(Date quando) {
        this.quando = quando;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
