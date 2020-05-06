<template>
    <div class="modifyMember">
    	<!-- Header -->
		<mt-header fixed title="会员名单管理">
		  <router-link :to="{path:'modifyCoachList'}" slot="left">
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
				<span>邮箱</span>
				<input type="text"  v-model="memberEmail">
			</div>
			<div class="title">
				<span>授课名称</span>
				<input type="text"  v-model="coachCourseName">
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
				<span>教龄</span>
				<input type="text"  v-model="coachAge">
			</div>
		</div>
    </div>
</template>
<style>
@import "../../common/css/manager/modifyMember.css";
</style>
<script>
export default {
    name:"ModifyCoach",
    data(){
        return {
            memberId:'',
            memberName:'',
            memberPassword:'',
            memberEmail:'',
            coachCourseName:'',
            memberGender:'',
            memberAge:'',
            coachAge:''
            
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
			this.memberEmail = req.memberEmail;
			this.coachCourseName = req.coachCourseName;
			this.memberGender = req.memberGender;
			this.memberAge = req.memberAge;
			this.coachAge = req.coachAge;
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
                    memberEmail:this.memberEmail,
                    coachCourseName:this.coachCourseName,
                    memberGender:this.memberGender,
                    memberAge:this.memberAge,
                    coachAge:this.coachAge,
                }
            }).then(response=>{
                console.log(response);
                if(response.body.code==200){
                    this.$message({
                        message:"教练修改成功",
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