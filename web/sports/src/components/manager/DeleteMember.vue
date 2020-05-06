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
					<li>学号</li>
					<li>姓名</li>
					<li>性别</li>
					<li>电话</li>
					<li>操作</li>
				</ul>
			</div>
			<div class="content">
				<ul v-for="(item,index) in members" :key="index">
					<li>{{item.memberId}}</li>
					<li>{{item.memberName}}</li>
					<li>{{item.memberGender}}</li>
					<li>{{item.memberTel}}</li>
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
    name:"DeleteMember",
    data(){
        return {
            members:[]
        }
    },
    mounted:function(){
        var that = this;
        that.$http.get("http://localhost:8088/member/findAllMemberByRole",{
            params:{
                role:"3"
            }
        }).then(response=>{
            this.members = response.body.date;
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
                this.members = response.body.date;
                if(response.body.code==200){
                    that.$http.get("http://localhost:8088/member/findAllMemberByRole",{
                        params:{
                            role:"3"
                        }
                    }).then(response=>{
                        this.members = response.body.date;
                    })
                }
            }).catch(error=>{
                console.log(error);
            })
        }
    }
}
</script>