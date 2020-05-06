<template>
	<div class="answer">
		<!-- Header -->
        <mt-header fixed title="问题解答">
		  <router-link :to="{path:'faq'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
		<div class="content">
			<div class="title" style="font-weight:700;">
				{{titles}}
			</div>
			<img :src=imgs alt="图片">
			<!-- <img src="../../common/images/infoPage/Q1.jpg" alt="图片">
			<img src="../../common/images/infoPage/Q2.jpg" alt="图片">
			<img src="../../common/images/infoPage/Q3.jpg" alt="图片">
			<img src="../../common/images/infoPage/Q4.jpg" alt="图片">
			<img src="../../common/images/infoPage/Q5.jpg" alt="图片">
			<img src="../../common/images/infoPage/Q6.jpg" alt="图片">
			<img src="../../common/images/infoPage/Q8.jpg" alt="图片">
			<img src="../../common/images/infoPage/Q9.jpg" alt="图片"> -->
			
			<div class="desc">
				{{descs}}
			</div>
		</div>
	</div>
</template>
<style>
@import '../../common/css/infoPage/answer.css';
</style>
<script>
export default {
	name:"Answer",
	data(){
		return {
			ids:'',
			titles:'',
			descs:'',
			imgs:''
		}
	},
	mounted:function(){
		this.ids = this.$route.params.id;
		console.log("ids",this.ids)
		var that = this;
		that.$http.get("http://localhost:8088/member/findQasById",{
			params:{
				id:this.ids,
			}
		}).then(response=>{
			var req = response.body.date;
			this.titles = req.titles;
			this.descs = req.descs;
			this.imgs = req.imgs;
		}).catch(error=>{
			console.log(error);
		});
	}
}
</script>