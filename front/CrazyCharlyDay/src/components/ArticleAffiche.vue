<script>
export default{
  props: {
    donnee: {
      type: Object,
      required: true
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
  <h1>{{donnee.nom}}</h1>
  <p>{{donnee.date}}</p>
  <button @click="reroute(donnee.id)">Voir plus</button>
</template>

<style scoped>
h1 {
  color: red;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>