import express from 'express'
import router from './routes.js'

const app = express()
const port = 3000

app.use('', router)

app.listen(port, () => {
    console.log(`Apllication running at http://127.0.0.1:${port}`)
})