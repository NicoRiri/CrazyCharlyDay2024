import SsAtelier from "../service/SsAtelier.js";

export async function PostAtelierAction(req,res,next){
    try {
        const atelier = await SsAtelier.postAtelier(req, res, next)
        console.log(atelier)
        res.json({data:atelier})
    }catch(e){
        console.error(e);
        next(500);
    }
}