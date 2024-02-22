import { defineStore } from 'pinia'

export const usePanierStore = defineStore('panier', {
  state: () => {
    return { panier: [] }
  },
  // could also be defined as
  // state: () => ({ count: 0 })
  actions: {
    ajout(pack) {
        this.panier.push(pack);
    },
  },
})