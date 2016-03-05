package br.com.munif.util;

import br.com.munif.bereja.entidades.util.Persistencia;
import org.hibernate.envers.RevisionListener;

public class OuvinteAuditoria implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        AuditoriaRevisao ar = (AuditoriaRevisao) o;
        ar.setUsuario(Persistencia.getInstancia().login.get());
        ar.setIp(Persistencia.getInstancia().ip.get());
    }
}
