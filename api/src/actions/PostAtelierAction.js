import SsAtelier from "../service/SsAtelier.js";

export async function PostAtelierAction(req,res,next){
    try {
        const atelier = await SsAtelier.postAtelier(req, res, next)
        res.json({message: "L'atelier a bien été créé"})
    }catch(e){
        console.error(e);
        next(500);
    }
}