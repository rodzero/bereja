angular.module('app.example')
        .factory('CervejariaFactory', function ($http) {
            return {
                getCervejas: function () {
                    return $http
                            .get(location.origin + '/bereja/api/cervejaria')
                            .then(function (response) {
                                return response.data
                            })
                },
                save: function (obj) {
                    return $http
                            .post(location.origin + '/bereja/api/cervejaria', obj)
                },
                deletar: function (id) {
                    return $http
                            .delete(location.origin + '/bereja/api/cervejaria/'.concat(id))
                },
                update: function (cervejaria) {
                    return $http
                            .put(location.origin + '/bereja/api/cervejaria/'.concat(cervejaria.id), cervejaria)
                },
                logar: function (usuario,senha) {
                    var teste = {
                        usuario: usuario,
                        senha: senha
                    };
                    
                    var json = angular.toJson(teste);
                    return $http
                            .post(location.origin + '/bereja/api/token/', json)
                            .then(function (response) {
                                return response;
                            }, function (err) {
                                console.log(err);
                                return err;
                            });
                }
            }
        })
