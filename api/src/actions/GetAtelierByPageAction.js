import SsAtelier from "../service/SsAtelier.js";

export async function getAtelierByPageAction(req,res,next){
    try {
        const atelier = await SsAtelier.getAtelierByPage(req,res,next)
        console.log(atelier)
        res.json({data:atelier})
    }catch(e){
        console.error(e);
        next(500);
    }
}