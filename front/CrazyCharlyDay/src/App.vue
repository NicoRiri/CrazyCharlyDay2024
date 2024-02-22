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
    actualiser(){
      let panier=sessionStorage.getItem('panier');
      if(panier==null){
        panier=[];
      }else{
        panier=JSON.parse(panier);
      }
      this.donnee=panier;
    },
    valider(){
      let panier=sessionStorage.getItem('panier');
      console.log(panier);
    }
  },
  mounted() {
    this.actualiser();
  }
}
</script>

<template>

  <!--<div id="mySidebar" class="sidebar" @mouseenter="openNav" @mouseleave="closeNav">-->
  <div id="mySidebar" class="sidebar">
    <div class="buttonGroup">
      <h2>Nom</h2>
    <input v-model="nom" placeholder="Entrer votre nom" required>
      <h2>Prénom</h2>
    <input v-model="prenom" placeholder="Entrer votre prenom" required>
      <h2>Email</h2>
    <input v-model="email" type="email" placeholder="Entrer votre email" required>
    </div>
    <h2>Ateliers</h2>
    <div class="panier">
      <div v-for="(item, index) in donnee" class="boite">
        <SubAffiche :nom="item" :index="index" />
      </div>
    </div>
    <button @click="valider()" class="valider"><h2>Valider</h2></button>
  </div>
  <section class="page">
    <nav>
      <RouterLink to="/" class="home button">Home</RouterLink>
      <img alt="Vue logo" class="logo button" src="@/assets/logo.webp" width="125" height="125" />
      <RouterLink to="/articles/1" class="article">Article</RouterLink>
    </nav>

    <RouterView :key="$route.path"/>
  </section>

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
  letter-spacing: 3px;
}
nav > a {
  color: var(--vt-c-white);
}



.sidebar {
  width: 150px;
  height: 100vh;
  border: none;
  margin-top: 0px;
  padding: 30px 5px 10px 25px;
  position: fixed;
  top: 0px;
  left: 0px;
  background-color: var(--color-background-soft);
  transition: 0.5s ease all;
  font-size: 14px;
  transform: translate(-100%);
  opacity: 1;
  z-index: 5;
}

.sidebar::after {
  content: '';
  position: absolute;
  background-color: var(--color-background-soft);
  background-image: url(http://ekladata.com/Ue5tUXtZyteBdhOB67TNsBku8IM/dots.png);
  background-position: center;
  background-repeat: no-repeat;
  background-size: 60%;
  top: 0;
  right: 0;
  height: 100%;
  width: 50px;
  transform: translateX(100%);
  transition: 0.5s ease all;
  border-top-right-radius: 0px;
  border-bottom-right-radius: 0px;
}

.sidebar:hover {
  transform: translateX(0%);
  opacity: 1;
  width: 30vw;
}

.sidebar:hover::after {
  right: 1px;
  opacity: 1;
}



.buttonGroup
{
  display: grid;
  grid-template-rows: 30px 30px 30px 30px;
  grid-template-columns: 47.5% 47.5%;
  grid-column-gap: 5%;
  grid-row-gap: 5px;
  margin-bottom: 20px;
}

.buttonGroup> h2:nth-child(1){
  grid-row: 1;
  grid-column: 1;
}

.buttonGroup >input:nth-child(2){
  grid-row: 2;
  grid-column: 1;
}
.buttonGroup> h2:nth-child(3){
  grid-row: 1;
  grid-column: 2;
}

.buttonGroup >input:nth-child(4){
  grid-row: 2;
  grid-column: 2;
}

.buttonGroup>h2:nth-child(5)
{
  grid-column-start: 1;
  grid-column-end: 3;
  grid-row: 3;
}

.buttonGroup>input:nth-child(6){
  grid-column-start: 1;
  grid-column-end: 3;
  grid-row: 4;
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
  background-color:transparent;
  border: 2px solid var(--color-border);
  padding: 5px;
  height: 60vh;
  overflow: auto;
}

.valider{
  background-color: green;
  margin-left: 50%;
  transform: translateX(-50%);
  padding: 8px 10px 8px 10px;
  margin-top: 5px;
  border: none;
  color: var(--vt-c-white);
}

</style>
