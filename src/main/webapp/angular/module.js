angular.module('app.example', [])
  .config(['$httpProvider', function($httpProvider){
      $httpProvider.interceptors.push(function ($q, $injector,$timeout) {
        return {
            'request': function (config) {
              config.headers['token'] = window.localStorage.getItem('token')
                return config;
            },
            'response': function (config) {
                return config;
            },
            'responseError': function (rejection) {
                window.localStorage.removeItem('token');
                return $q.reject(rejection);
            }
        };
      })
    }])
