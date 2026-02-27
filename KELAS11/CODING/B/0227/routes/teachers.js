const {Router} = require("express")

const teachers = Router()

teachers.get("/", (_, res) => {
    res.json({
        "name" : "John",
        "age" : 32
    })
})

teachers.post("/", (_, res)=> {
    res.status(201)
        .json({
            "name" : "Jane",
            "age" : 31
        })
})

module.exports = teachers