import http from "http"

const requestListener = (resquest, response) => {
    response.setHeader("Content-Type", "text/html")
    response.statusCode = 200
    response.end(`
        <h1>Hello, REST API from nodeJs</h1>
        `)
}

const server = http.createServer(requestListener)

const port = 5000
const host = "127.0.0.1"

server.listen(port, host, ()=>{
    console.log(`Server is running on http://${host}:${port}`)
})