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
        <title>Editando Produção</title>
    </head>
    <body style="font-family: sans-serif">
        <h1>Editando Produção</h1>
        <form action="controlador" method="get">
            <input type="hidden" name="acao" value="salvar"/>
            <input type="hidden" name="id" value="${producao.id}" /> 
            ID:${producao.id}<br/>
            Receita:<br/>
            Data:<input type="text" name="quandoX" value="${producao.quando}"/> <br/>
            Quantidade:<input type="text" name="quantidade" value="${producao.quantidade}"/> <br/>
            Historico:<br/>
            <textarea name="historico" rows="10" cols="40">${producao.historico}</textarea>
            <input type="submit"/>
            <a href="controlador">Cancelar</a>
        </form>
    </body>
</html>
