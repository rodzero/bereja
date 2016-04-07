angular.module('app.example', [])
  .config(['$httpProvider', function($httpProvider){
      $httpProvider.interceptors.push(function ($q, $injector,$timeout) {
        return {
            'request': function (config) {
              config.headers['token'] = sessionStorage.getItem('token')
                return config;
            },
            'response': function (config) {
                return config;
            },
            'responseError': function (rejection) {
                return $q.reject(rejection);
            }
        };
      })
    }])
