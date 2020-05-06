<template>
  <div class="loginBox">
    <div class="header">
      <h4>RUN账号注册</h4>
    </div>

    <div class="main">
      <div class="inpBox">
        <input type="text" placeholder="学号" v-model="memberId" />
      </div>
      <div class="inpBox">
        <input type="text" placeholder="用户名" v-model="memberName" />
      </div>
      <div class="inpBox">
        <input type="text" placeholder="手机号码" v-model="memberTel" />
      </div>
      <!-- <div class="inpBox">
        <input type="text" placeholder="短信验证码" class="short" v-model="code" />
        <a href="javascript:;" @click="sendCode">{{isRun?`${runTime}s后重新获取`:`获取验证码`}}</a>
      </div> -->
      <div class="inpBox">
        <input type="password" placeholder="登录密码" v-model="memberPassword" />
      </div>
      <div class="inpBox">
        <input type="text" placeholder="邮箱" v-model="memberEmail" />
      </div>
      <div class="inpBox">
        <input type="text" placeholder="性别" v-model="memberGender" />
      </div>
      <div class="inpBox">
        <input type="text" placeholder="体重" v-model="memberWeight" />
      </div>
      <div class="inpBox">
        <input type="text" placeholder="身高" v-model="memberHeight" />
      </div>
      <div class="inpBox">
        <input type="text" placeholder="目标体重" v-model="memberGoal" />
      </div>
      <!-- <div class="inpBox">
        <input type="password" placeholder="支付密码" v-model="passwordPay" />
      </div> -->
      <button class="submit" @click="submit">立即注册</button>
      <a class="changeBtn" @click="ret" style="padding:0 0.2rem;">重置</a>  |  
      <router-link to="/login" class="changeBtn" style="padding:0 0.2rem;">已有账号，去登录！</router-link>
    </div>
    <mt-spinner v-show="isLoading" type="fading-circle" color="#0000EE"></mt-spinner>
  </div>
</template>

<script>
import md5 from "blueimp-md5";
import {
		Toast
	} from 'mint-ui';
import {
		Spinner
	} from 'mint-ui';


export default {


  data() {
    return {
      isLoading: false,
      memberId: '', 
      memberName: '', 
      memberTel: '', 
      memberPassword: '', 
      memberEmail: '', 
      memberGender: '', 
      memberWeight: '', 
      memberHeight: '', 
      memberGoal: '', 
    }
  },
  mounted() {
    // this.init();
  },

  methods: {
    ret() {
      console.log("重置");
      this.memberId="";
      this.memberName = "";
      this.memberTel = "";
      this.memberPassword = "";
      this.memberEmail = "";
      this.memberGender = "";
      this.memberWeight = "";
      this.memberHeight = "";
      this.memberGoal = "";
    },
    submit() {
      console.log("提交");
      if(''!=this.memberPassword&&''!=this.memberId){
        this.isLoading = true;
        //这里调用注册接口
        this.$http.get('http://localhost:8088' + '/member/register', {
          params: {
            memberId:this.memberId,
            memberName: this.memberName, //姓名
            memberTel: this.memberTel, //电话
            memberPassword: this.memberPassword, //密码
            memberEmail: this.memberEmail, //邮箱
            memberGender: this.memberGender, //性别
            memberWeight: this.memberWeight, //体重
            memberHeight: this.memberHeight, //身高
            memberGoal: this.memberGoal //目标体重
          }
        }).then(function(response) {
          console.log("response：", response);
          if (response.body.code == 200) {
            this.isLoading = false;
            Toast('注册成功');
            this.$router.go(-1);
          }else{
            console.log("是这里吗1");
            Toast(response.body.message);
          }
          // this.isLoading = false;
        }
        // , function(response) {
        //   this.isLoading = false;
        //     console.log("是这里吗2");
        //   // this.$message.error('访问服务器失败');
        // }
        ).catch(error=>{
          console.log("这里是error");
        });
        this.isLoading = false;
      }
    },

  },

};
</script>
<style>
@import "../common/css/login3.css";
</style>