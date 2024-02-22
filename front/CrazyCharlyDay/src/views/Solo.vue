<script>
import axios from "axios";

export default {
  data(){
    return {
      id: this.$route.params.id,
      image: null,
      atelier: [],
      user: [],
      date: "",
      duree: 0
    }
  },
  mounted() {
    this.id=this.$route.params.id;
    axios
      .get("http://docketu.iutnc.univ-lorraine.fr:35652/atelier/"+this.id)
      .then((response) => {
        this.atelier = response.data.data.atelier;
        this.user = response.data.data.user;
        console.log(this.atelier);
        console.log(this.user);
        let debut=this.atelier.debut.split("T")[0].split(" ")[0];
        let debutdate=new Date(this.atelier.debut);
        let findate=new Date(this.atelier.fin);
        const differenceEnMillisecondes = Math.abs(findate - debutdate);
        const jours = Math.floor(differenceEnMillisecondes / (1000 * 60 * 60 * 24));
        const heuresRestantes = Math.floor((differenceEnMillisecondes % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        const minutesRestantes = Math.floor((differenceEnMillisecondes % (1000 * 60 * 60)) / (1000 * 60));
        this.duree=jours+" jours "+heuresRestantes+" heures "+minutesRestantes+" minutes";
        this.date = debut;
        console.log(this.user);
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods:{
    ajout() {
      let pack = {id: this.atelier.id, titre: this.atelier.titre, date: this.date};
      let panier = sessionStorage.getItem('panier');
      if (panier == null) {
        panier = [];
      } else {
        panier = JSON.parse(panier);
      }
      let trouve = false;
      panier.forEach((element) => {
        if (element.id === pack.id) {
          alert("Vous avez déjà ajouté cet atelier");
          trouve = true;
        }
      });
      if(!trouve){
        panier.push(pack);
        sessionStorage.setItem('panier', JSON.stringify(panier));
      }
      this.$root.actualiser();
    }
  }
}
</script>

<template>
<main>
  <section id="description-atelier-solo">
  <img alt="Cuisine" :src="atelier.image" height="" width="100%" />

    <div>
      <h2>{{ atelier.titre }}</h2>
      <p>{{ atelier.description }}</p>
      <p>{{ atelier.placeDispo }} places</p>
      <p>{{date}}</p>
      <p>{{duree}}</p>
      <button @click="ajout()">Participer</button>
    </div>
    <div id="liste_participants">
      <h2>Participants:</h2>
      <ul>
        <li v-for="(singleUser) in user">
          {{ singleUser.nom }} {{singleUser.prenom}}
        </li>
      </ul>
    </div>

  </section>



</main>
</template>

<style scoped>
#description-atelier-solo
{
  display: grid;
  grid-template-rows: 40vh 10vh;
  grid-template-columns: 47.5% 47.5%;
  grid-gap:5%;
  padding: 40px;
  grid-row-gap: 50px;
}
#description-atelier-solo img:nth-child(1){
  grid-row: 1;
  grid-column: 1;
}
#description-atelier-solo img:nth-child(2){
  grid-row: 1;
  grid-column: 2;
}


#liste_participants{
  grid-column: 1/3;
  grid-row:2;
  padding: 20px 0px 20px 0px;
  height: auto;
  flex-wrap: wrap;
}

#liste_participants ul{
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(400px, 40px));
  grid-column-gap: 20px;
  grid-row-gap: 20px;
  text-align:center;
  justify-content: center;
}
#liste_participants ul li{
  list-style: none;
  margin: 20px;
  background-color: var(--vt-c-light-green);
  padding: 10px;
  color: var(--color-background-soft);
  flex-wrap: wrap;
}
button{
  background-color: var(--vt-c-dark-green);
  padding: 8px 10px 8px 10px;
  margin-top: 5px;
  border: none;
  color: var(--vt-c-white);
  font-family: var(--h2-font);
  font-size: 20px;
  letter-spacing: 2px;
}
</style>