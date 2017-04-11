import angular from 'angular'
import ngRoute from 'angular-route'
import {UsersModule} from './users'
import {AlertModule} from './alert'

angular.module("app",[
    UsersModule,
    AlertModule,
    ngRoute
])

.config(function ($locationProvider,$routeProvider) {
    $locationProvider.html5Mode(true)
    $routeProvider

        .when('/', {
            templateUrl: 'views/home.html',
            controller: 'Home',
            controllerAs:'ctrl',
        })
        .when('/users', {
            templateUrl: 'views/users.html',
            controller: 'UsersController',
            controllerAs:'uc',
        })
        .when('/user/:id?', {
            templateUrl: 'views/user.html',
            controller: 'UserController',
            controllerAs:'uc',
        })
        .when('/about/:name', {
            templateUrl: 'views/about.html',
            controller: 'About',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo:'/'
        })
})

.controller('Home', function () {
    this.name='Application'
})

.controller('About', function ($routeParams) {
    this.name=$routeParams.name
})
