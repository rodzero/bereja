/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Qualificacao;
import br.com.munif.bereja.negocio.QualificacaoService;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

/**
 *
 * @author marcelo
 */
@WebServlet(name = "QualificacaoControlador", urlPatterns = {"/qualificacao/controlador"})
public class QualificacaoControlador extends SuperControlador {

    private QualificacaoService qualificacaoService = new QualificacaoService();

    public String padrao(HttpServletRequest request) {
        List<Qualificacao> qualificacoes = qualificacaoService.lista();
        request.setAttribute("qualificacoes", qualificacoes);
        return "lista.jsp";
    }

    public String criar(HttpServletRequest request) {
        Qualificacao q = new Qualificacao();
        request.setAttribute("qualificacao", q);
        return "detalhes.jsp";
    }

    public String alterar(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        Qualificacao q = qualificacaoService.recuperar(id);
        request.setAttribute("qualificacao", q);
        return "detalhes.jsp";
    }

    public String excluir(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        qualificacaoService.excluir(id);
        return padrao(request);
    }

    public String salvar(HttpServletRequest request) throws JasperException {
        Qualificacao q = new Qualificacao();
        JspRuntimeLibrary.introspect(q, request);
        qualificacaoService.salvar(q);
        return padrao(request);
    }
    
}
