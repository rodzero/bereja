<%-- 
    Document   : detalhe
    Created on : 20/02/2016, 14:27:31
    Author     : rodolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando Cervejaria</title>
    </head>
    <body>
        <h1>Editando Cervejaria</h1>
        <form action="controlador" method="get">
            <input type="hidden" name="acao" value="salvar"/>
            <input type="hidden" name="id" value="${cervejaria.id}" /> 
            ID:${cervejaria.id}<br/>
            Nome:<input type="text" name="nome" value="${cervejaria.nome}"/> <br/>
            <input type="submit"/>
            <a href="controlador">Cancelar</a>
        </form>
    </body>
</html>
