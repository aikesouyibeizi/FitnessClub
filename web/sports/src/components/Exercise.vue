<template>
<div>
  
  
  <mt-navbar v-model="selected">
    <mt-tab-item id="1">训练目标</mt-tab-item>
    <mt-tab-item id="2">训练日记</mt-tab-item>
  </mt-navbar>
  


  <!-- tab-container -->
  <mt-tab-container v-model="selected">
    <mt-tab-container-item id="1">

    </mt-tab-container-item>
    <mt-tab-container-item id="2">
      <Calendar></Calendar>
    </mt-tab-container-item>
   </mt-tab-container>
  </div>
</template>


<script>
import Calendar from "@/components/Calendar.vue";
import 'mpvue-calendar/src/browser-style.css';
export default {
  name: 'page-navbar',
  data() {
    return {
      selected: '1'
    };
  },
  components:{
    Calendar
  }
}


</script>
<style>
@import '../common/css/calendar.css';
@import '../common/css/exercise.css';
@import '../common/iconfont/iconfont.css';
</style>

