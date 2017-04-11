export class UserController {

    constructor(UsersService, AlertService, $routeParams, $location) {
        this.UsersService = UsersService;
        this.$location=$location
        this.UsersService.getUserById($routeParams.id).then(user => this.user = user);
        this.AlertService = AlertService
    }

    save(userForm) {
        if (userForm.$valid) {
            this.UsersService.saveUser(this.user)
                .then(() => this.AlertService.addSuccess('SAVED'))
                .then(()=>this.$location.path('/users'))
                .catch(()=>this.AlertService.addError('ERROR'))
        }
    }

}