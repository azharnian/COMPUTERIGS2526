const express = require("express")

const app = express()

app.get("/", (_, res)=>{
    res.send("Hello, express from docker!!")
})

const port = 3000
const host = "127.0.0.1"
app.listen(port, () => {
    console.log(`Server is running on http://${host}:${port}`)
})