angular.module('app.example')
  .controller('Controller', function($scope, CervejariaFactory, $timeout){
  $scope.token = window.sessionStorage.getItem('token');
  
  $scope.login = '';
  $scope.senha = '';

  $scope.editarCervejaria = function(cervejaria){
    $scope.cervejaria = angular.copy(cervejaria);
  }

  $scope.apagarCervejaria = function(id){
    CervejariaFactory
      .deletar(id)
      .then(function(){
        $scope.buscarDados()
      })
  }
  $scope.saveOrUpdate = function(cervejaria){
    if(cervejaria.id){
      CervejariaFactory
        .update(cervejaria)
        .then(function(){
          $scope.buscarDados()
          $scope.cervejaria = {}
        })
    } else {
      CervejariaFactory
        .save(cervejaria)
        .then(
          function(response){
          $scope.buscarDados()
          $scope.cervejaria = {}
        }, function(err){

        })
    }
  }

  $scope.buscarDados = function(){
    CervejariaFactory
      .getCervejas()
      .then(function(response){
        $scope.cervejarias = response        
      })
  }  
  
  $scope.buscaToken = function(login,senha){
      console.log('busca');
      CervejariaFactory
              .logar(login, senha)
              .then(function (response) {
                  console.log(response);
                  if(response !== 'Não autorizado') {
                    $scope.token = response;
                    window.sessionStorage.setItem('token',$scope.token);
                    console.log($scope.token);
                    $scope.buscarDados();  
                  }                                  
            });
  }

  $scope.buscarDados();  
  

})
