<script>
import fs from 'fs';
import { exec } from 'child_process';
export default {
  data() {
    return {}
  },
  methods: {
    toCreateAtelier() {
      this.$router.push({name: "CreateAtelier"});
    },
    toViewAtelier() {
      this.$router.push({name: "ViewAtelier"});
    },
    executeJar() {
      // Read the JSON file
      fs.readFile('config.json', 'utf8', (err, data) => {
        if (err) {
          console.error('Error reading JSON file:', err);
          return;
        }

        try {
          const config = JSON.parse(data);

          // Check if the JAR file path is provided in the JSON
          if (config.jarFilePath) {
            // Execute the JAR file
            exec(`java -jar ${config.jarFilePath}`, (error, stdout, stderr) => {
              if (error) {
                console.error('Error executing JAR file:', error);
                return;
              }
              console.log(stdout);
            });
          } else {
            console.error('JAR file path is not provided in the JSON');
          }
        } catch (parseError) {
          console.error('Error parsing JSON:', parseError);
        }
      });
    }
  }
}
</script>
<template>
  <header>
    <h1>Bienvenue dans le backoffice (même si il y pas de mot de passe)</h1>
  </header>
  <main>
    <div class="d-flex justify-space-between boutton">
      <v-btn size="x-large" @click="toViewAtelier" color="green">Voir Atelier</v-btn>
      <v-btn size="x-large" @click="executeJar" color="white">Calculer les ateliers</v-btn>
      <v-btn size="x-large" @click="toCreateAtelier" color="green">Créer un atelier</v-btn>
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
</style>