<script>
import { RouterLink, RouterView } from 'vue-router'
import SubAffiche from "@/components/subAffiche.vue";
import draggable from 'vuedraggable';
import axios from "axios";

export default {
  components: {
    SubAffiche,
    RouterLink,
    RouterView,
    draggable
  },
  data(){
    return {
      nom: "",
      prenom: "",
      email: "",
      donnee: [{ id: 1, titre: "Cuisine Français", date: "2022-03-18" }, { id: 2, titre: "Cuisine Anglaise", date: "2023-03-17" }],
    }
  },
  computed: {
    adminRoute(){
      return this.$route.name === "Admin";
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
      sessionStorage.setItem('nom',this.nom);
      sessionStorage.setItem('prenom',this.prenom);
      sessionStorage.setItem('email',this.email);
    },
    valider(){
      if(this.nom.length>2&&this.prenom.length>2&&this.email.length>2){
        if(this.email.includes("@")&&this.email.includes(".")){
          if(this.donnee.length>0){
            let format={
              "prenom":this.prenom,
              "nom":this.nom,
              "voeux": [],
            }
            let index=1;
            this.donnee.forEach((element)=>{
              format.voeux.push({"id":element.id,"ordre":index});
              index++;
            });
            console.log(format);
            axios.post("http://docketu.iutnc.univ-lorraine.fr:35652/voeux",format).then(
              (response)=>{
                alert(response.data.message);
                sessionStorage.removeItem('panier');
                sessionStorage.removeItem('nom');
                sessionStorage.removeItem('prenom');
                sessionStorage.removeItem('email');
                this.donnee=[];
                this.nom="";
                this.prenom="";
                this.email="";
              }
            ).catch((error)=>{
              console.log(error);
            });
          }else{
            alert("Veuillez selectionner au moins un atelier");
          }
        }else{
          alert("Veuillez entrer une adresse mail valide");
        }
      }else{
        alert("Veuillez remplir tous les champs");
      }
    },
    onDragEnd() {
      sessionStorage.setItem('panier',JSON.stringify(this.donnee));
    }
  },
  mounted() {
    this.nom=sessionStorage.getItem('nom');
    this.prenom=sessionStorage.getItem('prenom');
    this.email=sessionStorage.getItem('email');
    if(this.nom==null){
      this.nom="";
    }
    if(this.prenom==null){
      this.prenom="";
    }
    if(this.email==null){
      this.email="";
    }
    this.actualiser();
  }
}
</script>

<template>
  <div v-if="adminRoute">
    <RouterView :key="$route.path" />
  </div>
  <div v-else>
    <div id="mySidebar" class="sidebar">
      <div class="buttonGroup">
        <h2>Nom</h2>
        <input v-model="nom" placeholder="Entrer votre nom" required minlength="2" @input="actualiser"/>
        <h2>Prénom</h2>
        <input v-model="prenom" placeholder="Entrer votre prenom" required minlength="2" @input="actualiser"/>
        <h2>Email</h2>
        <input v-model="email" type="email" placeholder="Entrer votre email" required  @input="actualiser"/>
      </div>
      <h2>Ateliers</h2>
      <div class="panier">
        <draggable v-model="donnee" :options="{ group: 'items' }" item-key="id" @end="onDragEnd">
          <template #item="{ element: item, index }">
            <div :key="item.id">
              <SubAffiche :nom="item" :index="index" />
            </div>
          </template>
        </draggable>
      </div>
      <button @click="valider()" class="valider"><h2>Valider</h2></button>
    </div>
    <section class="page">
      <nav>
        <RouterLink to="/" class="home button">Home</RouterLink>
        <img alt="Vue logo" class="logo button" src="@/assets/logo.webp" width="125" height="125" />
        <RouterLink to="/articles/1" class="article">Article</RouterLink>
      </nav>

      <RouterView :key="$route.path" />
    </section>
  </div>
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
