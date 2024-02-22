import SsAtelier from "../service/SsAtelier.js";
import SsVoeux from "../service/SsVoeux.js";

export async function GetVoeuxAction(req,res,next){
    try {
        const voeux = await SsVoeux.getVoeux(req, res, next)
        console.log(voeux)
        res.json({data: voeux})
    }catch(e){
        console.error(e);
        next(500);
    }
}