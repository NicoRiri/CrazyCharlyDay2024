import SsAtelier from "../service/SsAtelier.js";
import SsVoeux from "../service/SsVoeux.js";

export async function PostResultatVoeuxAction(req,res,next){
    try {
        console.log("steak")
        const voeux = await SsVoeux.postVoeuxResultat(req, res, next)
        res.json({message: "les voeux ont été posté"})
    }catch(e){
        console.error(e);
        next(500);
    }
}