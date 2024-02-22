import knex from "knex";
import config from "../knex.js";

class SsVoeux {
    static db = knex(config.development);

    static async getUserFromAtelier(req, res, next) {
        try {
            const voeux =  await SsVoeux.db('voeux').where('atelier_id', req.params.id).select('candidat_id');

            const idArray = [];
            for (const voeu of voeux) {
                idArray.push(voeu.candidat_id);
            }


            return await SsVoeux.db('utilisateur').whereIn('id', idArray).select('*');

        } catch (err) {
            console.error(err);
            throw new Error("can't find user");
        }
    }
}

export default SsVoeux;
