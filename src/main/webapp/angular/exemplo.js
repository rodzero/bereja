var programa = angular.module("exemplo", []);

programa.controller('controlador'
    , ['$scope', '$http', function ($scope, $http) {
        $scope.msg = 'Carregando';
        $scope.filtro = '';
        $scope.lista = [];

        $http.get(location.origin+ '/bereja/api/cervejaria')
            .success(
                function (resultado) {
                    console.log(resultado);
                    $scope.msg = resultado.length + " cervejarias encontradas";
                    $scope.lista = resultado;
                })
            .error(function (data, status) {
                $scope.msg = "Não foi possível carregar as cervejarias";
            })
}]);