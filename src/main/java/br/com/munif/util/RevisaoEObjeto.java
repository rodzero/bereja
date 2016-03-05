package br.com.munif.util;

/**
 *
 * @author munif
 */

public class RevisaoEObjeto {

    public AuditoriaRevisao auditoriaRevisao;
    public Object objeto;

    public RevisaoEObjeto(AuditoriaRevisao auditoriaRevisao, Object objeto) {
        this.auditoriaRevisao = auditoriaRevisao;
        this.objeto = objeto;
    }

    public AuditoriaRevisao getAuditoriaRevisao() {
        return auditoriaRevisao;
    }

    public void setAuditoriaRevisao(AuditoriaRevisao auditoriaRevisao) {
        this.auditoriaRevisao = auditoriaRevisao;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}