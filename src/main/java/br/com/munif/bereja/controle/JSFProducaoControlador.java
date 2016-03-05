package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Producao;
import br.com.munif.bereja.negocio.Service;
import br.com.munif.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author munif
 */
@SessionScoped
@ManagedBean
public class JSFProducaoControlador implements Serializable{
    
    private final Service<Producao> service;
    
    private Producao entidade;
    private List<Producao> lista;
    private String filtro;
    private Boolean novo;

    public JSFProducaoControlador() {
        this.service = new Service<>(Producao.class);
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Producao getEntidade() {
        return entidade;
    }

    public void setEntidade(Producao entidade) {
        this.entidade = entidade;
        novo=false;
    }

    public List<Producao> getLista() {
        if (lista == null) {
            lista = service.lista();
        }
        return lista;
    }

    public void setLista(List<Producao> lista) {
        this.lista = lista;
    }

    public void novo() {
        entidade = new Producao();
        novo=true;
    }
    
    public void excluir(Producao aRemover) {
        service.excluir(aRemover.getId());
        FacesUtil.addMessageInfo("Informação", "O objeto foi excluído.");
        lista=null;
    }

    public void salvar() {
         service.salvar(entidade);
        if (novo) {
            FacesUtil.addMessageInfo("Informação", "O registro foi inserido.");
        } else {
            FacesUtil.addMessageInfo("Informação", "O registro foi alterado.");
        }
        lista=null;
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
    
}
