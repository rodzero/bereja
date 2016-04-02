package br.com.munif.bereja.api;

import br.com.munif.bereja.entidades.Token;
import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.bereja.negocio.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CriaToken", urlPatterns = {"/token/*"})
public class CriaToken extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioService();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(response.getOutputStream(), Token.getLista());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        UsuarioSenhaTO usuarioSenha = mapper.readValue(request.getInputStream(), UsuarioSenhaTO.class);
        Usuario usuario = usuarioService.recuperaPorLoginESenha(usuarioSenha.usuario, usuarioSenha.senha);
        if (usuario != null) {
            Token token = new Token(usuario.getCervejaria().getId());
            mapper.writeValue(response.getOutputStream(), token);
        } else {
            response.setStatus(401);
            mapper.writeValue(response.getOutputStream(), "Não autorizado");
        }
    }

    private static class UsuarioSenhaTO {

        private String usuario;
        private String senha;

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenhal(String senha) {
            this.senha = senha;
        }

    }

}
