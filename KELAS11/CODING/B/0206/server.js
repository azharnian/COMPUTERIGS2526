import http from "http"

const requestListener = (request, response) => {
    response.setHeader("Content-Type", "text/html")
    response.statusCode = 200

    const { method, url } = request

    if (url === "/"){

        if (method === "GET"){
            response.end(`
                <h1>Hello, REST API from nodeJs</h1>
                `)
        } else if (method === "POST"){

            let body = []
            request.on("data", (chunk)=>{
                body.push(chunk)
            })
            request.on("end", ()=>{
                try {
                    body = Buffer.concat(body).toString()
                    const {name} = JSON.parse(body)

                    response.statusCode = 201
                    response.end(`<h1>This is POST Method, Hi ${name}!</h1>`)
                } catch (error) {
                    response.statusCode = 400
                    response.end(`<h1>Bad Request</h1>`)
                }
            })

        } else if (method === "PATCH"){
            response.end("<h1>This is PATCH Method</h1>")
        } else if (method === "PUT"){
            response.end("<h1>This is PUT Method</h1>")
        } else if (method === "DELETE"){
            response.setHeader("Content-Type", "application/json")
            const data = {
                "status" : true,
                "msg" : "Data has been deleted."
            }
            response.end(JSON.stringify(data))
        }
    } else if (url === "/books"){

    } else if (url === "/users"){

    } else {
        response.statusCode = 404
        response.end("<h1>Not Found!</h1>")
    }

    
   
}

const server = http.createServer(requestListener)

const port = 5000
const host = "127.0.0.1"

server.listen(port, host, ()=>{
    console.log(`Server is running on http://${host}:${port}`)
})