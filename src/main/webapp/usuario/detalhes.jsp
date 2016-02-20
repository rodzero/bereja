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
        <title>Editando Usuario</title>
    </head>
    <body style="font-family: sans-serif">
        <h1>Editando Usuario</h1>
        <form action="controlador" method="get">
            <input type="hidden" name="acao" value="salvar"/>
            <input type="hidden" name="id" value="${usuario.id}" /> 
            ID:${usuario.id}<br/>
            Nome:<input type="text" name="nome" value="${usuario.nome}"/> <br/>
            eMail:<input type="text" name="email" value="${usuario.email}"/> <br/>
            Senha:<input type="password" name="senha" value="${usuario.senha}"/> <br/>
            <input type="submit"/>
            <a href="controlador">Cancelar</a>
        </form>
    </body>
</html>
