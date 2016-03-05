package br.com.munif.bereja.controle;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.bereja.entidades.Receita;
import br.com.munif.bereja.negocio.CervejariaService;
import br.com.munif.bereja.negocio.ReceitaService;
import br.com.munif.util.ConverterGenerico;
import br.com.munif.util.FacesUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@SessionScoped
@ManagedBean
public class JSFReceitaControlador {

    private final ReceitaService service;

    private Receita entidade;
    private List<Receita> lista;
    private String filtro;
    private Boolean novo;

    public JSFReceitaControlador() {
        this.service = new ReceitaService();
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Receita getEntidade() {
        return entidade;
    }

    public void setEntidade(Receita entidade) {
        this.entidade = entidade;
        novo = false;
    }

    public List<Receita> getLista() {
        if (lista == null) {
            lista = service.lista();
        }
        return lista;
    }

    public void setLista(List<Receita> lista) {
        this.lista = lista;
    }

    public void novo() {
        entidade = new Receita();
        novo = true;
    }

    public void excluir(Receita aRemover) {
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
            lista = filtrarPor(filtro);
        }
    }
    
    public List<Receita> filtrarPor(String s){
       return service.filtra(s);
    }
    

    public List<String> completeArea(String query) {
        List<String> possiveis = Arrays.asList(new String[]{
            "água", "lupulo", "malte", "levedura", "panela", "densímetro", "ml", "litros"
        });
        List<String> results = new ArrayList<String>();
        possiveis.stream().filter((obj) -> (obj.startsWith(query))).forEach((obj) -> {
            results.add(obj);
        });
        return results;
    }

    public Converter getConverter2() {
        return new Converter() {
            @Override
            public String getAsString(FacesContext context, UIComponent component, Object value) {
                return ((Receita) value).getId().toString();
            }

            @Override
            public Object getAsObject(FacesContext context, UIComponent component, String value) {
                return service.recuperar(new Long(value));
            }
        };
    }
    
    public Converter getConverter() {
        return new ConverterGenerico(service);
    }
    

}
