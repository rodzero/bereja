package br.com.munif.bereja.api;

import br.com.munif.bereja.entidades.Receita;
import javax.servlet.annotation.WebServlet;

/**
 * API de Cervejaria
 * @author munif
 */
@WebServlet(name = "ReceitaAPI", urlPatterns = {"/api/receita/*"})
public class ReceitaAPI extends SuperApi<Receita> {

    @Override
    public Class<Receita> getClazz() {
        return Receita.class;
    }

}
