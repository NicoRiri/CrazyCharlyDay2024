import knex from "knex";
import config from "../knex.js";

class SsAtelier {
    static db = knex(config.development);

    static async getAtelier(req, res, next) {
        try {
            return await SsAtelier.db('atelier').select('*');
        } catch (err) {
            console.error(err);
            throw new Error("can't find atelier");
        }
    }

    static async getAtelierNbPage(req, res, next) {
        try {
            let date = new Date().toLocaleString();
            const res = await SsAtelier.db('atelier').where("debut", ">=", date).count('id as nb').first();
            return Math.ceil(res.nb / 5);
        } catch (err) {
            console.error(err);
            throw new Error("Erreur lors du calcul du nombre de page pour les ateliers");
        }
    }

    static async getAtelierById(req, res, next) {
        try {
            return await SsAtelier.db('atelier').where('id', req.params.id).select('*').first();
        } catch (err) {
            console.error(err);
            throw new Error("can't find atelier");
        }
    }

    static async getAtelierByPage(req, res, next) {
        try {
            let date = new Date();
            return await SsAtelier.db('atelier').select('*').where("debut", ">=", date).orderBy('id').limit(5).offset((req.params.page - 1) * 5)
        } catch (err) {
            console.error(err);
            throw new Error("can't find atelier");
        }
    }

    static async postAtelier(req, res, next) {
        try {
            return await SsAtelier.db('atelier').insert({titre: req.body.titre, description: req.body.description, theme: req.body.theme, placeDispo: req.body.placeDispo, image: req.body.image, debut: req.body.debut, fin: req.body.fin});
        } catch (err) {
            console.error(err);
            throw new Error("Erreur lors du post de l'atelier");
        }
    }
}

export default SsAtelier;
