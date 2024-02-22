import SsAtelier from "../service/SsAtelier.js";

export async function PostVoeuxAction(req,res,next){
    try {
        const atelier = await SsAtelier.getAtelier()
        console.log(atelier)
        res.json({data:atelier})
    }catch(e){
        console.error(e);
        next(500);
    }
}