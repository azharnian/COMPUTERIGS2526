import { Router } from "express";
import notes from "../services/notes/routes/index.js";


const routers = Router();
routers.use("/", notes);

export default routers;