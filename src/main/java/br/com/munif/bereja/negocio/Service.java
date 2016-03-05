package br.com.munif.bereja.negocio;

import br.com.munif.bereja.entidades.util.SuperEntidade;
import br.com.munif.bereja.repositorio.Repositorio;
import br.com.munif.util.RevisaoEObjeto;
import java.util.List;

public class Service<T extends SuperEntidade> {

    protected final Class<T> clazz;
    protected final Repositorio<T> repositorio;

    public Service(Class<T> clazz) {
        this.clazz = clazz;
        repositorio = getRepositorio();
    }

    protected Repositorio<T> getRepositorio() {
        return new Repositorio<>(clazz);
    }

    public List<T> lista() {
        return repositorio.consulta();
    }

    public void excluir(Long id) {
        T obj = repositorio.consulta(id);
        if (obj == null) {
            throw new RuntimeException(clazz.getSimpleName()+" com id "+id+" não existe");
        }
        repositorio.excluir(obj);
    }

    public T recuperar(Long id) {
        T obj = repositorio.consulta(id);
        if (obj == null) {
            throw new RuntimeException(clazz.getSimpleName()+" com id "+id+" não existe");
        }
        return obj;
    }

    public T salvar(T obj) {
        return repositorio.salvar(obj);
    }
    
    public List<RevisaoEObjeto> listaVersoes(Long id) {
        return repositorio.listaVersoes(id);
    }

}
