/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.bereja.entidades.Producao;
import br.com.munif.bereja.negocio.CervejariaService;
import br.com.munif.bereja.negocio.Service;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

/**
 *
 * @author munif
 */
@WebServlet(name = "ProducaoControlador", urlPatterns = {"/producao/controlador"})
public class ProducaoControlador extends SuperControlador{
    private Service<Producao> producaoService = new Service<>(Producao.class);

    @Override
    public String padrao(HttpServletRequest request) {
        List<Producao> producoes = producaoService.lista();
        request.setAttribute("producoes", producoes);
        return "lista.jsp";
    }
    
    public String criar(HttpServletRequest request) {
        Producao producao = new Producao();
        request.setAttribute("producao", producao);
        return "detalhes.jsp";
    }

    public String alterar(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        Producao producao = producaoService.recuperar(id);
        request.setAttribute("producao", producao);
        return "detalhes.jsp";
    }

    public String excluir(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        producaoService.excluir(id);
        return padrao(request);
    }

    public String salvar(HttpServletRequest request) throws JasperException {
        Producao producao = new Producao();
        JspRuntimeLibrary.introspect(producao, request);
        producaoService.salvar(producao);
        return padrao(request);
    }
    
    
}
