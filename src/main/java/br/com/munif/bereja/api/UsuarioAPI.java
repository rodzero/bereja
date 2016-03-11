package br.com.munif.bereja.api;

import br.com.munif.bereja.entidades.Usuario;
import javax.servlet.annotation.WebServlet;

/**
 * API de Cervejaria
 * @author munif
 */
@WebServlet(name = "UsuarioAPI", urlPatterns = {"/api/usuario/*"})
public class UsuarioAPI extends SuperApi<Usuario> {

    @Override
    public Class<Usuario> getClazz() {
        return Usuario.class;
    }

}
