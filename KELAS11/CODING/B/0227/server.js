const express = require("express")

const main = require("./routes/main.js")
const students = require("./routes/students.js")
const teachers = require("./routes/teachers.js")

const app = express()

// Middleware
app.use(express.json())

app.use("/", main)
app.use("/students", students)
app.use("/teachers", teachers)
app.use((_, response)=> response.status(404).send("Not Found!"))


const port = 3000
const host = "127.0.0.1"
app.listen(3000, () => {
    console.log(`Server is running on http://${host}:${port}`)
})