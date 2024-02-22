import express from "express";
import {PostVoeuxAction} from "../actions/PostVoeuxAction.js";

const router = express.Router();

router
    .route("/")
    .post((req, res, next) => {
        PostVoeuxAction(req, res, next)
    })
    .all((req, res, next) => next(405)); //method not allowed
export default router;