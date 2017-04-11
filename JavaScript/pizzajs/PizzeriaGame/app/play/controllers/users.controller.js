export class UsersController{

    constructor(UsersService){
        this.UsersService = UsersService
        this.UsersService.getUsers().then(us=>this.users=us)
    }

    deleteUser(user){
        this.UsersService.deleteUser(user).catch(() => {
            console.log('ERREUR DE SUPPRESSION');
            this.users.push(user);
        })

        this.users = this.users.filter(u => u.id !== user.id);
    }
}