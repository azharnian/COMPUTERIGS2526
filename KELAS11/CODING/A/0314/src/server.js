const express = require("express");
const cors = require("cors");

const routes = require("./routes/routes.js");

const app = express();

const port = 8000;
const host = "127.0.0.1";

app.use(cors({
	origin: "*"
}));

app.use(express.json());
app.use("/", routes);

app.listen(port, ()=>{
	console.log(`App is running on http://${host}:${port}`);
});