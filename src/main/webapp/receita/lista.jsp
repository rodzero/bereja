<%-- 
    Document   : lista
    Created on : 20/02/2016, 08:57:31
    Author     : munif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Receita</title>
    </head>
    <body style="font-family: sans-serif">
        <h1>Cadastro de Receita</h1>
        <a href="controlador?acao=criar">Novo</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Receita</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${receita}" var="receita">
                    <tr>
                        <td>${receita.nome}</td>
                        <td>${receita.quantidade}</td>
                        <td>${receita.receita}</td>
                        <td>
                            <a href="controlador?acao=excluir&id=${receita.id}">Excluir</a>
                            <a href="controlador?acao=alterar&id=${receita.id}">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>





    </body>
</html>
