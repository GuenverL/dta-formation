import angular from 'angular'
import ngRoute from 'angular-route'
import md5 from 'md5'
import {PlayController} from './controllers/play.controller'
import {PlayService} from './services/play.service'
import {RecipesController} from './controllers/recipes.controller'
import {RecipesService} from './services/recipes.service'
import {dtaToppings} from './pizzas.component'

angular.module("app",[
    ngRoute
])


.service('PlayService',PlayService)
.service('RecipesService',RecipesService)
.controller('RecipesController',RecipesController)
.controller('PlayController',PlayController)
.component('dtaToppings',dtaToppings)


.config(function ($locationProvider,$routeProvider) {
    $locationProvider.html5Mode(true)
    $routeProvider

        .when('/', {
            templateUrl: 'views/start.html'
        })
        .when('/play', {
            templateUrl: 'views/play.html',
            controller:'PlayController',
            controllerAs:'pc',
        })
        .when('/recipe/:id', {
            templateUrl: 'views/recipe.html',
            controllerAs:'rc',
        })
        .otherwise({
            redirectTo:'/'
        })
})

.controller('PizzasDirectiveController', function() {
    this.click = (pizza) => {
        this.onSelect({
            $event: pizza
        })
    }
})


.directive("dtaPizzas",function(){
    return{
        restrict:"E",
        template:`
                    <button type="button" class="list-group-item" ng-class="{'list-group-item-danger disabled':pizza.status==='wrong'}" ng-repeat="pizza in pdc.pizzas track by $index" ng-click="pdc.click(pizza)" ng-if="pizza.status!=='complete'">{{pizza.recipe}}</button>
           `,

        controller:'PizzasDirectiveController',
        controllerAs:'pdc',

        bindToController: {
            onSelect: '&',
            pizzas:'='
        },
        scope: {},
        transclude:true
    }
})

