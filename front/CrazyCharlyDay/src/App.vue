<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <RouterLink to="/" class="home button">Home</RouterLink>
    <img alt="Vue logo" class="logo button" src="@/assets/logo.svg" width="125" height="125" />
    <RouterLink to="/articles" class="article">Article</RouterLink>
  </header>
  <RouterView />
</template>

<style scoped>
header {
  display: flex;
  line-height: 1.5;
  background-color: red;
  top: 0;
  left: 0;
  width: 100%;
  align-items: center;
  justify-items: center;
}
</style>
