package controladores;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.util.ConverterGenerico;
import br.com.munif.bereja.negocio.*;
import br.com.munif.util.FacesUtil;
import br.com.munif.util.RevisaoEObjeto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.Converter;

/**
 *
 * @author Gerador EspeWeb em Sat Mar 12 14:43:58 BRT 2016
 */
@SessionScoped
@ManagedBean
public class UsuarioControladorJSF implements Serializable {

    private final Service<Usuario> service;

    private Usuario entidade;
    private List<Usuario> lista;
    private List<RevisaoEObjeto> listaRevisao;
    private String filtro;
    private Boolean novo;

    public List<RevisaoEObjeto> getListaRevisao() {
        return listaRevisao;
    }

    public Boolean getNovo() {
        return novo;
    }

    public UsuarioControladorJSF() {
        this.service = new Service<>(Usuario.class);
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Usuario getEntidade() {
        return entidade;
    }

    public void setEntidade(Usuario entidade) {
        this.entidade = entidade;
        novo = false;
        listaRevisao = service.listaVersoes(entidade.getId());
    }

    public List<Usuario> getLista() {
        if (lista == null) {
            lista = service.lista();
        }
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public void novo() {
        entidade = new Usuario();
        novo = true;
    }

    public void excluir(Usuario aRemover) {
        service.excluir(aRemover.getId());
        FacesUtil.addMessageInfo("Informação", "O objeto foi excluído.");
        lista = null;
    }

    public void salvar() {
        service.salvar(entidade);
        if (novo) {
            FacesUtil.addMessageInfo("Informação", "O registro foi inserido.");
        } else {
            FacesUtil.addMessageInfo("Informação", "O registro foi alterado.");
        }
        lista = null;
    }

    public void cancelar() {
        entidade = null;
        FacesUtil.addMessageWarn("Aviso", "A operação foi cancelada");
    }

    public void filtrar() {
        if (filtro != null) {
            lista = service.lista(); //TODO Filtrar a 
        }
    }

    public Converter getConverter() {
        return new ConverterGenerico(service);
    }

}
