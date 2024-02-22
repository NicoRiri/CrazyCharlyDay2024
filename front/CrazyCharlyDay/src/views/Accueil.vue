<template>
  <header>
    <h1>La boîte</h1>
    <h1>à cuisine</h1>
  </header>
  <main>
    <h1>
Bienvenue sur CrazyCharlyDay
    </h1>
  </main>
</template>

<style scoped>
main
{
  min-height: 40vh;
  padding: 30px 40px 30px 50px;
}

header{
  background-image: url("../assets/images/header.webp");
  width: 100%;
  height: 70vh;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0px 40%;
  font-family: var(--header-font);
  font-variant: all-petite-caps;
  position: relative;
  font-size: 6vw;
  color: var(--vt-c-white);
  text-shadow: 4px 3px 11px black;
}

header >h1:nth-child(1) {
  position: absolute;
  top: 0vh;
  left: 19vw;
}
header >h1:nth-child(2){
  position: absolute;
  bottom: 4vh;
  right: 19vw;
}

</style>