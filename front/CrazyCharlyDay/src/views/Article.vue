<script>
import ArticleAffiche from "@/components/ArticleAffiche.vue";

export default {
  components: {ArticleAffiche},
  data() {
    return {
      donnee: [{ id: 1, nom: "Cuisine Français", date: "2022-03-18" }, { id: 2, nom: "Cuisine Anglaise", date: "2023-03-17" }],
    }
  }
}
</script>

<template>
  <main>
    <div v-for="item in donnee" class="boite">
      <article-affiche :donnee="item"/>
    </div>
  </main>
</template>

<style>
.boite{
  background-color:blue;
}
</style>