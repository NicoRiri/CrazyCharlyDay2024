import SsAtelier from "../service/SsAtelier.js";
import SsVoeux from "../service/SsVoeux.js";

export async function PostVoeuxAction(req,res,next){
    try {
        const voeux = await SsVoeux.postVoeux(req, res, next)
        res.json({message: "les voeux ont été posté"})
    }catch(e){
        console.error(e);
        next(500);
    }
}