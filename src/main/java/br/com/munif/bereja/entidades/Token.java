package br.com.munif.bereja.entidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Token {

    public static Map<String, Token> lista = new HashMap<>();

    private final long idCervejaria;
    private long validade;
    private final String valor;

    public Token(long idCervejaria) {

        this.idCervejaria = idCervejaria;
        this.validade = System.currentTimeMillis() + 60 * 1000;
        String valor;
        do {
            valor = Long.toString((long) (Math.random() * 123456789012345678l), 16);
        } while (lista.get(valor) != null);
        this.valor = valor;
        Token.lista.put(valor, this);

    }

    public static Map<String,Token> getLista() {
        return lista;
    }


    public long getIdCervejaria() {
        return idCervejaria;
    }

    public long getValidade() {
        return validade;
    }

    public String getValor() {
        return valor;
    }

    public void setValidade(long validade) {
        this.validade = validade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Token{" + "idCervejaria=" + idCervejaria + ", validade=" + validade + ", valor=" + valor + '}';
    }

}
