const {Router} = require("express")

const students = Router()

students.get("/", (_, response)=>{
    response.send("Route /students get")
})

students.post("/", (_, response)=>{
    response.send("Route /students post")
})

module.exports = students