package br.com.munif.bereja.entidades;

import br.com.munif.bereja.entidades.util.SuperEntidade;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
public class Usuario extends SuperEntidade  {
   
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
