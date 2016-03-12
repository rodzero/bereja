package controladores;

import br.com.munif.bereja.entidades.Producao;
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
 * @author Gerador EspeWeb em Sat Mar 12 14:45:00 BRT 2016
 */
@SessionScoped
@ManagedBean
public class ProducaoControladorJSF implements Serializable {

    private final Service<Producao> service;

    private Producao entidade;
    private List<Producao> lista;
    private List<RevisaoEObjeto> listaRevisao;
    private String filtro;
    private Boolean novo;

    public List<RevisaoEObjeto> getListaRevisao() {
        return listaRevisao;
    }

    public Boolean getNovo() {
        return novo;
    }

    public ProducaoControladorJSF() {
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
        novo = false;
        listaRevisao = service.listaVersoes(entidade.getId());
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
        novo = true;
    }

    public void excluir(Producao aRemover) {
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
