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
  document.getElementById("mySidebar").style.width = "0";
}
  }
}
</script>

<template>
  <header>
    <button class="openbtn" @click="openNav">☰ Open Sidebar</button>
    <RouterLink to="/" class="home button">Home</RouterLink>
    <img alt="Vue logo" class="logo button" src="@/assets/logo.svg" width="125" height="125" />
    <RouterLink to="/articles" class="article">Article</RouterLink>
  </header>
  <div id="mySidebar" class="sidebar">
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

.sidebar {
  height: 100%;
  width: 0;
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
