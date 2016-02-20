package br.com.munif.bereja.negocio;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.bereja.repositorio.UsuarioRepositorio;
import java.util.List;

public class UsuarioService {
    
    public static List<Usuario> listaUsuarios(){
        return UsuarioRepositorio.consultaUsuarios();
    }

    public static void excluir(Long id) {
        Usuario usuario = UsuarioRepositorio.consultaUsuario(id);
        if (usuario==null){
            throw new RuntimeException("Usuário não existe");
        }
        UsuarioRepositorio.excluir(usuario);
    }

    public static Usuario recuperar(Long id) {
        Usuario usuario = UsuarioRepositorio.consultaUsuario(id);
        if (usuario==null){
            throw new RuntimeException("Usuário não existe");
        }
        return usuario;
    }

    public static void salvar(Usuario usu) {
        UsuarioRepositorio.salvar(usu);
    }
    
}
