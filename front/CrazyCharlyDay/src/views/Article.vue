<script>
export default {
  data() {
    return {
      donnee: [{ id: 1, nom: "Cuisine Français", date: "2022-03-18" }, { id: 2, nom: "Cuisine Anglaise", date: "2023-03-17" }],
    }
  },
  methods: {
    reroute(id) {
      this.$router.push({ path: '/cuisine/'+id })
    }
  }
}
</script>

<template>
  <main>
    <div v-for="item in donnee" class="boite">
      <p>{{ item.nom }}</p>
      <p>{{ item.date }}</p>
      <button @click="reroute(item.id)">Rejoindre</button>
    </div>
  </main>
</template>

<style>
.boite{
  background-color:blue;
}
</style>