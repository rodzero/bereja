package controladores;

import br.com.munif.bereja.entidades.Cervejaria;
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
 * @author Gerador EspeWeb em Sat Mar 12 14:44:53 BRT 2016
 */
@SessionScoped
@ManagedBean
public class CervejariaControladorJSF implements Serializable {

    private final Service<Cervejaria> service;

    private Cervejaria entidade;
    private List<Cervejaria> lista;
    private List<RevisaoEObjeto> listaRevisao;
    private String filtro;
    private Boolean novo;

    public List<RevisaoEObjeto> getListaRevisao() {
        return listaRevisao;
    }

    public Boolean getNovo() {
        return novo;
    }

    public CervejariaControladorJSF() {
        this.service = new Service<>(Cervejaria.class);
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
        novo = false;
        listaRevisao = service.listaVersoes(entidade.getId());
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
        novo = true;
    }

    public void excluir(Cervejaria aRemover) {
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
