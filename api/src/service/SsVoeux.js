import knex from "knex";
import config from "../knex.js";

class SsVoeux {
    static db = knex(config.development);

    static async postVoeux(req, res, next) {
        try {
            const user = await SsVoeux.db('utilisateur').insert({nom: req.body.nom, email: req.body.email, admin : 0})
            const iteration = req.body.voeux
            for (const voeu of iteration) {
                await SsVoeux.db('voeux').insert({candidat_id: user[0], atelier_id: voeu.id, ordrePrio: voeu.ordre})
            }

            return true;

        } catch (err) {
            console.error(err);
            throw new Error("Insert n'a pas marché");
        }
    }
}

export default SsVoeux;
