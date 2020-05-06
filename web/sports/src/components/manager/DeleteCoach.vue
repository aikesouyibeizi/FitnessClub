<template>
    <div class="deleteMember">
    	<!-- Header -->
		<mt-header fixed title="会员名单管理">
		  <router-link :to="{path:'managerHome'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
		<div class="main">
			<div class="title">
				<ul>
					<li>教练编号</li>
					<li>姓名</li>
					<li>教龄</li>
					<li>授课名称</li>
					<li>操作</li>
				</ul>
			</div>
			<div class="content">
				<ul v-for="(item,index) in coachs" :key="index">
					<li>{{item.memberId}}</li>
					<li>{{item.memberName}}</li>
					<li>{{item.memberGender}}</li>
					<li>{{item.coachCourseName}}</li>
					<li @click="deleteMember(item.memberId)">删除</li>
				</ul>
			</div>
		</div>
    </div>
</template>
<style>
@import "../../common/css/manager/deleteMember.css";
</style>
<script>
export default {
    name:"DeleteCoach",
    data(){
        return {
            coachs:[]
        }
    },
    mounted:function(){
        var that = this;
        that.$http.get("http://localhost:8088/member/findAllMemberByRole",{
            params:{
                role:"2"
            }
        }).then(response=>{
            this.coachs = response.body.date;
        }).catch(error=>{
            console.log(error);
        })
    },
    methods:{
        deleteMember(id){
             var that = this;
             this.$http.get("http://localhost:8088/member/deleteMemberById",{
                 params:{
                     id:id
                 }
             }).then(response=>{
                 if(response.body.code==200){
                    that.$http.get("http://localhost:8088/member/findAllMemberByRole",{
                        params:{
                            role:"2"
                        }
                    }).then(response=>{
                        this.coachs = response.body.date;
                    })
                }
            }).catch(error=>{
                console.log(error);
            })
        }
    }
}
</script>