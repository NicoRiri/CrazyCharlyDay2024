import express from "express";
import {PostVoeuxAction} from "../actions/PostVoeuxAction.js";
import {GetVoeuxAction} from "../actions/GetVoeuxAction.js";

const router = express.Router();

router
    .route("/")
    .get((req, res, next) => {
        GetVoeuxAction(req, res, next)
    })
    .post((req, res, next) => {
        PostVoeuxAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed
export default router;