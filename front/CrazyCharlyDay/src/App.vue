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

  <!--<div id="mySidebar" class="sidebar" @mouseenter="openNav" @mouseleave="closeNav">-->
  <div id="mySidebar" class="sidebar">
    <div class="buttonGroup">
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
  <section class="page">
    <nav>
      <RouterLink to="/" class="home button">Home</RouterLink>
      <img alt="Vue logo" class="logo button" src="@/assets/logo.svg" width="125" height="125" />
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

.page{
  margin-left:50px;
}



/*.sidebar {
  height: 85vh;
  width: 200px;
  position: fixed;
  z-index: 1;
  top: 70px;
  left: 0;
  background-color: var(--color-background-soft);
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
  transform: translateX(-90%);
  opacity: 0.5;
}*/
.sidebar {
  width: 150px;
  height: 100vh;
  border: none;
  margin-top: 0px;
  padding: 10px 5px 10px 20px;
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
  right: 0px;
  opacity: 1;
  transform: translateX(0%);
}

.sidebar input{

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
