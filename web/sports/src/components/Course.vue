<template>
    <div class="course">
		<div class="header">
			<div>训练课程</div>
		</div>
		<div class="content">
			<div class="courseList" v-for="item in courses" :key="item.courseId" @click="toCourseDetail(item.courseId)">
				<div class="char">
					<div class="logo">
						<img src="../common/images/logo.png" alt="logo">
						<span>RUN超级超级营</span>
					</div>
					<div class="title">
						{{item.courseName}}
					</div>
					<div class="detail">
						{{item.courseDesc}}
					</div>
					<div class="price">
						<i class="iconfont">&#xe601;</i>
						<span>{{item.coursePrice}}</span>
					</div>
				</div>
				<div class="img">
					<img :src=item.courseImg alt="course1">
					<!-- <img src="../common/images/course1.png" alt="course1">
					<img src="../common/images/course2.png" alt="course1">
					<img src="../common/images/course3.png" alt="course1"> -->

				</div>
			</div>	
		</div>
	</div>
</template>
<style scoped>
@import "../common/css/course.css";
@import "../common/iconfont/iconfont.css";
</style>
<script>
export default {
	name:"Course",
	data(){
		return {
			courseId:'',
			courses:[]
		}
	},
	mounted:function(){
		var that = this;
		that.$http.get("http://localhost:8088/course/findAllCourses")
		.then(response=>{
			console.log(response);
			var req = response.body.date;
			if(response.body.code==200){
				this.courses = req;
				this.courseId = req.courseId;
			}else{

			}
		}).catch(error=>{
			console.log(error);
		})
	},
	methods:{
		toCourseDetail(id){
			this.$router.push({
				name:'courseDetail',
				params:{
					id:id,
				}
			})
		}
	}
}
</script>