/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.bereja.negocio.CervejariaService;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

/**
 *
 * @author rodolfo
 */
@WebServlet(name = "CervejariaControlador", urlPatterns = {"/cervejaria/controlador"})
public class CervejariaControlador extends SuperControlador {

    private CervejariaService cervejariaService = new CervejariaService();

    @Override
    public String padrao(HttpServletRequest request) {
        List<Cervejaria> cervejarias = cervejariaService.lista();
        request.setAttribute("cervejarias", cervejarias);
        return "lista.jsp";
    }
    
    public String criar(HttpServletRequest request) {
        Cervejaria cervejaria = new Cervejaria();
        request.setAttribute("cervejaria", cervejaria);
        return "detalhes.jsp";
    }

    public String alterar(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        Cervejaria cervejaria = cervejariaService.recuperar(id);
        request.setAttribute("cervejaria", cervejaria);
        return "detalhes.jsp";
    }

    public String excluir(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        cervejariaService.excluir(id);
        return padrao(request);
    }

    public String salvar(HttpServletRequest request) throws JasperException {
        Cervejaria cervejaria = new Cervejaria();
        JspRuntimeLibrary.introspect(cervejaria, request);
        cervejariaService.salvar(cervejaria);
        return padrao(request);
    }
    
}
