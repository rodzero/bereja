package br.com.munif.util;

import br.com.munif.bereja.entidades.util.SuperEntidade;
import br.com.munif.bereja.negocio.Service;
import br.com.munif.bereja.repositorio.Repositorio;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Converter Genérico
 *
 * @author Munif
 */
public class ConverterGenerico implements Converter, Serializable {

    private final Service service;

    public ConverterGenerico(Service service) {
        this.service = service;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long chave = new Long(value);
        SuperEntidade obj = service.recuperar(chave);
        return obj;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            String aRetornar = ((SuperEntidade) value).getId().toString();
            return aRetornar;
        } else {
            return null;
        }
    }
}
