package br.com.munif.util;

import br.com.munif.bereja.entidades.Cervejaria;
import javax.persistence.PrePersist;

public class MultiTenancyListener {

    @PrePersist
    public void prePersist(SuperEntidade entidade) {
        Cervejaria cervejariaDousuario = Persistencia.getInstancia().cervejaria.get();
        System.out.println("------->"+cervejariaDousuario);
        if (cervejariaDousuario != null) {
            entidade.setCervejaria(cervejariaDousuario);
        }
    }
}
