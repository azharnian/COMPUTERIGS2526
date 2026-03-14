const express = require("express")

const app = express()

const port = 8000
const host = "127.0.0.1"

app.get("/", (_, res)=>{
    res.send("Hello, from docker4!")
})

app.listen(port, ()=>{
    console.log(`App is running on http://${host}:${port}`)
})