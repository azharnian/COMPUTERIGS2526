import { Router } from "express";

const students = Router()

// memperoleh semua data siswa
students.get("/", (_, res) => {
    res.json({
        "status" : "success",
        "students" : [
            "Andi", "Bob", "Cindy"
        ]
    })
})

// pencarian individu siswa
students.get("/search", (req, res) => {
    const { q } = req.query
    // Search in our table db
    res.status(404).json({
        "status" : "failed",
        "query" : q,
        "result" : "Not Found"
    })
})

// membuat akun siswa
students.post("/", (_, res) => {
    const student = {
        "name" : "Dody",
        "class" : 2026
    }
    res.status(201)
        .json({
            "status" : "success",
            "student" : student
        })
})

// menyapa siswa
students.get("/:name", (req, res) => {
    const { name } = req.params
    res.json({
        "status" : "success",
        "msg" : `Hi... ${name}`
    })
})


export default students