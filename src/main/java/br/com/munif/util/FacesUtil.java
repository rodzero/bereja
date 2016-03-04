/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author peixe
 * @author gecen
 *
 */
public abstract class FacesUtil {

    /**
     *
     */
    private static final String ID_CLIENTE_PADRAO = "msgs";

    /**
     * Adiciona uma mensagem do tipo FacesMessage.SEVERITY_WARN no contexto do
     * JSF, utilizando o id "msgs" padrão.
     *
     * @param summary Mensagem resumida
     *
     * @param detail Detalhe da mensagem
     */
    public static void addMessageWarn(String summary, String detail) {
        addMessageWarn(ID_CLIENTE_PADRAO, summary, detail);
    }

    /**
     * Adiciona uma mensagem do tipo FacesMessage.SEVERITY_WARN no contexto do
     * JSF.
     *
     * @param clientId Nome da variável que será utilizada na view xhtml.
     *
     * @param summary Mensagem resumida
     *
     * @param detail Detalhe da mensagem
     */
    public static void addMessageWarn(String clientId, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
    }

    /**
     * Adiciona uma mensagem do tipo FacesMessage.SEVERITY_ERROR no contexto do
     * JSF, utilizando o id "msgs" padrão.
     *
     * @param summary Mensagem resumida
     *
     * @param detail Detalhe da mensagem
     */
    public static void addMessageError(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(ID_CLIENTE_PADRAO, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    /**
     * Adiciona uma mensagem do tipo FacesMessage.SEVERITY_ERROR no contexto do
     * JSF.
     *
     * @param clientId Nome da variável que será utilizada na view xhtml.
     *
     * @param summary Mensagem resumida
     *
     * @param detail Detalhe da mensagem
     */
    public static void addMessageError(String clientId, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    /**
     * Adiciona uma mensagem do tipo FacesMessage.SEVERITY_INFO no contexto do
     * JSF, utilizando o id "msgs" padrão.
     *
     * @param summary Mensagem resumida
     *
     * @param detail Detalhe da mensagem
     */
    public static void addMessageInfo(String summary, String detail) {
        addMessageInfo(ID_CLIENTE_PADRAO, summary, detail);
    }

    /**
     * Adiciona uma mensagem do tipo FacesMessage.SEVERITY_INFO no contexto do
     * JSF.
     *
     * @param clientId Nome da variável que será utilizada na view xhtml.
     *
     * @param summary Mensagem resumida
     *
     * @param detail Detalhe da mensagem
     */
    public static void addMessageInfo(String clientId, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }
    
    
    
        /**
     *
     * isPostback,isNotPostback -> Quando o escopo é RequestScoped, a cada click
     * o construtor é executado, com este metodo é possivel saber se a
     * requisição é a primeira(primeira vez que o RequestScoped é executado
     * (isPostback).
     *
     */
    private static boolean isPostback() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public static boolean isNotPostback() {
        return !isPostback();
    }

    /*
    * executarJavaScript -> Executa um código javaScript passado por parametro.
    *
    * @param javaScript é o codigo javaScript que será executado
    *
    */
    
    public static void executarJavaScript(String javaScript) {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute(javaScript);
    }
}
