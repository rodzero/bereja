package br.com.munif.bereja.negocio;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.bereja.repositorio.Repositorio;
import java.util.List;

public class UsuarioService {
    
    public static Repositorio<Usuario> repositorio=new Repositorio<>(Usuario.class);
    
    public static List<Usuario> listaUsuarios(){
        return repositorio.consulta();
    }

    public static void excluir(Long id) {
        Usuario usuario = repositorio.consulta(id);
        if (usuario==null){
            throw new RuntimeException("Usuário não existe");
        }
        repositorio.excluir(usuario);
    }

    public static Usuario recuperar(Long id) {
        Usuario usuario = repositorio.consulta(id);
        if (usuario==null){
            throw new RuntimeException("Usuário não existe");
        }
        return usuario;
    }

    public static void salvar(Usuario usu) {
        repositorio.salvar(usu);
    }
    
}
