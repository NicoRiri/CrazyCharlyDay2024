import express from "express";
import {PostVoeuxAction} from "../actions/PostVoeuxAction.js";
import {GetVoeuxAction} from "../actions/GetVoeuxAction.js";
import {GetVoeuxByIdAction} from "../actions/GetVoeuxByIdAction.js";
import {PostResultatVoeuxAction} from "../actions/PostResultatVoeuxAction.js";

const router = express.Router();

router
    .route("/resultat")
    .get((req, res, next) => {
        GetResultatVoeuxAction(req, res, next)
    })
    .post((req, res, next) => {
        PostResultatVoeuxAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed
router
    .route("/")
    .get((req, res, next) => {
        GetVoeuxAction(req, res, next)
    })
    .post((req, res, next) => {
        PostVoeuxAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed

router
    .route("/:id")
    .get((req, res, next) => {
        GetVoeuxByIdAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed


export default router;