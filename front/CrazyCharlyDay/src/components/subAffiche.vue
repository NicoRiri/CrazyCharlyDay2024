<script>
export default {
  props: {
    nom: {
      type: Object,
      required: true
    },
    index: {
      type: Number,
      required: true
    }
  },
  mounted() {
  },
  methods: {
    deleteItem(){
      let panier=sessionStorage.getItem('panier');
      let nouveau=JSON.parse(panier);
      nouveau.splice(this.index,1);
      sessionStorage.setItem('panier',JSON.stringify(nouveau));
      this.$root.actualiser();
    }
  }
}

</script>

<template>
  <div class="card-Atelier">
    <h1>{{nom.titre}}</h1>
    <p>{{nom.date}}</p>
    <button @click="deleteItem()">Supprimer</button>
  </div>

</template>

<style scoped>
h1 {
  color: var(--vt-c-purple);
  margin-top: 20px;
  margin-bottom: 0px;
}

</style>