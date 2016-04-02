angular.module('app.example')
.factory('CervejariaFactory', function($http){
  return {
    getCervejas: function(){
      return $http
              .get('http://localhost:8084/bereja/api/cervejaria')
              .then(function(response){
                return response.data
              })
    },
    save: function(obj){
      return $http
              .post('http://localhost:8084/bereja/api/cervejaria', obj)
    },
    deletar: function(id){
      return $http
              .delete('http://localhost:8084/bereja/api/cervejaria/'.concat(id))
    },
    update: function(cervejaria){
      return $http
              .put('http://localhost:8084/bereja/api/cervejaria/'.concat(cervejaria.id), cervejaria)
    }
  }
})
