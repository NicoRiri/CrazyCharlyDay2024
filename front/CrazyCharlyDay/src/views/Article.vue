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
          this.max = response.data.data;
        }
    ).catch((error) => {
          console.log(error);
        }
    )
    this.id = this.$route.params.id;
    this.idnext = Number(this.id) + 1;
    this.idprev = Number(this.id) - 1;
    axios
        .get("http://docketu.iutnc.univ-lorraine.fr:35652/atelier/page/" + this.id)
        .then((response) => {
          this.donnee = response.data.data;
        })
        .catch((error) => {
          console.log(error);
        });
  },
  methods: {
    reroute(id) {
      this.$router.push({path: '/articles/' + id})
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
      <button v-if="idprev>0" class="next" @click="reroute(idprev)">Page précédente</button>
      <button v-if="idnext<=max" class="before" @click="reroute(idnext)">Page suivante</button>
    </div>
  </main>
</template>

<style>
.boite {
  position: relative;
  background-color: var(--color-background-soft);
  width:80%;
  margin: auto;
  height: 200px;
  border-bottom: var(--color-background) 3.5px dashed;
}
.boite::before{
  content: '';
  position: absolute;
  height: 15px;
  width: 15px;
  border-radius: 50%;
  background-color: var(--color-background);
  bottom: 0;
  left: 0;
  transform: translate(-50%, 55%);
  z-index: 2;
}
.boite::after{
  content: '';
  position: absolute;
  height: 15px;
  width: 15px;
  border-radius: 50%;
  background-color: var(--color-background);
  bottom: 0;
  right: 0;
  transform: translate(50%, 55%);
  z-index: 2;
}

main {
  margin-top: 10px;
}

.pageTurn {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.next {
  background-color: var(--vt-c-purple);
  transition: 0.5s ease all;
  margin:auto;
  padding: 8px 10px 8px 10px;
  margin-top: 5px;
  border: none;
  color: var(--vt-c-white);
  font-family: var(--h2-font);
  font-size: 20px;
  letter-spacing: 2px;
}

.before {
  background-color: var(--vt-c-purple);
  margin: auto;
  transition: 0.5s ease all;
  padding: 8px 10px 8px 10px;
  margin-top: 5px;
  border: none;
  color: var(--vt-c-white);
  font-family: var(--h2-font);
  font-size: 20px;
  letter-spacing: 2px;
}

button:hover{
  background-color:var(--vt-c-light-purple);
}
h1{
  color: var(--vt-c-purple);
}

</style>