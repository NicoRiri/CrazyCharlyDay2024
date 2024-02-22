<script>
import axios from "axios";
export default {
  data() {
    return {
      packet: []
    }
  },
  methods: {
    toCreateAtelier() {
      this.$router.push({name: "CreateAtelier"});
    },
    toViewAtelier() {
      this.$router.push({name: "ViewAtelier"});
    },
    toAdmin() {
      this.$router.push({name: "Admin"});
    },
    requete(){
      let lien = "";
      axios
      .get()
      .then((response) => {

      })
      .catch((error) => {
        console.log(error);
      })
    }
  }
}
</script>
<template>
  <header>
    <h1>Bienvenue dans le backoffice (même si il y pas de mot de passe)</h1>
  </header>
  <main>
    <div class="centre">
      <v-btn size="x-large" @click="toAdmin" color="green">Annuler</v-btn>
    </div>
    <div>
      <div v-for="item in packet" class="card subpack">
        <div class="textPack">
        <h1 class="reset">{{item.titre}}</h1>
          <div class="flexible">
          <p>theme : {{item.theme}}</p>
            <p class="spec">id : {{item.id}}</p>
          </div>
        <p class="spec">place disponible : {{item.placeDispo}}</p>
        <p class="spec">debut : {{item.debut}}</p>
        <p class="spec">fin : {{item.fin}}</p>
        </div>
        <p class="desc">
          {{ item.description }}</p>
        <img :src="item.image" width="500">
      </div>
    </div>
  </main>
</template>
<style scoped>
.boutton{
  margin: 10px 25vw 10px 25vw;
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
  align-items: center;
  flex-direction: row;
  font-family: var(--header-font);
  font-variant: all-petite-caps;
  letter-spacing: 3px;
  font-size: 1.5em;
  color: var(--vt-c-dark-green);
  text-align: center;
  margin-bottom: 10vh;
}

.centre{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.spec{
  font-family: Arial, sans-serif;
  font-size:1em;
}

.textPack{
  margin-left: 20px;
  width:500px;
  margin-bottom: 20px;
}

.reset{
  margin:0;
  font-size:3em;
  height: 80px;
  text-align: center;
  margin-bottom: 20px;
}

.desc {
  max-width: 800px; /* Remplacez 400px par la largeur maximale souhaitée */
  word-wrap: break-word;
  margin-left: 20px;
  text-align: left;
  width: 800px;
}

.GoBoi{
  margin-top: 10px;
  font-size: 1.5em;
}

.flexible{
  display: flex;
  justify-content: space-between;
  width: 200px;
  margin-left: 160px;
}
</style>