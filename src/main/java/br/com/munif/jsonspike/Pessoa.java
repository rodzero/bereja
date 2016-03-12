package br.com.munif.jsonspike;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;

public class Pessoa {

    private String nome;
    private Integer idade;

    @JsonManagedReference
    private Grupo grupo;

    public Pessoa() {
    }

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        System.out.println("---->Chamou o getNome");
        return nome;
    }

    public void setNome(String nome) {
        System.out.println("---->Chamou o setNome");
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return 2016 - idade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "\"nome\":\"" + nome + "\", \"idade\":" + idade + '}';
    }

}
