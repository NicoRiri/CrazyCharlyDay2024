<script>
export default{
  props: {
    donnee: {
      type: Object,
      required: true
    }
  },
  data(){
    return {
      duree: 0,
      date: ""
    }
  },
  methods: {
  reroute(id) {
    this.$router.push({ path: '/atelier/'+id })
  }
},
  mounted() {
    let debut=this.donnee.debut.split("T")[0].split(" ")[0];
    let debutdate=new Date(this.donnee.debut);
    let findate=new Date(this.donnee.fin);
    const differenceEnMillisecondes = Math.abs(findate - debutdate);
    const jours = Math.floor(differenceEnMillisecondes / (1000 * 60 * 60 * 24));
    const heuresRestantes = Math.floor((differenceEnMillisecondes % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutesRestantes = Math.floor((differenceEnMillisecondes % (1000 * 60 * 60)) / (1000 * 60));
    this.duree=jours+" jours "+heuresRestantes+" heures "+minutesRestantes+" minutes";
    this.date = debut;
  }
}
</script>

<template>
  <div class="subMenu">
    <div class="subAffiche">
  <h1>{{donnee.titre}}</h1>
  <p>{{donnee.description}}</p>
      <p>{{duree}}</p>
      <p>{{date}}</p>
    <button @click="reroute(donnee.id)">Voir plus</button>
    </div>
  <img alt="Cuisine" src="@/assets/placeholder.png" width="500px" height="250px" />
  </div>
</template>

<style scoped>
h1 {
  color: red;
  margin-top: 20px;
  margin-bottom: 20px;
}

.subMenu{
  display:flex;
}

.subAffiche{
  width:80%;
  margin-left: 20px;
}

img{
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>