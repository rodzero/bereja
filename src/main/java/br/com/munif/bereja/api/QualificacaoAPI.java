package br.com.munif.bereja.api;

import br.com.munif.bereja.entidades.Qualificacao;
import javax.servlet.annotation.WebServlet;

/**
 * API de Cervejaria
 * @author munif
 */
@WebServlet(name = "QualificacaoAPI", urlPatterns = {"/api/qualificacao/*"})
public class QualificacaoAPI extends SuperApi<Qualificacao> {

    @Override
    public Class<Qualificacao> getClazz() {
        return Qualificacao.class;
    }

}
