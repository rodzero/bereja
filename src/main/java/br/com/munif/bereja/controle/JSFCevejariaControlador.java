package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.bereja.negocio.CervejariaService;
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
public class JSFCevejariaControlador implements Serializable{
    
    private final CervejariaService service;
    
    private Cervejaria entidade;
    private List<Cervejaria> lista;
    private String filtro;

    public JSFCevejariaControlador() {
        this.service = new CervejariaService();
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Cervejaria getEntidade() {
        return entidade;
    }

    public void setEntidade(Cervejaria entidade) {
        this.entidade = entidade;
    }

    public List<Cervejaria> getLista() {
        if (lista == null) {
            lista = service.lista();
        }
        return lista;
    }

    public void setLista(List<Cervejaria> lista) {
        this.lista = lista;
    }

    public void novo() {
        entidade = new Cervejaria();
    }

    public void excluir(Cervejaria aRemover) {
        service.excluir(aRemover.getId());
        //FacesUtil.addMessageInfo("Informação", "O objeto foi excluído.");
        lista=null;
    }

    public void salvar() {
         service.salvar(entidade);
        if (entidade.getId() == null) {
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
