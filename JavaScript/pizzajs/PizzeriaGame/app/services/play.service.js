export class PlayService {

    constructor(RecipesService, $q) {
        this.pizzas = [];
        this.speed = 1000;
        this.score = 0;
        this.limit = 10;

        this.$q = $q;
        this.RecipesService = RecipesService;
    }

    start() {
        return new this.$q(resolve => this.speedUp(resolve));
    }

    sendPizza(pizza) {
        this.RecipesService.validRecipe(pizza).then(s=>pizza.status=s);
        if (pizza.status === 'complete') {
            this.removePizza(pizza);
            this.score++;
        }
    }

    removePizza(pizza) {
        const pizzaIndex = this.pizzas.findIndex(p => pizza === p);
        if (pizzaIndex !== -1) {
            this.pizzas.splice(pizzaIndex, 1);
        }
    }

    speedUp(resolve) {
        if (this.interval) clearInterval(this.interval);
        this.interval  = setInterval(this._getRandomPizza(resolve), 6000 - 5000*(1 - Math.exp(-this.score*.1)));
    }

    _getRandomPizza(resolve) {
        return function () {
            this.RecipesService
            .getRandomRecipe()
            .then(recipe => ({ recipe:recipe.name, toppings: [], status: 'incomplete' }))
            .then(pizza => this.pizzas.push(pizza))
            .then(() => {
                this.speedUp(resolve);
                if (this.pizzas.length > this.limit) {
                    clearInterval(this.interval);
                    resolve('PERDU');
                }
            })
        }.bind(this);
    }
}