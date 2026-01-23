type User = {
    name : string,
    age : number
}

function createUser(user : User) : boolean {
    console.log(user.name, user.age)
    return true
}

interface User2  {
    name : string
    age : number
}

interface Admin extends User2 {
    isAdmin : boolean
}

const createAdmin = (admin : Admin) : boolean => {
    return true
}

createUser({name : "john", age : 10})
createAdmin({name : "jane", age : 20, isAdmin : true})