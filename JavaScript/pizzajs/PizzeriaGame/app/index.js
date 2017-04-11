import angular from 'angular'
import ngRoute from 'angular-route'
import {PlayModule} from './play'

angular.module("app",[
    PlayModule,
    ngRoute
])

.config(function ($locationProvider,$routeProvider) {
    $locationProvider.html5Mode(true)
    $routeProvider

        .when('/', {
            templateUrl: 'views/start.html'
        })
        .when('/play', {
            templateUrl: 'views/play.html',
            controllerAs:'pc',
        })
        .when('/recipe/:id', {
            templateUrl: 'views/recipe.html',
            controllerAs:'pc',
        })
        .otherwise({
            redirectTo:'/'
        })
})
