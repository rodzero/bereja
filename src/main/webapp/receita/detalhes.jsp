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
        <title>Editando teste</title>
    </head>
    <body style="font-family: sans-serif">
        <h1>Editando Receitas</h1>
        <form action="controlador" method="get">
            <input type="hidden" name="acao" value="salvar"/>
            <input type="hidden" name="id" value="${receita.id}" /> 
            ID:${receita.id}<br/>
            Nome:<input type="text" name="nome" value="${receita.nome}"/> <br/>
            Quantidade:<input type="number"  placeholder="Ponha numeroooooooo :) " name="quantidade" value="${receita.quantidade}"/> <br/>
            Descrição:<input type="text" name="receita" title="Ponha numero"
                            value="${receita.receita}"/> <br/>
            <input type="submit"/>
            <a href="controlador">Cancelar</a>
        </form>
    </body>
</html>
