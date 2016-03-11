package br.com.munif.bereja.api;

import br.com.munif.bereja.entidades.Cervejaria;
import javax.servlet.annotation.WebServlet;

/**
 * API de Cervejaria
 * @author munif
 */
@WebServlet(name = "CervejariaAPI", urlPatterns = {"/api/cervejaria/*"})
public class CervejariaAPI extends SuperApi<Cervejaria> {

    @Override
    public Class<Cervejaria> getClazz() {
        return Cervejaria.class;
    }

}
