<script>
import axios from "axios";

export default {
  data(){
    return {
      id: this.$route.params.id,
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
  <img alt="Cuisine" :src="atelier.image" width="100%" height="100%" />
  <h1>{{ atelier.titre }}</h1>
  <p>{{ atelier.description }}</p>
  <p>{{ atelier.placeDispo }} places</p>
  <p>{{date}}</p>
  <p>{{duree}}</p>
  <button @click="ajout()">Participer</button>
  <div class="userList">
    <h1>Participant actuel</h1>
    <p v-for="item in user">
      {{item.prenom}} {{item.nom}}
    </p>
  </div>
</main>
</template>

<style scoped>

</style>