package br.com.munif.util;

import br.com.munif.bereja.repositorio.Repositorio;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Converter para AutoComplete
 *
 * @author Munif
 */
public class ConverterAutoComplete implements Converter, Serializable {

    private final Class clazz;
    private final Repositorio repositorio;

    public ConverterAutoComplete(Class clazz) {
        this.clazz = clazz;
        repositorio = new Repositorio(clazz);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Long chave = new Long(value);
            SuperEntidade obj = repositorio.consulta(chave);
            return obj;
        } catch (Exception ex) {
            //Evita mensagens durante a digitaçao parcial.
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(value);
        } else {
            return null;
        }
    }
}
