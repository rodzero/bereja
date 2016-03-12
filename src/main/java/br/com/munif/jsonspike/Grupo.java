package br.com.munif.jsonspike;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;

public class Grupo {
    
    public String nome;
    
    @JsonBackReference
    public Set<Pessoa> pessoas;

    public Grupo() {
    }

    public Grupo(String nome, Set<Pessoa> pessoas) {
        this.nome = nome;
        this.pessoas = pessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nome=" + nome + ", pessoas=" + pessoas + '}';
    }
    
    
    
    
    
}
