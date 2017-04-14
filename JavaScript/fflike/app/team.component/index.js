import template from "./team.html"
import css from './team.css'

class controller{

    setDamages(damages) {
        this.onFight({
            $event: damages
        });
    }
    attackEnd(){
        this.afterInjured();
    }

}

export const TeamComponent = {
    bindings: {
        name:'<',
        mode:'<',
        fighters:'<',
        onFight: '&',
        afterInjured: '&',
        damages:'<'

    },
    template,
    controller
}