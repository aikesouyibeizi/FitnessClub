<template>
    <div class="deleteMember">
    	<!-- Header -->
		<mt-header fixed title="课程管理">
		  <router-link :to="{path:'managerHome'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
		<div class="main">
			<div class="title">
				<ul>
					<li>课程编号</li>
					<li>课程名称</li>
					<li>课程价格</li>
					<li>课程描述</li>
					<li>操作</li>
				</ul>
			</div>
			<div class="content">
				<ul v-for="(item,index) in courses" :key="index">
					<li>{{item.courseId}}</li>
					<li>{{item.courseName}}</li>
					<li>{{item.coursePrice}}</li>
					<li>{{item.courseDesc}}</li>
					<li @click="modifyCourse(item.courseId)">修改</li>
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
    name:"ModifyCourseList",
    data(){
        return {
            courses:[]
        }
    },
    mounted:function(){
        var that = this;
        that.$http.get("http://localhost:8088/course/findAllCourses").then(response=>{
            this.courses = response.body.date;
        }).catch(error=>{
            console.log(error);
        })
    },
    methods:{
        modifyCourse(id){
             this.$router.push({
                 name:"modifyCourse",
                 params:{
                     id:id
                 }
             })
        }
    }
}
</script>