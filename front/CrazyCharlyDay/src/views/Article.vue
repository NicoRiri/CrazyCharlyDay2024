<script>
import ArticleAffiche from "@/components/ArticleAffiche.vue";
import axios from "axios";

export default {
  components: {ArticleAffiche},
  data() {
    return {
      donnee: [],
      id: null,
      idnext: null,
      idprev: null,
      max: null
    }
  },
  mounted() {
    axios.get("http://docketu.iutnc.univ-lorraine.fr:35652/atelier/pages").then(
      (response) => {
        this.max=response.data.data;
      }
    ).catch((error) => {
      console.log(error);
    }
    )
    this.id=this.$route.params.id;
    this.idnext=Number(this.id)+1;
    this.idprev=Number(this.id)-1;
    axios
      .get("http://docketu.iutnc.univ-lorraine.fr:35652/atelier/page/"+this.id)
      .then((response) => {
        this.donnee = response.data.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    reroute(id) {
      this.$router.push({ path: '/articles/'+id})
    }
  }
}
</script>

<template>
  <main>
    <div v-for="item in donnee" class="boite">
      <article-affiche :donnee="item"/>
    </div>
    <div class="pageTurn">
    <p v-if="idprev>0" class="next" @click="reroute(idprev)">Page précédente</p>
    <p v-if="idnext<=max" class="before" @click="reroute(idnext)">Page suivante</p>
    </div>
  </main>
</template>

<style>
.boite{
  background-color:blue;
}

main{
  margin-top: 10px;
}

.pageTurn{
  display:flex;
  justify-content:space-between;
}

.next{
  background-color:pink;
}

.before{
  background-color:purple;
}
</style>