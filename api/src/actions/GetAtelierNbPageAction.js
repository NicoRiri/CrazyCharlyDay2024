import SsAtelier from "../service/SsAtelier.js";

export async function GetAtelierNbPageAction(req,res,next){
    try {
        const atelier = await SsAtelier.getNbAtelier(req,res,next)
        console.log(atelier)
        res.json({data:atelier})
    }catch(e){
        console.error(e);
        next(500);
    }
}