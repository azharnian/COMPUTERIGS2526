import { Router } from "express";

const main = Router()

main.get("/", (_, response)=>{
    response.json({
        "name" : "John",
        "age" : 30
    })
})
main.post("/", (request, response)=>{
   const newUser = {
        "name" : request.body.name,
        "email" : request.body.email
    }
    // ... implement insert into table in our db
    response.status(201).json(newUser)
})

export default main