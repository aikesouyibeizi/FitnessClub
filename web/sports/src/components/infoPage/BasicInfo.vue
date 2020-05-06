<template>
	<div class="basicInfo">
		<!-- Header -->
		<mt-header fixed title="个人资料">
		  <router-link to="/" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		  <mt-button icon="more" slot="right" @click="save"></mt-button>
		</mt-header>
		<!-- Content -->
		<div class="content">
			<div class="title">
				<span>名字</span>
				<input type="text"  v-model="memberName">
			</div>
			<div class="title">
				<span>密码</span>
				<input type="password"  v-model="memberPassword">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>个性签名</span>
				<input type="text"  v-model="memberDesc">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>电话号码</span>
				<input type="text"  v-model="memberTel">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>邮箱</span>
				<input type="text"  v-model="memberEmail">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>地址</span>
				<input type="text"  v-model="memberAddr">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			
			<div class="title">
				<span>性别</span>
				<input type="text"  v-model="memberGender">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>年龄</span>
				<input type="text"  v-model="memberAge">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>身高</span>
				<input type="text"  v-model="memberHeight">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>目前体重</span>
				<input type="text"  v-model="memberWeight">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
			<div class="title">
				<span>目标体重</span>
				<input type="text" v-model="memberGoal">
  				<!-- <i class="iconfont">&#xe68d;</i>	 -->
			</div>
		</div>

	</div>
</template>
<style>
@import '../../common/css/infoPage/basicInfo.css';
</style>
<script>
	export default{
		data(){
			return {
				memberId:'',
				memberName:'',
				memberPassword:'',
				memberDesc:'',
				memberTel:'',
				memberEmail:'',
				memberAddr:'',
				memberGender:'',
				memberAge:'',
				memberHeight:'',
				memberWeight:'',
				memberGoal:'',
				member:{}
			}
		},
		mounted:function(){
			this.member=JSON.parse(localStorage.getItem("member"));
			this.memberId = this.member.memberId;
			this.memberName = this.member.memberName;
			this.memberPassword = this.member.memberPassword;
			this.memberDesc = this.member.memberDesc;
			this.memberTel = this.member.memberTel;
			this.memberEmail = this.member.memberEmail;
			this.memberAddr = this.member.memberAddr;
			this.memberGender = this.member.memberGender;
			this.memberAge = this.member.memberAge;
			this.memberHeight = this.member.memberHeight;
			this.memberWeight = this.member.memberWeight;
			this.memberGoal = this.member.memberGoal;
		},
		methods:{
			save(){
				var that = this;
				that.$http.get("http://localhost:8088"+"/member/updateMember",{
					params:{
						memberId:this.memberId,
						memberName:this.memberName,
						memberPassword:this.memberPassword,
						memberDesc:this.memberDesc,
						memberTel:this.memberTel,
						memberEmail:this.memberEmail,
						memberAddr:this.memberAddr,
						memberGender:this.memberGender,
						memberAge:this.memberAge,
						memberHeight:this.memberHeight,
						memberWeight:this.memberWeight,
						memberGoal:this.memberGoal
					}
				}).then(response=>{
					console.log(response);
					if (response.body.code == 200) {
						localStorage.setItem('member',JSON.stringify(response.body.date));
						// that.$router.push({
						// 	path:""
						// });
					}else if (response.body.code == 500) {

					}
				}).catch(error=>{
					console.log(error);
				});
			}
		}

	}
</script>