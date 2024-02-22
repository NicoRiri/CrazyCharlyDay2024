import express from "express";
import {getAtelierAction} from "../actions/GetAtelierAction.js";

const router = express.Router();

router
    .route("/")
    .get((req, res, next) => {
        getAtelierAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed
export default router;