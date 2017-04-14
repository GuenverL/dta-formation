import template from "./fighter.html"
import css from './fighter.css';
import md5 from 'md5';

class controller {

    $onInit() {
        this.md5 = md5(this.email)
        this.damages = 0;
    }

    fight() {
        this.onFight({
            $event: 5 + Math.floor(Math.random() * 5)
        })
    }

    suffer() {
        this.life = Math.max(this.life - this.damages, 0);
        this.afterInjured();
    }


}

export const FighterComponent = {
    bindings: {
        email: '<',
        onFight: '&',
        damages: '<',
        mode:'<',
        afterInjured: '&',
        life:'<'
    },
    template,
    controller,
}