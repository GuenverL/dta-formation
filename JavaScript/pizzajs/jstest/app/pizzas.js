import {RecipeService} from './recipes'
const URL ='http://localhost:3000/pizzas'
let headers = new Headers()
headers.set('Content-Type','application/JSON')

let recipeService = new RecipeService;

export class PizzaService{
    addPizza(pizza){
        return fetch(URL,{
            method:'POST',
            headers,
            body:JSON.stringify(pizza)
        })
        .then(r=>r.json())
    }

    savePizza(pizza){
        return fetch(`${URL}/${pizza.id}`,{
            method:'PUT',
            headers,
            body:JSON.stringify(pizza)
        })
        .then(r=>r.json())
    }

    getPizzas(){
        return fetch(URL)
            .then(r=>r.json())
    }

    getPizza(id){
        return fetch(`${URL}/${id}`)
            .then(r=>r.json())
    }

    deletePizza(id){
        return fetch(`${URL}/${id}`,{
            method:'DELETE',
        })
        .then(r=>r.json())
    }

    deletePizzas(){
        return this.getPizzas().then(ps=>
                Promise.all(ps.map(({id})=> this.deletePizza(id))))
    }

    addTopping(id,t){
        return this.getPizza(id).then(p=>{
            p.toppings.push(t)
            return this.savePizza(p)
        })
    }

    getStatus(id){
        return this.getPizza(id).then(pizza=>{
            return recipeService.findRecipe(pizza.recipe).then(recipe=>{
                let result = recipe.toppings.reduce((acc, top) => {
                    let first = pizza.toppings.indexOf(top)
                    let last = pizza.toppings.lastIndexOf(top)
                    if (first !== -1 && first === last) acc.ok++
                    else acc.ko++;
                    return acc;
                }, { ok: 0, ko: 0 })
                if (result.ok < pizza.toppings.length) return 'wrong'
                else if (result.ko > 0) return 'incomplete'
                else return 'complete'
           })
        })
    }
}
