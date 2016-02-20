/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.bereja.negocio.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.runtime.JspRuntimeLibrary;

/**
 *
 * @author munif
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/usuario/controlador"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String proximaPagina = "lista.jsp";
            String acao = request.getParameter("acao");
            if (acao == null) {
                acao = "listar";
            }
            if ("salvar".equals(acao)) {
                Usuario usu = new Usuario();
                JspRuntimeLibrary.introspect(usu, request);
                UsuarioService.salvar(usu);
                acao="listar";
            }
            if ("excluir".equals(acao)) {
                Long id = new Long(request.getParameter("id"));
                UsuarioService.excluir(id);
                acao = "listar";
            }
            if ("listar".equals(acao)) {
                List<Usuario> usuarios = UsuarioService.listaUsuarios();
                request.setAttribute("usuarios", usuarios);
                proximaPagina = "lista.jsp";
            }
            if ("alterar".equals(acao)) {
                Long id = new Long(request.getParameter("id"));
                Usuario usu = UsuarioService.recuperar(id);
                request.setAttribute("usuario", usu);
                proximaPagina = "detalhes.jsp";
            }
            if ("criar".equals(acao)) {
                Usuario usu = new Usuario();
                request.setAttribute("usuario", usu);
                proximaPagina = "detalhes.jsp";
            }

            request.getRequestDispatcher(proximaPagina).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
