<script setup>
defineProps(["nom"])
</script>

<template>
  <h1>{{nom}}</h1>
</template>

<style scoped>
h1 {
  color: red;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>