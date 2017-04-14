import  angular from 'angular';
import { FighterComponent } from './fighter.component';
import { TeamComponent } from './team.component';
import { ArenaComponent } from './arena.component';

angular.module('app', [])

.component('fighter', FighterComponent)
.component('team', TeamComponent)
.component('arena', ArenaComponent)

;