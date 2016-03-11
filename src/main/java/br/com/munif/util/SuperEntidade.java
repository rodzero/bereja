/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.util;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.bereja.entidades.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author munif
 */
@MappedSuperclass
public class SuperEntidade implements Serializable {

    @Id
    private Long id;
    @ManyToOne
    private Cervejaria cervejaria;

    private static long lastid = 0;

    public SuperEntidade() {
        id = System.currentTimeMillis() * 1000;
        if (id == lastid) {
            id++;
        }
        lastid = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cervejaria getCervejaria() {
        return cervejaria;
    }

    public void setCervejaria(Cervejaria cervejaria) {
        this.cervejaria = cervejaria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SuperEntidade other = (SuperEntidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + id + ", cervejaria=" + cervejaria + '}';
    }

    @JsonIgnore
    public Class getClazz() {
        return this.getClass();
    }

}
