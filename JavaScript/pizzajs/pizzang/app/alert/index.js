import angular from 'angular';

export const AlertModule = angular.module('alert.module', [])

.service('AlertService', class AlertService {
    constructor($timeout) {
        this.alert = {
            succMessage: '',
            errMessage: ''
        }
        this.$timeout = $timeout;
    }
    addSuccess(message) {
        this.alert.succMessage = message;
        this.$timeout(3000).then(() => this.alert.succMessage = '');
    }
    addError(message) {
        this.alert.errMessage = message;
        this.$timeout(3000).then(() => this.alert.errMessage = '');
    }
})
.controller('AlertController', class AlertController {
    constructor(AlertService) {
        this.alert = AlertService.alert;
    }
})

.name;