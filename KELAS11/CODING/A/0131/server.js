import http from 'http'

const requestListener = (request, response) => {

    response.statusCode = 200
    response.setHeader("Content-Type", "text/html")
    
    const { method } = request
    if (method === "GET"){
        response.end(
            "<h1>Get Method Response</h1>"
        )
    }

    if (method === "POST"){
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
        response.end(
            "<h1>Put Method Response</h1>"
        )
    }

    if (method === "PATCH"){
        response.end(
            "<h1>Patch Method Response</h1>"
        )
    }

    if (method === "DELETE"){
        response.end(
            "<h1>Delete Method Response</h1>"
        )
    }


}

const server = http.createServer(requestListener);

const port = 5000
const host = "127.0.0.1"
server.listen(port, host, () => {
    console.log(`I'm listening on http://${host}:${port}`)
})