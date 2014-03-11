'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ngRoute', 'ngCookies', 'ngSanitize']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/employee', {
        templateUrl: 'employee/page',
        controller: EmpCtrl
    });

    $routeProvider.otherwise({redirectTo: '/employee'});
}]);
