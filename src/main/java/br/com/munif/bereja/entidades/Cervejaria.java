package br.com.munif.bereja.entidades;

import br.com.munif.bereja.entidades.util.SuperEntidade;
import javax.persistence.Entity;
import org.hibernate.envers.Audited;

/**
 *
 * @author munif
 */
@Audited
@Entity
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
