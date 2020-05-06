<template>
    <div class="modifyMember">
    	<!-- Header -->
		<mt-header fixed title="会员名单管理">
		  <router-link :to="{path:'modifyCourseList'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		  <mt-button icon="more" slot="right" @click="save"></mt-button>
		</mt-header>
        <!-- content -->
        <div class="content">
			<div class="title">
				<span>课程编号</span>
				<input type="text"  v-model="courseId">
			</div>
			<div class="title">
				<span>课程名称</span>
				<input type="text"  v-model="courseName">
			</div>
			<div class="title">
				<span>课程价格</span>
				<input type="text"  v-model="coursePrice">
			</div>
			<div class="title">
				<span>课程描述</span>
				<input type="text"  v-model="courseDesc">
			</div>
		</div>
    </div>
</template>
<style>
@import "../../common/css/manager/modifyMember.css";
</style>
<script>
export default {
    name:"ModifyCourse",
    data(){
        return {
            courseId:'',
            courseName:'',
            coursePrice:'',
            courseDesc:'',
        }
    },
    mounted:function(){
        this.courseId = this.$route.params.id;
        this.$http.get("http://localhost:8088"+"/course/findCourseById",{
            params:{
                id:this.courseId
            }
        }).then(response=>{
            console.log(response);
            const req = response.body.date;
            this.courseId = req.courseId;
			this.courseName = req.courseName;
			this.coursePrice = req.coursePrice;
			this.courseDesc = req.courseDesc;
        })
    },
    methods:{
        save(){
            var that = this;
            that.$http.get("http://localhost:8088"+"/course/updateCourse",{
                params:{
                    courseId:this.courseId,
                    courseName:this.courseName,
                    coursePrice:this.coursePrice,
                    courseDesc:this.courseDesc,
                }
            }).then(response=>{
                console.log(response);
                if(response.body.code==200){
                    this.$message({
                        message:"课程修改成功",
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