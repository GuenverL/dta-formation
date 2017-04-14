import {uniq} from 'lodash'

let cacheRecipes;

export class RecipeService{

    getRecipes(){
        if(cacheRecipes)
            return Promise.resolve(cacheRecipes)

        return fetch('http://localhost:3000/recipes')
            .then(r=>r.json())
            .then(recipes=>{
                cacheRecipes=recipes
                return recipes
            })
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
}


