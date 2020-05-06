<template>
    <div class="modifyMember">
    	<!-- Header -->
		<mt-header fixed title="会员名单管理">
		  <router-link :to="{path:'modifyMemberList'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		  <mt-button icon="more" slot="right" @click="save"></mt-button>
		</mt-header>
        <!-- content -->
        <div class="content">
			<div class="title">
				<span>名字</span>
				<input type="text"  v-model="memberName">
			</div>
			<div class="title">
				<span>密码</span>
				<input type="password"  v-model="memberPassword">
			</div>
			<div class="title">
				<span>个性签名</span>
				<input type="text"  v-model="memberDesc">
			</div>
			<div class="title">
				<span>电话号码</span>
				<input type="text"  v-model="memberTel">
			</div>
			<div class="title">
				<span>邮箱</span>
				<input type="text"  v-model="memberEmail">
			</div>
			<div class="title">
				<span>地址</span>
				<input type="text"  v-model="memberAddr">
			</div>
			
			<div class="title">
				<span>性别</span>
				<input type="text"  v-model="memberGender">
			</div>
			<div class="title">
				<span>年龄</span>
				<input type="text"  v-model="memberAge">
			</div>
			<div class="title">
				<span>身高</span>
				<input type="text"  v-model="memberHeight">
			</div>
			<div class="title">
				<span>目前体重</span>
				<input type="text"  v-model="memberWeight">
			</div>
			<div class="title">
				<span>目标体重</span>
				<input type="text" v-model="memberGoal">
			</div>
		</div>
    </div>
</template>
<style>
@import "../../common/css/manager/modifyMember.css";
</style>
<script>
export default {
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
            
        }
    },
    mounted:function(){
        this.memberId = this.$route.params.id;
        this.$http.get("http://localhost:8088"+"/member/findMemberById",{
            params:{
                id:this.memberId
            }
        }).then(response=>{
            console.log(response);
            const req = response.body.date;
            this.memberName = req.memberName;
			this.memberPassword = req.memberPassword;
			this.memberDesc = req.memberDesc;
			this.memberTel = req.memberTel;
			this.memberEmail = req.memberEmail;
			this.memberAddr = req.memberAddr;
			this.memberGender = req.memberGender;
			this.memberAge = req.memberAge;
			this.memberHeight = req.memberHeight;
			this.memberWeight = req.memberWeight;
			this.memberGoal = req.memberGoal;
        })
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
				 if(response.body.code==200){
                    this.$message({
                        message:"会员修改成功",
                        type:'success',
                        center:true
                    });
                }else{
                      this.$message({
                        message:response.body.message,
                        type:'error',
                        center:true
                    });
                }
                
            }).catch(error=>{
                console.log(error);
            });
        }
    }
}
</script>