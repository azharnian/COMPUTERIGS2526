import { Router } from "express"

const routers = Router()

routers.get("/", (_, response)=>{
    // response.send("<h1>This is get from / </h1>")
    response.json({
        "name" : "John",
        "age" : 30
    })
})
routers.post("/", (request, response)=>{
    // response.send("<h1>This is post from / </h1>")
    const newUser = {
        "name" : request.body.name,
        "email" : request.body.email
    }
    // ... implement insert into table in our db
    response.status(201).json(newUser)
})

routers.use((_, res) => res.status(404).json({"status" : "Not Found"}))

export default routers