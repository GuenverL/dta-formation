import {RecipeService} from './recipes'
import {PizzaService} from './pizzas'

let recipeService = new RecipeService;
let pizzaService = new PizzaService;

export class PizzeriaService{
  constructor() {
    this.pizzaCounter = 0;
  }

    open(cb) {
        this.speed = 10000;
        this.start(cb)
    }

  start(cb) {
    this.x = () => {
        recipeService
            .getRandomRecipe()
            .then(recipe => ({ recipe: recipe.name, toppings: [] }))
            .then(pizza => pizzaService.addPizza(pizza))
            .then(pizza => {
            this.pizzaCounter++;
            if (this.pizzaCounter > 10) {
              clearInterval(this.interval);
              alert('PERDU');
              return false;
            }
            this.speedUp();
            return pizza;
          })
          .then(cb);
      }

    this.interval = setInterval(this.x, this.speed);
  }

  completeOne() {
    this.pizzaCounter--;
  }

  speedUp() {
    clearInterval(this.interval);
    this.speed = this.speed * 0.9;
    this.interval = setInterval(this.x, this.speed);
  }

}