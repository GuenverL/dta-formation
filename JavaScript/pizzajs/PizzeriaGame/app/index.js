import angular from 'angular'
import ngRoute from 'angular-route'
import md5 from 'md5'
import {PlayController} from './controllers/play.controller'
import {PlayService} from './services/play.service'
import {RecipesController} from './controllers/recipes.controller'
import {RecipesService} from './services/recipes.service'

angular.module("app",[
    ngRoute
])


.service('PlayService',PlayService)
.service('RecipesService',RecipesService)
.controller('RecipesController',RecipesController)
.controller('PlayController',PlayController)


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

.controller('ToppingsDirectiveController', function() {
    this.click = (topping) => {
        this.onSelect({
            $event: topping
        })
    }
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
                    <li class="list-group-item btn" ng-repeat="pizza in pdc.pizzas track by $index" ng-click="pdc.click(pizza)" ng-if="pizza.status!=='complete'">{{pizza.recipe}}</li>
            <p ng-transclude></p>`,

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

.directive("dtaToppings",function(){
    return{
        restrict:"E",
        template:`
                    <li class="list-group-item btn" ng-repeat="topping in tdc.toppings track by $index" ng-click="tdc.click(topping)">
                        {{topping}}
                    </li>
            `,

        controller:'ToppingsDirectiveController',
        controllerAs:'tdc',

        bindToController: {
            onSelect: '&',
            toppings:'='
        },
        scope: {}
    }
})