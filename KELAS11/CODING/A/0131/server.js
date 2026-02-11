import http from 'http'

const requestListener = (request, response) => {

    response.setHeader("Content-Type", "text/html")
    
    const { method, url } = request

    if (url === "/"){

        if (method === "GET"){
            response.statusCode = 200
            response.end(
                "<h1>Get Method Response</h1>"
            )
        }

        if (method === "POST"){
            response.statusCode = 201
            let body = []

            request.on("data", (chunk)=>{
                body.push(chunk)
            })

            request.on("end", () => {
                body = Buffer.concat(body).toString()
                const { name } = JSON.parse(body)
                response.end(
                    `<h1>This is POST Method, and Hi ${name}...</h1>`
                )
            })
        }

        if (method === "PUT"){
            response.statusCode = 200
            response.end(
                "<h1>Put Method Response</h1>"
            )
        }

        if (method === "PATCH"){
            response.statusCode = 200
            response.end(
                "<h1>Patch Method Response</h1>"
            )
        }

        if (method === "DELETE"){
            response.statusCode = 200
            response.end(
                "<h1>Delete Method Response</h1>"
            )
        }


    } else if (url === "/about"){
        if (method === "GET") {
            response.statusCode = 200
            response.end(`
                <h1>GET dari route about</h1>
                `)
        } else if (method === "POST"){
            response.statusCode = 201
            let body = []

            request.on("data", (chunk) => {
                body.push(chunk)
            })

            request.on("end", () => {
                body = Buffer.concat(body).toString()
                const { info } = JSON.parse(body)
                response.end(`
                    Your info in about route is ${info}
                    `)
            })
        } else {
            response.statusCode = 400
            response.end(`
                Invalid end-point and route.
                `)
        }
    } else if (url === "/contact"){
        // Latihan : buat 5 verb + status code response
    } else {
        response.statusCode = 404
        response.setHeader("Content-Type", "applicaiton/json")
        response.end(JSON.stringify({"code" : 404, "message" : "Not Found"}))
    }

}

const server = http.createServer(requestListener);

const port = 5000
const host = "127.0.0.1"
server.listen(port, host, () => {
    console.log(`I'm listening on http://${host}:${port}`)
})