import angular from 'angular'
import {PlayController} from './controllers/play.controller'

export const PlayModule = angular.module("play.module",[])

.value('API_URL','http://localhost:3000/users')
.controller("PlayController",PlayController)
.name