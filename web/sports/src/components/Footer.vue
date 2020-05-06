<template>
      <footer>
            <router-link to="/home">
                  <aside><i class="iconfont">&#xe50d;</i><span>首页</span></aside>
            </router-link>
            <router-link to="/course">
                  <aside><i class="iconfont">&#xe65e;</i><span>课程</span></aside>
            </router-link>
            <router-link to="/exercise">
                  <aside><i class="iconfont">&#xe605;</i><span>训练</span></aside>
            </router-link>
            <router-link to="/personal">
                  <aside><i class="iconfont">&#xe804;</i><span>我的</span></aside>
            </router-link>
      </footer>
</template>
<style>
@import "../common/css/footer.css";
</style>
<script>
export default {
    
}
</script>