<script>
import { RouterLink, RouterView } from 'vue-router'
import SubAffiche from "@/components/subAffiche.vue";

export default {
  components: {
    SubAffiche,
    RouterLink,
    RouterView
  },
  data(){
    return {
      nom: '',
      prenom: '',
      email: '',
      donnee: [{ id: 1, nom: "Cuisine Français", date: "2022-03-18" }, { id: 2, nom: "Cuisine Anglaise", date: "2023-03-17" }],
    }
  },
  methods: {
    openNav() {
  document.getElementById("mySidebar").style.width = "500px";
},
    closeNav() {
  document.getElementById("mySidebar").style.width = "10px";
}
  }
}
</script>

<template>
  <nav>
    <RouterLink to="/" class="home button">Home</RouterLink>
    <img alt="Vue logo" class="logo button" src="@/assets/logo.webp" width="125" height="125" />
    <RouterLink to="/articles" class="article">Article</RouterLink>
  </nav>
  <header>
    <h1>La boîte</h1>
    <h1>à cuisine</h1>
  </header>
  <div id="mySidebar" class="sidebar" @mouseenter="openNav" @mouseleave="closeNav">
    <div class="buttonGroup">
    <a href="javascript:void(0)" class="closebtn" @click="closeNav">×</a>
    <input v-model="nom" placeholder="Entrer votre nom" required>
    <input v-model="prenom" placeholder="Entrer votre prenom" required>
    <input v-model="email" type="email" placeholder="Entrer votre email" required>
    </div>
    <div class="panier">
      <div v-for="item in donnee" class="boite">
        <SubAffiche :nom="item.nom" />
      </div>
    </div>
    <button class="valider">Valider</button>
  </div>
  <RouterView />
</template>

<style scoped>
nav {

  display: flex;
  line-height: 1;
  background-color: var(--vt-c-dark-green);
  top: 0;
  left: 0;
  width: 100%;
  align-items: center;
  justify-items: center;
  justify-content: space-around;
  font-family: var(--header-font);
  font-variant: all-petite-caps;
  font-size: xx-large;
  height: 8vh;
}
nav > a {
  color: var(--vt-c-beige);
}

header{
  background-image: url("./assets/images/header.webp");
  width: 100%;
  height: 70vh;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0px 40%;
  font-family: var(--header-font);
  font-variant: all-petite-caps;
  position: relative;
  font-size: 6vw;
  color: var(--vt-c-white);
  text-shadow: 4px 3px 11px black;
}

header >h1:nth-child(1) {
  position: absolute;
  top: 0vh;
  left: 19vw;
}
header >h1:nth-child(2){
  position: absolute;
  bottom: 4vh;
  right: 19vw;
}

.sidebar {
  height: 100%;
  width: 10px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.closebtn {
  position: absolute;
  top: 0;
  right: 0;
  width:100%;
  background-color:orange;
}

.openbtn {
  font-size: 20px;
  cursor: pointer;
  background-color: #111;
  color: white;
  padding: 10px 15px;
  border: none;
}

.panier{
  background-color:yellow;
  padding-top: 5px;
  padding-bottom: 5px;
  margin-top: 20px;
}

.valider{
  background-color: green;
}

</style>
