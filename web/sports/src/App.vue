<template>
  <div id="app">
     
     <div v-if="$route.meta.keepAlive">
      <router-view></router-view>
      <Footer></Footer>
     </div>
     <router-view v-if="!$route.meta.keepAlive"></router-view>
     
  </div>
</template>


<script>
import "@/assets/reset.min.css";
import "@/assets/basic.less";
import Footer from "./components/Footer.vue";

export default {
  name: 'App',
  components:{
    Footer
  }
}
</script>
