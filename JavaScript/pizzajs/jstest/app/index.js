import {RecipeService} from './recipes'
import {PizzeriaService} from './pizzeria'
import {PizzaService} from './pizzas'

let recipeService = new RecipeService;
let pizzeriaService = new PizzeriaService;
let pizzaService = new PizzaService;


let domComList = document.getElementById('commandList')
let domTopList = document.getElementById('toppingList')
let domPizza = document.getElementById('pizza')

recipeService.getToppings().then(ts=>ts.forEach(t=>domAddTopping(t)))

function domAddTopping(t){

    let domBtn=domTopList.appendChild(document.createElement('button'))
    domBtn.innerHTML=t
    domBtn.setAttribute('type','button')
    domBtn.setAttribute('class','list-group-item')

}

function domAddPizza(p){
    if(document.getElementById('pizzaPan'))
        domPizza.removeChild(document.getElementById('pizzaPan'))

    let domPan = domPizza.appendChild(document.createElement('div'))
    domPan.setAttribute('class','panel panel-info')
    domPan.setAttribute('id','pizzaPan')
    domPan.setAttribute('id-pizza',p.id)

    let domPanH = domPan.appendChild(document.createElement('div'))
    domPanH.setAttribute('class','panel-heading')
    domPanH.innerHTML = p.recipe

    let domPanB = domPan.appendChild(document.createElement('div'))
    domPanB.setAttribute('class','panel-body')
    domPanB.setAttribute('id','pizzaBody')
    domPanB.innerHTML = p.toppings

}

function domAddCommand(p){
    let domBtn=domComList.appendChild(document.createElement('button'))
    domBtn.innerHTML=p.recipe
    domBtn.setAttribute('type','button')
    domBtn.setAttribute('class','list-group-item')
    domBtn.setAttribute('data-pizza',p.id)

    let span = domBtn.appendChild(document.createElement('span'))
    span.setAttribute('class','badge')
    span.innerHTML=0
}



function domAddPizzaTopping(t){
    let domPanB=document.getElementById('pizzaBody')
    let domLi=domPanB.appendChild(document.createElement('li'))
    domLi.innerHTML=t
    domLi.setAttribute('class','list-group-item')
}

domComList.addEventListener('click',eventComList,false)

function eventComList(event){
    if(event.target&&event.target.nodeName==='BUTTON'){
        pizzaService.getPizza(event.target.getAttribute('data-pizza')).then(pizza=>
            domAddPizza(pizza)
        )
    }
}

domTopList.addEventListener('click',(event)=>{
    if(event.target&&event.target.nodeName==='BUTTON'){
        pizzaService.addTopping( document.getElementById('pizzaPan').getAttribute('id-pizza'),event.target.innerText)
            .then(pizza=>{
                domAddPizzaTopping(event.target.innerText)
                pizzaService.getStatus(pizza.id)
                    .then(status=>{
                        switch(status){
                            case 'complete':
                                removeDomCom(pizza.id)
                                break;
                            case 'wrong':
                                domWrongCom(pizza.id)
                                break;
                        }
                    })
            })
    }
})

pizzaService.deletePizzas().then(console.log("vide"))

pizzeriaService.open(p=>
    domAddCommand(p)
)


function removeDomCom(id){
    domComList.querySelector(`[data-pizza="${id}"]`).remove()
}

function domBadgeInc(id){
    let badge = domComList.querySelector(`[data-pizza="${id}"]`).querySelector('span')
    badge.innerHTML++
}

function domWrongCom(id){
    let domBtn = domComList.querySelector(`[data-pizza="${id}"]`)
    domBtn.setAttribute('class','list-group-item list-group-item-danger disabled')
    domBtn.setAttribute('clickable','nope')
 }

