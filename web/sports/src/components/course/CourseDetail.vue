<template>
    <div class="courseDetail">
    	<!-- Header -->
    	<mt-header fixed title="超级减脂营">
		  <router-link :to="{path:'course'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
    	<div class="content">
    		<div class="title">
				<img src="../../common/images/logo.png" alt="logo">
				<span>RUN超级超级营</span>
    		</div>
    		<div class="poster">
    			<div class="name">
    				{{courseName}}
    			</div>
    			<div class="pointer">
    				教练一对一，有健康食谱书籍赠送
    			</div>
    			<div class="desc">
    				{{courseDesc}}
    			</div>
    			<div class="img">
    				<!-- <img src="../../common/images/course1.png" alt=""> -->
    				<img :src=courseImg alt="">
    			</div>
    			
    		</div>
    	</div>
    	<!-- Footer -->
    	<div class="footer">
    		<mt-button type="primary" size="large" @click="buy">立即购买</mt-button>
    	</div>
    </div>
</template>
<style>
@import "../../common/css/course/courseDetail.css";
</style>
<script>
export default {
    name:"courseDetail",
    data(){
        return {
            courseId:'',
            courseImg:'',
            courseDesc:'',
            courseName:'',
            memberId:'',
            memberPrice:'',
        }
    },
    created:function(){
        this.courseId = this.$route.params.id;
        
        var that = this;
        that.$http.get("http://localhost:8088/course/findCourseById",{
            params:{
                id:this.courseId
            }
        }).then(response=>{
            console.log(response);
            var req = response.body.date;
            this.courseId = req.courseId;
            this.courseName = req.courseName;
            this.courseDesc = req.courseDesc;
            this.courseImg = req.courseImg;
            this.coursePrice = req.coursePrice;
        }).error(error=>{
            console.log(error);
        });
    },
    mounted:function(){
        

    },
    methods:{
        buy(){

            this.$router.push({
                name:"orderComfirm",
                params:{
                    courseId:this.courseId,

                }
            })
            
        }
    }
} 
</script>