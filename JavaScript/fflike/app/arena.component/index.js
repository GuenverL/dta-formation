import template from "./arena.html"
import css from './arena.css'


class controller {
    constructor($timeout) {
        this.$timeout = $timeout;
    }

    $onInit(){
        this.life=30
        this.teams=[
            {
                name:'JAVA',
                mode:'attack',
                fighters:[
                    {life:this.life,email:'loicguen@hotmail.fr'},
                    {life:this.life,email:'renard.cyrille@gmail.com'},
                    {life:this.life,email:'paolalambroni@gmail.com'},
                    {life:this.life,email:'dark.pl@hotmail.fr'},
                    {life:this.life,email:'charlery.christopher@gmail.com'}
                ]
            },
            {
                life:this.life,
                name:'JAVASCRIPT',
                mode:'defense',
                fighters:[
                    {life:this.life,email:'alouest_44@yahoo.fr'},
                    {life:this.life,email:'lehardy.david@live.fr'},
                    {life:this.life,email:'lionel.collidor2016@campus-eni.fr'},
                    {life:this.life,email:'pouletguerrier@gmail.com'},
                    {life:this.life,email:'gigarelt@gmail.com'}

                ]
            }
        ]
    }

    setDamages(damages) {
        this.damages = damages
    }

    attackEnd() {
        this.damages = 0
        // @TODO refacto
        this.teams[0].mode = this.teams[0].mode === 'defense' ? 'attack' : 'defense'
        this.teams[1].mode = this.teams[1].mode === 'defense' ? 'attack' : 'defense'
    }
}

export const ArenaComponent = {
    bindings: {
        fighters:'&',
    },
    template,
    controller,
}