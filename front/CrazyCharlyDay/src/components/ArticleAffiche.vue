<script>
export default {
  props: {
    donnee: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      duree: 0,
      date: ""
    }
  },
  methods: {
    reroute(id) {
      this.$router.push({path: '/atelier/' + id})
    },
    ajout() {
      let pack = {id: this.donnee.id, titre: this.donnee.titre, date: this.date};
      let panier = sessionStorage.getItem('panier');
      if (panier == null) {
        panier = [];
      } else {
        panier = JSON.parse(panier);
      }
      panier.push(pack);
      sessionStorage.setItem('panier', JSON.stringify(panier));
      this.$root.actualiser();
    }
  },
  mounted() {
    let debut = this.donnee.debut.split("T")[0].split(" ")[0];
    let debutdate = new Date(this.donnee.debut);
    let findate = new Date(this.donnee.fin);
    const differenceEnMillisecondes = Math.abs(findate - debutdate);
    const jours = Math.floor(differenceEnMillisecondes / (1000 * 60 * 60 * 24));
    const heuresRestantes = Math.floor((differenceEnMillisecondes % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutesRestantes = Math.floor((differenceEnMillisecondes % (1000 * 60 * 60)) / (1000 * 60));
    this.duree = jours + " jours " + heuresRestantes + " heures " + minutesRestantes + " minutes";
    this.date = debut;
  }
}
</script>

<template>
  <div class="subMenu">
    <div class="subAffiche">
      <h2>{{ donnee.titre }}</h2>
      <p><span>{{ date }}</span> <span>durée: {{ duree }}</span></p>
      <div id="description_atelier">{{ donnee.description }} </div>
      <div>
        <button @click="reroute(donnee.id)">Voir plus</button>
        <button @click="ajout()">Participer</button>
      </div>

    </div>
    <div class="illustration_atelier"><img alt="Cuisine" :src="donnee.image" /></div>

  </div>
</template>

<style scoped>
.subAffiche h2 {
}

.subMenu {
  display: flex;
  justify-content: space-between;
}

.subAffiche {
  width: 60%;
  margin-left: 50px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  padding: 20px 0px 20px 0px;
}

.subAffiche > p{
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--vt-c-light-green);
}

.subAffiche > p > span:nth-child(2)
{
  font-size: small;
}

#description_atelier{
  margin: 5px 0px 5px 0px;
  overflow: auto;
  height: 40px;
}

img {
  width: 100%;

}
.illustration_atelier
{
  clip-path: polygon(
  30% 0%,
  100% 0%,
  100% 100%,
  0% 100%
  );
  width:450px;
  height:196px;
  display: flex;
  align-items: center;
  justify-content: center;
}
button{
  margin-right: 20px;
}
</style>