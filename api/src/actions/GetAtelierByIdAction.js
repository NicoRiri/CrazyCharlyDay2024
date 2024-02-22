import SsAtelier from "../service/SsAtelier.js";
import SsUtilisateur from "../service/SsUtilisateur.js";

export async function getAtelierByIdAction(req,res,next){
    try {
        const atelier = await SsAtelier.getAtelierById(req, res, next)
        const user = await SsUtilisateur.getUserFromAtelier(req, res, next)
        console.log(atelier)
        console.log(user)

        res.json({data:{atelier, user}})
    }catch(e){
        console.error(e);
        next(500);
    }
}