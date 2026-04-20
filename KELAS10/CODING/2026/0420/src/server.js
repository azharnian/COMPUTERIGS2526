const express = require("express")

const app = express()

app.get("/", (_, res) => {
    res.send("Hello, Express...")
})

app.post("/", (_, res) => {
    res.send("Hello, Express... with POST Method!")
})

const port = 5000
const host = "127.0.0.1"

app.listen(port, host, () => {
    console.log(`Server is running on http://${host}:${port}.`)
})