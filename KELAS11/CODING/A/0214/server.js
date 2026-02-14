import express from "express"
import routers from "./routes.js"

const app = express()

// MIDDLEWARE
app.use(express.json())

app.use("/", routers)

const port = 3000
const host = "127.0.0.1"
app.listen(port, () => {
    console.log(`App is running on http://${host}:${port}`)
})