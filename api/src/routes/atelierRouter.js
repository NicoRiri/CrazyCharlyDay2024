import express from "express";
import {getAtelierAction} from "../actions/GetAtelierAction.js";
import {getAtelierByIdAction} from "../actions/GetAtelierByIdAction.js";

const router = express.Router();

router
    .route("/")
    .get((req, res, next) => {
        getAtelierAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed

router
    .route("/:id")
    .get((req, res, next) => {
        getAtelierByIdAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed

export default router;