export class PlayController {

    constructor(RecipesService,PlayService) {
        this.RecipesService = RecipesService
        this.PlayService = PlayService
        this.RecipesService.getToppings().then(t=>{this.toppings=t})
        this.pizzas = PlayService.pizzas;
        PlayService.start()
    }

    selectPizza (pizza) {
        this.pizza = pizza;
    }

    viderPizza(){
        this.pizza=null
    }

    addTopping(topping){
        if(this.pizza){
            this.pizza.toppings.push(topping)
            this.PlayService.sendPizza(this.pizza)
        }
    }
}