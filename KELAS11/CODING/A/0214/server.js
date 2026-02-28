import express from "express"

import main from "./routes/main.js"
import students from "./routes/students.js"

const app = express()

// MIDDLEWARE
app.use(express.json())

app.use("/", main)
app.use("/students", students)

app.use((_, res) => res.status(404).json({"status" : "Not Found"}))

const port = 3000
const host = "127.0.0.1"
app.listen(port, () => {
    console.log(`App is running on http://${host}:${port}`)
})