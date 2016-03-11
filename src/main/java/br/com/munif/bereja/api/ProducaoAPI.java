package br.com.munif.bereja.api;

import br.com.munif.bereja.entidades.Producao;
import javax.servlet.annotation.WebServlet;

/**
 * API de Cervejaria
 * @author munif
 */
@WebServlet(name = "ProducaoAPI", urlPatterns = {"/api/producao/*"})
public class ProducaoAPI extends SuperApi<Producao> {

    @Override
    public Class<Producao> getClazz() {
        return Producao.class;
    }

}
