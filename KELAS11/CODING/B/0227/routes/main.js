const { Router } = require("express")

const main = Router()

main.get("/", (_, response) => {
    response.send("Route / get")
})

main.post("/", (_, response) => {
    response.send("Route / post")
})

module.exports = main