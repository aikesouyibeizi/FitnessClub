<template>
    <div class="addMember">
    	<!-- Header -->
		<mt-header fixed title="添加会员">
		  <router-link :to="{path:'managerHome'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
        <el-form :model="courseForm" :rules="rules" ref="courseForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="课程编号" prop="courseId">
                <el-input v-model="courseForm.courseId"></el-input>
            </el-form-item>
            <el-form-item label="课程名称" prop="courseName">
                <el-input v-model="courseForm.courseName"></el-input>
            </el-form-item>        
            <el-form-item label="课程价格" prop="coursePrice">
                <el-input v-model="courseForm.coursePrice"></el-input>
            </el-form-item>
             <el-form-item label="课程描述" prop="courseDesc">
                <el-input type="textarea" v-model="courseForm.courseDesc"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm">提交</el-button>
                <el-button @click="resetForm()">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>
<style>
@import "../../common/css/manager/addmember.css";
</style>
<script>
export default {
    name:"AddCourse",
    data(){
        return {
            courseForm:{
                courseId:'',
                courseName:'',
                coursePrice:'',
                courseDesc:'',
            },
            rules: {
                courseId: [
                    { required: true, message: '课程编号不能为空', trigger: 'blur' },
                ],
                courseName: [
                    { required: true, message: '课程名不能为空', trigger: 'blur' },
                    { min: 2, max: 10, message: '长度为2到10个字符', trigger: 'blur' }
                ],
                coursePrice: [
                    { required: true, message: '课程价格不能为空', trigger: 'blur' },
                ],
                courseDesc: [
                    { required: true, message: '课程描述', trigger: 'change' }
                ]
            },
            
        }  
    },
    methods:{
         submitForm() {
             var that = this;
            var courseForm = this.courseForm
            console.log("this.courseForm",this.courseForm);
            this.$http( {    
                method:'post',
                url:"http://localhost:8088/course/saveCourse",
                body:{
                        "courseId":courseForm.courseId,
                        "courseName":courseForm.courseId,
                        "coursePrice":courseForm.courseId,
                        "courseDesc":courseForm.courseId,
                    }
                }).then(response=>{
                console.log(response);
                if(response.body.code==200){
                    this.$message({
                        message:"课程添加成功",
                        type:'success',
                        center:true
                    });
                    setTimeout(function(){
                        that.resetForm();
                    },3000)
                }else{
                      this.$message({
                        message:response.body.message,
                        type:'error',
                        center:true
                    });
                }
            })
        },
        resetForm(){
            this.courseForm={}
        }
    }
}
</script>