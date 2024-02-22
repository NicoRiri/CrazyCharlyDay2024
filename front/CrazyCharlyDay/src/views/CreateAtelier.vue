<script>
import axios from "axios";

export default {
  data() {
    return {
      "titre" : "",
      "description" : "",
      "placeDispo" : "",
      "theme" : "",
      "debut" : "",
      "fin" : "",
      "image" : "",

    }
  },
  methods: {
    toAdmin() {
      this.$router.push({name: "Admin"});
    },
    creerAtelier(){
      let atelier = {
        "titre" : this.titre,
        "description" : this.description,
        "placeDispo" : this.placeDispo,
        "theme" : this.theme,
        "debut" : this.debut,
        "fin" : this.fin,
        "image" : this.image
      }
      console.log(atelier);
      axios.post("http://docketu.iutnc.univ-lorraine.fr:35652/atelier", atelier)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
      console.log(atelier);
      this.$router.push({name: "Admin"});
    }
  }
}
</script>
<template>
  <header>
    <h1>Bienvenue dans le backoffice (même si il y pas de mot de passe)</h1>
  </header>
  <main>

      <div class="flexible">
        <v-text-field placeholder="titre" v-model="titre"/>
        <v-text-field placeholder="theme" v-model="theme"/>
      </div>
      <div class="flexible">
        <v-text-field placeholder="placeDispo" v-model="placeDispo"/>
        <v-text-field placeholder="image" v-model="image"/>
      </div>
      <div>
        <input type="datetime-local" v-model="debut">
        <input type="datetime-local" v-model="fin">
      </div>
      <div>
        <v-textarea placeholder="description" v-model="description" class="bigBoi"/>
      </div>

      <div class="flexible">
        <v-btn size="x-large" @click="creerAtelier" color="green">Créer l'atelier</v-btn>
        <v-btn size="x-large" @click="toAdmin" color="green">Annuler</v-btn>
      </div>
  </main>
</template>
<style scoped>
main{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: 10vh;
}
h1{
  font-size: 2em;
  text-align: center;
  margin: 0;
  padding: 0;
  color: var(--vt-c-dark-green);
  font-family: var(--header-font);
  font-variant: all-petite-caps;
  letter-spacing: 3px;
  margin-top: 10vh;
}

.card{
width: 100%;
  height: 100%;
  background-color: var(--vt-c-white);
  border-radius: 10px;
  box-shadow: 0 0 10px 0 rgba(0,0,0,0.2);
  margin-top: 10vh;
  padding: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  font-family: var(--header-font);
  font-variant: all-petite-caps;
  letter-spacing: 3px;
  font-size: 1.5em;
  color: var(--vt-c-dark-green);
  text-align: center;
  margin-bottom: 10vh;
}

.flexible {
  display: flex;
}

.flexible > * {
  margin: 10px;
  width:300px;
}

.bigBoi{
  margin-top: 20px;
  width:600px;
}
</style>