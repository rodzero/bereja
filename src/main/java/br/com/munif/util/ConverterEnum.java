/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.util;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Munif
 */
public class ConverterEnum implements Serializable, Converter {

    private Enum _enum;

    public ConverterEnum(Enum _enum) {
        this._enum = _enum;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return null;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
}
