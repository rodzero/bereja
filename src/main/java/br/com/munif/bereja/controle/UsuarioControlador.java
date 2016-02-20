/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.bereja.negocio.UsuarioService;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

/**
 *
 * @author munif
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/usuario/controlador"})
public class UsuarioControlador extends SuperControlador {

    private UsuarioService usuarioService = new UsuarioService();

    public String padrao(HttpServletRequest request) {
        List<Usuario> usuarios = usuarioService.lista();
        request.setAttribute("usuarios", usuarios);
        return "lista.jsp";
    }

    public String criar(HttpServletRequest request) {
        Usuario usu = new Usuario();
        request.setAttribute("usuario", usu);
        return "detalhes.jsp";
    }

    public String alterar(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        Usuario usu = usuarioService.recuperar(id);
        request.setAttribute("usuario", usu);
        return "detalhes.jsp";
    }

    public String excluir(HttpServletRequest request) throws NumberFormatException {
        Long id = new Long(request.getParameter("id"));
        usuarioService.excluir(id);
        return padrao(request);
    }

    public String salvar(HttpServletRequest request) throws JasperException {
        Usuario usu = new Usuario();
        JspRuntimeLibrary.introspect(usu, request);
        usuarioService.salvar(usu);
        return padrao(request);
    }

}
