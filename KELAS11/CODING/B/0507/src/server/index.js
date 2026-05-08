import express from "express"
import cors from "cors"

import routes from "../routes/index.js";
import ErrorHandler from '../middlewares/errors.js'; 

const app = express();

app.use(cors("http://localhost:8080/"));
app.use(express.json());
app.use(routes);
app.use(ErrorHandler);

export default app;