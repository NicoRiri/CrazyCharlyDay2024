import knex from "knex";
import config from "../knex.js";

class SsVoeux {
    static db = knex(config.development);

    static async getVoeux(req, res, next) {
        try {
            const date = new Date();
            const users = await SsVoeux.db('utilisateur').where('admin', 0).select('*')
            const voeux = []
            for (const user of users) {
                const voeuxUser = await SsVoeux.db('voeux').where('candidat_id', user.id).select('*')
                const voeuxUserFormated = []
                for (const voeu of voeuxUser) {
                    const atelier = await SsVoeux.db('atelier').where("debut", ">=", date).where('id', voeu.atelier_id).select('*').first()
                    if (atelier !== undefined) {
                        voeuxUserFormated.push({id: atelier.id, titre: atelier.titre, theme: atelier.theme, ordre: voeu.ordrePrio})
                    }
                }
                if (voeuxUserFormated.length > 0){
                    voeux.push({id: user.id, nom: user.nom, email: user.email, voeux: voeuxUserFormated})
                }
            }

            return voeux;

        } catch (err) {
            console.error(err);
            throw new Error("Insert n'a pas marché");
        }
    }

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
