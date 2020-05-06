<template>
    <div class="sports">
    	 <!-- Header -->
        <mt-header fixed title="健身环境">
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
					<img src="../../common/images/house1.jpg" alt="">
				</div>
				<div class="detail">有氧运动区</div>
        	</div>
			<div class="item">
        		<div class="img">
					<img src="../../common/images/house2.jpg" alt="">
				</div>
				<div class="detail">更衣室</div>
        	</div>
        	<div class="item">
        		<div class="img">
					<img src="../../common/images/house3.jpg" alt="">
				</div>
				<div class="detail">无氧运动区</div>
        	</div>
        	<div class="item">
        		<div class="img">
					<img src="../../common/images/house4.jpg" alt="">
				</div>
				<div class="detail">瑜伽健身场地</div>
        	</div>
        	<div class="item">
        		<div class="img">
					<img src="../../common/images/house5.jpg" alt="">
				</div>
				<div class="detail">拳击区</div>
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