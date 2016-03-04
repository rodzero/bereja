/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.util;

import org.hibernate.envers.RevisionListener;



/**
 *
 * @author unipar
 */
public class OuvinteAuditoria implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        AuditoriaRevisao ar = (AuditoriaRevisao) o;
        ar.setUsuario("indefinido");
        ar.setIp("indefinido");
    }
}
