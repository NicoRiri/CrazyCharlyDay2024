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

    static async getVoeuxById(req, res, next) {
        try {
            const date = new Date();
            const atelier = await SsVoeux.db('atelier').where('id', req.params.id).select('*').first()
            if (atelier === undefined) {
                throw new Error("Atelier non trouvé");
            }
            const users = await SsVoeux.db('utilisateur').where('admin', 0).select('*')
            const voeux = []
            for (const user of users) {
                const voeuxUser = await SsVoeux.db('voeux').where('candidat_id', user.id).where('atelier_id', atelier.id).select('*').first()
                if (voeuxUser !== undefined) {
                    voeux.push({id: user.id, nom: user.nom, email: user.email, voeux: voeuxArray})
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
            const user = await SsVoeux.db('utilisateur').insert({nom: req.body.nom, prenom: req.body.prenom, email: req.body.email, admin : 0})
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

    static async postVoeuxResultat(req, res, next) {
        try {
            const candidats = req.body.candidats
            console.log(candidats)


            for (const candidat of candidats) {
                for (const accor of candidat.voeuxAccordes) {
                    console.log(accor)
                    const user = await SsVoeux.db('utilisateur').where('nom', candidat.nom).select('*').first()
                    const voeu = await SsVoeux.db('atelier').where('theme', accor.theme).select('*').first()
                    console.log(voeu)
                    const liaison = await SsVoeux.db('liaison').insert({
                        candidat_id: user.id,
                        atelier_id: voeu.id
                    })
                }
            }

            return true;

        } catch (err) {
            console.error(err);
            throw new Error("Insert n'a pas marché");
        }
    }
}

export default SsVoeux;
