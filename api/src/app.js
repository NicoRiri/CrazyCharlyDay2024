import express from "express";
import catch404errors from "./middlewares/catch404errors.js";
import catchAllErrors from "./middlewares/catchAllErrors.js";
import atelierRouter from "./routes/atelierRouter.js";
import voeuxRouter from "./routes/voeuxRouter.js";

const app = express();


app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use("/atelier", atelierRouter)
app.use("/voeux", voeuxRouter)

app.use(catch404errors)
app.use(catchAllErrors)

export default app;