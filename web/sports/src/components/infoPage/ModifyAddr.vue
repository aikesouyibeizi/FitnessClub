<template>
    <div class="modifyAddr">
        <!-- Header -->
		<mt-header fixed title="修改地址">
		  <router-link to="/" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		  <mt-button icon="more" slot="right" @click="save"></mt-button>
		</mt-header>
        <!-- Content -->
        <div class="content">
			<div class="title">
				<span>收货人</span>
				<input type="text"  :value="memberName">
			</div>
			<div class="title">
				<span>手机号</span>
				<input type="text"  :value="memberTel">
			</div>
			<div class="title">
				<span>省</span>
				<input type="text"  :value="addrProvince">
			</div>
			<div class="title">
				<span>市</span>
				<input type="text"  v-model="addrCity">
			</div>
			<div class="title">
				<span>区</span>
				<input type="text"  v-model="addrCounty">
			</div>
			<div class="title">
				<span>详细地址</span>
				<input type="text"  v-model="addrDetail">	
			</div>
			<div class="title">
				<span>邮政编号</span>
				<input type="text"  v-model="addrCode">
			</div>
			
		</div>
    </div>
</template>
<style>
@import "../../common/css/infoPage/modifyAddr.css";
@import "../../common/iconfont/iconfont.css";
</style>
<script>
export default {
    name:"ModifyAddr",
    data(){
			return {
                addrId:'',
				memberName:'',
				memberTel:'',
				addrProvince:'',
				addrCity:'',
				addrCounty:'',
				addrDetail:'',
				addrCode:'',
			}
        },
    mounted:function(){
        this.addrId = this.$route.params.id;
        var that = this;
		that.$http.get("http://localhost:8088/member/findAddrById",{
			params:{
				id:this.addrId,
			}
		}).then(response=>{
			var req = response.body.date;
			this.memberName = req.memberName;
			this.memberTel = req.memberTel;
			this.addrProvince = req.addrProvince;
			this.addrCity = req.addrCity;
			this.addrCounty = req.addrCounty;
			this.addrDetail = req.addrDetail;
			this.addrCode = req.addrCode;
		}).catch(error=>{
			console.log(error);
		});
    },
    methods:{
    	save(){
				var that = this;
				that.$http.get("http://localhost:8088"+"/member/updateAddr",{
					params:{
						memberName:this.memberName,
						memberTel:this.memberTel,
						addrProvince:this.addrProvince,
						addrCity:this.addrCity,
						addrCounty:this.addrCounty,
						addrDetail:this.addrDetail,
						addrCode:this.addrCode
					}
				}).then(response=>{
					console.log(response);
					if (response.body.code == 200) {
						// localStorage.setItem('member',JSON.stringify(response.body.date));
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