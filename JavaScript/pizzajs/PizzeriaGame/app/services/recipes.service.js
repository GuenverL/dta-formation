import {uniq} from 'lodash'

let cacheRecipes;

export class RecipesService{

    constructor($http,$q){
        this.$http = $http
        this.$q=$q
    }

    getRecipes(){
        if(cacheRecipes)
            return this.$q.resolve(cacheRecipes)

        return this.$http.get('http://localhost:3000/recipes')
            .then(r=>r.data)
            .then(d=>this.cacheRecipes=d)
    }

    _extractToppings(recipes){
        return uniq(recipes.reduce((acc,item)=>
            [...acc,...item.toppings]
        ,[]))
    }

    getToppings(){
        return this.getRecipes().then(this._extractToppings)
    }

    getRandomRecipe(){
        return this.getRecipes().then(r=>r[   Math.floor(Math.random()*r.length)  ])
    }

    findRecipe(name){
        return this.getRecipes()
            .then(rs=>
                rs.find(r=>
                    r.name===name
                )
            )
    }

    validRecipe(pizza) {
        return this.findRecipe(pizza.recipe).then(recipe=>{
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
    }
}


