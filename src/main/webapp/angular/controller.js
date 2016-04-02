angular.module('app.example')
  .controller('Controller', function($scope, CervejariaFactory, $timeout){
  window.sessionStorage.setItem('token','104e3d210f22200');

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

  $scope.buscarDados()

})
