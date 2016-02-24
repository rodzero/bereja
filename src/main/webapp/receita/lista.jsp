<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="../resource/bootstrap-3.3.6-dist/css/sidebar.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista Receita</title>
</head>
<body style="font-family: sans-serif">
    <div id="wrapper">
        <jsp:include page="../menu.jsp"></jsp:include>

        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h3 style="text-align: center">Receitas</h3></div>
                            <table border="1" class="table">
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
                                                <span class="label label-danger" style="margin-right: 5px;">
                                                    <a href="controlador?acao=excluir&id=${receita.id}" style="color: white;">Excluir</a>
                                                </span>
                                                <span class="label label-warning">
                                                    <a href="controlador?acao=alterar&id=${receita.id}" style="color: white">Alterar</a>
                                                </span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <a href="controlador?acao=criar" style="color: white" class="btn btn-success">Adicionar</a>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
