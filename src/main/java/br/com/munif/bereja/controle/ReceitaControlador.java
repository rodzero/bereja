/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Receita;
import br.com.munif.bereja.entidades.Receita;
import br.com.munif.bereja.negocio.ReceitaService;
import br.com.munif.bereja.negocio.ReceitaService;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

/**
 *
 * @author munif
 */
@WebServlet(name = "ReceitaControlador", urlPatterns = {"/receita/controlador"})
public class ReceitaControlador extends SuperControlador {

    private ReceitaService receitaService = new ReceitaService();

    public String padrao(HttpServletRequest request) {
        List<Receita> receitas = receitaService.lista();
        request.setAttribute("receita", receitas);
        return "lista.jsp";
    }

    public String criar(HttpServletRequest request) {
        Receita usu = new Receita();
        request.setAttribute("receita", usu);
        return "detalhes.jsp";
    }

    public String alterar(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        Receita usu = receitaService.recuperar(id);
        request.setAttribute("receita", usu);
        return "detalhes.jsp";
    }

    public String excluir(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        receitaService.excluir(id);
        return padrao(request);
    }

    public String salvar(HttpServletRequest request) throws JasperException {
        Receita usu = new Receita();
        JspRuntimeLibrary.introspect(usu, request);
        receitaService.salvar(usu);
        return padrao(request);
    }

}
