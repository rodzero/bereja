<%-- 
    Document   : detalhes
    Created on : 20/02/2016, 10:32:45
    Author     : munif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando Qualificacao</title>
    </head>
    <body style="font-family: sans-serif">
        <h1>Editando Qualificacao</h1>
        <form action="controlador" method="get">
            <input type="hidden" name="acao" value="salvar"/>
            <input type="hidden" name="id" value="${qualificacao.id}" /> 
            ID:${qualificacao.id}<br/>
            Data:<input type="date" name="dataQualificacao" value="<f:formatDate value="${qualificacao.quando}" />"/> <br/>
            Texto:<input type="text" name="texto" value="${qualificacao.texto}"/> <br/>
            Producao:           
            <select name="producao_id" size="10" >
                <c:forEach items="${producoes}" var="p">
                    <option value="${p.id}" ${qualificacao.producao.id==p.id?"selected":""}  >${p.receita.nome} <f:formatDate value="${p.quando}"/></option>
                </c:forEach>
            </select>
            <input type="submit"/>
            <a href="controlador">Cancelar</a>
        </form>
    </body>
</html>
