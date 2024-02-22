import knex from "knex";
import config from "../knex.js";

class SsAtelier {
    static db = knex(config.development);

    static async getAtelier() {
        try {
            return await SsAtelier.db('atelier').select('*');
        } catch (err) {
            console.error(err);
            throw new Error("can't find atelier");
        }
    }
}

export default SsAtelier;
