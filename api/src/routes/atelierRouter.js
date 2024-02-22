import express from "express";
import {GetAtelierAction} from "../actions/GetAtelierAction.js";
import {GetAtelierByIdAction} from "../actions/GetAtelierByIdAction.js";
import {GetAtelierByPageAction} from "../actions/GetAtelierByPageAction.js";
import {PostAtelierAction} from "../actions/PostAtelierAction.js";

const router = express.Router();

router
    .route("/")
    .get((req, res, next) => {
        GetAtelierAction(req, res, next)
    })
    .post((req, res, next) => {
        PostAtelierAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed

router
    .route("/page/:page")
    .get((req, res, next) => {
        GetAtelierByPageAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed

router
    .route("/:id")
    .get((req, res, next) => {
        GetAtelierByIdAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed

export default router;