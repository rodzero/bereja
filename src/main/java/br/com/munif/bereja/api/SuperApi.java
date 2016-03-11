/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.api;

import br.com.munif.bereja.entidades.Cervejaria;
import br.com.munif.util.SuperEntidade;
import br.com.munif.bereja.negocio.Service;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Super Api para exemplo
 * @author munif
 */
public abstract class SuperApi<T extends SuperEntidade> extends HttpServlet {

    protected ObjectMapper mapper;

    protected SimpleDateFormat dateFormat;

    protected Service<T> service;

    protected String url;

    public abstract Class<T> getClazz();
    
    public SuperApi() {
        service = new Service<>(getClazz());
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        mapper.setDateFormat(dateFormat);
        //mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
    
    protected String[] getUrlParameters(HttpServletRequest request) {
        url = this.getServletContext().getContextPath() + this.getClass().getAnnotation(WebServlet.class).urlPatterns()[0].replace("/*", "").trim();
        String paramters = request.getRequestURI().replaceFirst(url, "");
        paramters = paramters.replaceFirst("/", "");
        if (paramters.isEmpty()) {
            return new String[0];
        }
        return paramters.split("/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String[] urlParameters = getUrlParameters(request);
        if (urlParameters.length == 0) {
            mapper.writeValue(response.getOutputStream(), service.lista());
        } else if (urlParameters.length == 1) {
            mapper.writeValue(response.getOutputStream(), service.recuperar(Long.parseLong(urlParameters[0])));
        } else {
            response.setStatus(400);
            mapper.writeValue(response.getOutputStream(), "Mais que um parâmetro no get");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String[] urlParameters = getUrlParameters(request);
        if (urlParameters.length == 1) {
            mapper.writeValue(response.getOutputStream(), service.recuperar(Long.parseLong(urlParameters[0])));
            service.excluir(Long.parseLong(urlParameters[0]));
        } else {
            response.setStatus(400);
            mapper.writeValue(response.getOutputStream(), "Número de parâmetros inválido");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String[] urlParameters = getUrlParameters(request);
        if (urlParameters.length == 1) {
            T doJson = mapper.readValue(request.getInputStream(), getClazz());
            T salva = service.salvar(doJson);
            mapper.writeValue(response.getOutputStream(), salva);
        } else {
            response.setStatus(400);
            mapper.writeValue(response.getOutputStream(), "Número de parâmetros inválido");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String[] urlParameters = getUrlParameters(request);
        if (urlParameters.length == 0) {
            T doJson = mapper.readValue(request.getInputStream(), getClazz());
            T salva = service.salvar(doJson);
            mapper.writeValue(response.getOutputStream(), salva);
        } else {
            response.setStatus(400);
            mapper.writeValue(response.getOutputStream(), "Número de parâmetros inválidos");
        }
    }

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String[] urlParameters = getUrlParameters(request);
        super.doHead(request, response);
    }

}
