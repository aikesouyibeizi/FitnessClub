<template>
    <div class="modifyMember">
    	<!-- Header -->
		<mt-header fixed title="会员名单管理">
		  <router-link :to="{path:'managerHome'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		  <mt-button icon="more" slot="right" @click="save"></mt-button>
		</mt-header>
        <!-- content -->
        <div class="content">
			<div class="title">
				<span>ID编号</span>
				<input type="text"  v-model="memberId">
			</div>
			<div class="title">
				<span>名称</span>
				<input type="text"  v-model="memberName">
			</div>
			<div class="title">
				<span>密码</span>
				<input type="text"  v-model="memberPassword">
			</div>
		</div>
    </div>
</template>
<style>
@import "../../common/css/manager/modifyMember.css";
</style>
<script>
export default {
    name:"ModifyManager",
    data(){
        return {
            memberId:'',
            memberName:'',
            memberPassword:'',
        }
    },
    mounted:function(){
        this.member=JSON.parse(localStorage.getItem("member"));
        this.memberId = this.member.memberId;
        this.$http.get("http://localhost:8088"+"/member/findMemberById",{
            params:{
                id:this.memberId
            }
        }).then(response=>{
            console.log(response);
            const req = response.body.date;
            this.memberName = req.memberName;
			this.memberPassword = req.memberPassword;
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
                }
            }).then(response=>{
                console.log(response);
                if(response.body.code==200){
                    this.$message({
                        message:"密码修改成功",
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