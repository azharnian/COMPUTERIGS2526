import express from 'express'

const router = express.Router()

router.get("/", (request, response)=>{
    const data = {
        "status" : true,
        "msg" : "Data from GET /"
    }
    response.send(JSON.stringify(data))
})

router.get("/about", (request, response)=>{
    response.send("About GET Response")
})

export default router