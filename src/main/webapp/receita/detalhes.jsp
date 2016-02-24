<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div class="panel-heading"><h3 style="text-align: center">Cadastro de Receitas</h3></div>
                    <div class="panel-body">
                <form action="controlador" method="get">
                    <div class="form-group">
                        <input type="hidden" name="acao" value="salvar"/>
                        <input type="hidden" name="id" value="${receita.id}" />
                        <label>ID: </label> ${receita.id}<br/><br/>
                        <label for="nome">Nome:</label>
                        <input class="form-control" id="nome" type="text" name="nome" value="${receita.nome}" placeholder="Digite o nome"/> <br/>
                        <label for="quantidade">Quantidade:</label>
                        <input id="quantidade" class="form-control" type="number"  placeholder="Digite a quantidade" name="quantidade" value="${receita.quantidade}"/> <br/>
                        <label for="descricao">Descrição:</label>
                        <input id="descricao" class="form-control" type="text" name="receita" placeholder="Digite a descrição"
                                value="${receita.receita}"/> <br/>
                        <input type="submit" class="btn btn-success" name="Confirmar" title="Confirmar"/>
                        <a class="btn btn-danger" href="controlador" >Cancelar</a>
                    </div>
                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
