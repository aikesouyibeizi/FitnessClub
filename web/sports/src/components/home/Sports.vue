<template>
    <div class="sports">
    	 <!-- Header -->
        <mt-header fixed title="运动项目">
		  <router-link :to="{path:'home'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
    	<div class="title">
			
        </div>
        <div class="main">
        	<div class="item">
        		<div class="img">
					<img src="../../common/images/sports.jpg" alt="">
				</div>
				<div class="detail">健身操</div>
        	</div>
			<div class="item">
        		<div class="img">
					<img src="../../common/images/run.jpg" alt="">
				</div>
				<div class="detail">跑步</div>
        	</div>
        	<div class="item">
        		<div class="img">
					<img src="../../common/images/sports3.jpg" alt="">
				</div>
				<div class="detail">瑜伽</div>
        	</div>
        	<div class="item">
        		<div class="img">
					<img src="../../common/images/sports4.jpg" alt="">
				</div>
				<div class="detail">拳击</div>
        	</div>
        	
        </div>
    </div>
</template>
<style>
@import "../../common/css/home/environment.css";
</style>
<script>
export default {
    
}
</script>