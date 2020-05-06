<template>
    <div class="addMember">
    	<!-- Header -->
		<mt-header fixed title="添加会员">
		  <router-link :to="{path:'managerHome'}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
        <el-form :model="memberForm" :rules="rules" ref="memberForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="会员号" prop="memberId">
                <el-input v-model="memberForm.memberId"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="memberName">
                <el-input v-model="memberForm.memberName"></el-input>
            </el-form-item>
             <el-form-item label="密码" prop="memberPassword">
                <el-input v-model="memberForm.memberPassword" show-password></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="memberGender">
                 <el-radio-group v-model="memberForm.memberGender">
                    <el-radio  label="男"></el-radio>
                    <el-radio  label="女"></el-radio>
                 </el-radio-group>
            </el-form-item>
            <el-form-item label="邮箱" prop="memberEmail">
                <el-input v-model="memberForm.memberEmail"></el-input>
            </el-form-item>
            <el-form-item label="电话号码" prop="memberTel">
                <el-input v-model="memberForm.memberTel"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <!-- <el-cascader v-model="memberForm.memberAddr" :options="options" clearable></el-cascader> -->
                <el-cascader
                    size="large"
                    :options="options"
                    v-model="selectedOptions"
                    @change="handleChange" clearable>
                </el-cascader>
            </el-form-item>
            <el-form-item label="年龄" prop="memberAge">
                <el-input v-model="memberForm.memberAge"></el-input>
            </el-form-item>
            <el-form-item label="角色" prop="roleId">
                <el-input v-model="memberForm.roleId"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm">提交</el-button>
                <el-button @click="resetForm()">重置</el-button>
            </el-form-item>
        </el-form>




        <!-- <div class="content">
        	<div class="inpBox">
        		<span class="name">学号</span>
        		<input type="text" placeholder="学号" v-model="memberId" >
        	</div>
        	<div class="inpBox">
        		<span class="name">姓名</span>
        		<input type="text" placeholder="姓名" v-model="memberName" >
        	</div>
        	<div class="inpBox">
        		<span class="name">密码</span>
        		<input type="password" placeholder="密码" v-model="memberPassword" >
        	</div>
        	<div class="inpBox">
        		<span class="name">性别</span>
        		男<input type="radio" name="gender" value="1" checked="true"  placeholder="gender" v-model="memberGender" >
        		女<input type="radio" name="gender" value="2"  placeholder="gender" v-model="memberGender" >
        	</div>
        	<div class="inpBox">
        		<span class="name">邮箱</span>
        		<input type="text" placeholder="email" v-model="memberEmail" >
        	</div>
        	<div class="inpBox">
        		<span class="name">电话</span>
        		<input type="text" placeholder="电话" v-model="memberTel" >
        	</div>
        	<div class="inpBox">
        		<span class="name">地址</span>
        		<input type="text" placeholder="地址" v-model="memberAddr" >
        	</div>
        	<div class="inpBox">
        		<span class="name">年龄</span>
        		<input type="text" placeholder="年龄" v-model="memberAge" >
        	</div>
        	<div class="inpBox">
        		<span class="name">角色</span>
        		<input type="text" placeholder="角色" v-model="roleId" >
        	</div>
        </div> -->
    </div>
</template>
<style>
@import "../../common/css/manager/addmember.css";
</style>
<script>
// import axios from "axios";
import { regionData } from 'element-china-area-data';
import { CodeToText } from 'element-china-area-data'
import { validateEmail } from "../../common/js/validate.js";
import { validateTel } from "../../common/js/validate.js";
const validateEmail2 = (rule,value,callback)=>{
    if(!value){
        return callback(new Error("邮箱不能为空"));
    }else{
        if(validateEmail(value)){
            callback();
        }else{
            return callback(new Error('邮箱格式不正确'))
        }
    }
};
const validateTel2 = (rule,value,callback)=>{
    if(!value){
        return callback(new Error("电话号码不能为空"));
    }else{
        if(validateTel(value)){
            callback();
        }else{
            return callback(new Error('电话号码格式不正确'))
        }
    }
};
export default {
    name:"AddMember",
    data(){
        return {
            memberForm:{
                memberId:'',
                memberName:'',
                memberPassword:'',
                memberGender:'男',
                memberEmail:'',
                memberTel:'',
                memberAddr:'',
                memberAge:'',
                roleId:''
            },
            options: regionData,
            CodeToText,
            selectedOptions:[],
            rules: {
                memberId: [
                    { required: true, message: '会员号不能为空', trigger: 'blur' },
                    { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
                ],
                memberName: [
                    { required: true, message: '姓名不能为空', trigger: 'blur' },
                    { min: 2, max: 10, message: '长度为2到10个字符', trigger: 'blur' }
                ],
                memberPassword: [
                    { required: true, message: '密码不能为空', trigger: 'blur' },
                    { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
                ],
                memberGender: [
                    { required: true, message: '请选择性别', trigger: 'change' }
                ],
                memberEmail: [
                    { required: true, message: '邮箱不能为空', trigger: 'blur' },
                    { required: true, validator: validateEmail2, trigger: 'blur' }
                ],
                memberTel: [
                    { required: true, message: '电话号码不能为空', trigger: 'blur' },
                    { required: true, validator: validateTel2, trigger: 'blur' }
                ],
                memberAge: [
                    { required: true, message: '年龄不能为空', trigger: 'blur' },
                ],
                roleId:[
                    { required: true, message: '角色ID不能为空', trigger: 'blur' },
                ],

            },
            
        }  
    },
    methods:{
        handleChange (value) {
            console.log(value);
            console.log('' + this.CodeToText[value[0]]+this.CodeToText[value[1]]+this.CodeToText[value[2]]);
            this.memberForm.memberAddr = '' + this.CodeToText[value[0]]+this.CodeToText[value[1]]+this.CodeToText[value[2]];
        },
         submitForm() {
            var memberForm = this.memberForm
            var that = this;
            console.log("this.memberForm",this.memberForm);
            this.$http( {    
                method:'post',
                url:"http://localhost:8088/member/saveMember",
                body:{
                        "memberId":memberForm.memberId,
                        "memberName":memberForm.memberName,
                        "memberPassword":memberForm.memberPassword,
                        "memberGender":memberForm.memberGender,
                        "memberEmail":memberForm.memberEmail,
                        "memberTel":memberForm.memberTel,
                        "memberAddr":memberForm.memberAddr,
                        "memberAge":memberForm.memberAge,
                        "roleId":memberForm.roleId
                    }
                }).then(response=>{
                    console.log(response);
                    if(response.body.code==200){
                        this.$message({
                            message:"会员添加成功",
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
            this.memberForm={ memberGender:'男',}
        }
    }
}
</script>