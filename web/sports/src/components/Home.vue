<style>
@import "../common/css/webapp.css";
@import "../common/iconfont/iconfont.css";
</style>
<template>
<div>
    <!-- header -->
	<header>
		<div>健身俱乐部</div>
	</header>
	<!-- content -->
	<main>
		<section class="content">
			<article class="banner">
				<img src="../common/images/yujia2.jpg" alt="">
			</article>
			<article class="adcontent">
				<dl>
					<dt class="iconfont">&#xe65f;</dt>
					<dd>瑜伽</dd>
				</dl>
				<dl>
					<dt class="iconfont">&#xe5e1;</dt>
					<dd>健身</dd>
				</dl>
				<dl>
					<dt class="iconfont">&#xe602;</dt>
					<dd>跑步</dd>
				</dl>
			</article>
			<!-- 标题：健身房环境 -->
			<article class="title">
				<aside>
					<i class="iconfont">&#xe62d;</i>
					<span>健身房环境</span>
				</aside>
				<aside>
					<span @click="moreEnvironment">更多</span>
					<i class="iconfont">&#xe68d;</i>
				</aside>
			</article>

			<!-- 健身房环境 -->
			<!-- 轮播图展示 -->
			<div class="slidershow middle">
				<div class="slides">
					<input type="radio" name="r" id="r1" checked>
					<input type="radio" name="r" id="r2">
					<input type="radio" name="r" id="r3">
					<input type="radio" name="r" id="r4">
					<input type="radio" name="r" id="r5">
					<div class="slide s1">
						<img src="../common/images/house1.jpg" alt="">
					</div>
					<div class="slide">
						<img src="../common/images/house2.jpg" alt="">
					</div>
					<div class="slide">
						<img src="../common/images/house3.jpg" alt="">
					</div>
					<div class="slide">
						<img src="../common/images/house4.jpg" alt="">
					</div>
					<div class="slide">
						<img src="../common/images/house5.jpg" alt="">
					</div>
				</div>
				<div class="navigation">
					<label for="r1" class="bar"></label>
					<label for="r2" class="bar"></label>
					<label for="r3" class="bar"></label>
					<label for="r4" class="bar"></label>
					<label for="r5" class="bar"></label>
				</div>
			</div>
			
			<!-- 标题：运动项目 -->
			<article class="titlesport">
				<aside>
					<i class="iconfont">&#xe673;</i>
					<span>运动项目</span>
				</aside>
				<aside>
					<span @click="moreSports">更多</span>
					<i class="iconfont">&#xe68d;</i>
				</aside>
			</article>
			<!-- 运动项目轮播图 -->
			<div class="slidershow2 middle2">
				<div class="slides">
					<input type="radio" name="r" id="ra1" checked>
					<input type="radio" name="r" id="ra2">
					<input type="radio" name="r" id="ra3">
					<input type="radio" name="r" id="ra4">
					<div class="slide s2">
						<img src="../common/images/sports.jpg" alt="">
					</div>
					<div class="slide">
						<img src="../common/images/run.jpg" alt="">
					</div>
					<div class="slide">
						<img src="../common/images/sports3.jpg" alt="">
					</div>
					<div class="slide">
						<img src="../common/images/sports4.jpg" alt="">
					</div>
				</div>
				<div class="navigation">
					<label for="ra1" class="bar"></label>
					<label for="ra2" class="bar"></label>
					<label for="ra3" class="bar"></label>
					<label for="ra4" class="bar"></label>
				</div>
			</div>

		</section>
	</main>
	<!-- footer -->
	<footer>
		<aside><i class="iconfont">&#xe50d;</i><span>首页</span></aside>
		<aside><i class="iconfont">&#xe65e;</i><span>课程</span></aside>
		<aside><i class="iconfont">&#xe605;</i><span>训练</span></aside>
		<aside><i class="iconfont">&#xe804;</i><span>我的</span></aside>
	</footer>
	
</div>
</template>

<script>
export default {
	name:"home",
	data(){
		return {

		}
	},
	methods:{
		moreEnvironment(){
			this.$router.push({
				name:'environment',
			})
		},
		moreSports(){
			this.$router.push({
				name:'sports',
			})
		}
	}

}
</script>

