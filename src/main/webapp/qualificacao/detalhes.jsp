<%-- 
    Document   : detalhes
    Created on : 20/02/2016, 10:32:45
    Author     : munif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            Data:<input type="date" name="dataQualificacao" value="${qualificacao.quando}"/> <br/>
            Texto:<input type="text" name="texto" value="${qualificacao.texto}"/> <br/>
           
            <input type="submit"/>
            <a href="controlador">Cancelar</a>
        </form>
    </body>
</html>
