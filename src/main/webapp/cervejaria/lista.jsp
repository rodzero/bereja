<%-- 
    Document   : lista
    Created on : 20/02/2016, 14:27:22
    Author     : rodolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Cervejarias</title>
    </head>
    <body>
        <h1>Lista de Cervejarias</h1>
        
        <a href="controlador?acao=criar">Novo</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cervejarias}" var="cervejaria">
                    <tr>
                        <td>${cervejaria.nome}</td>
                        <td>
                            <a href="controlador?acao=excluir&id=${cervejaria.id}">Excluir</a>
                            <a href="controlador?acao=alterar&id=${cervejaria.id}">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
