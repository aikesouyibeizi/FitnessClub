<template>
  <div class="loginBox">
    <a-spin tip="登录中..." :spinning="isLoading" style="height:100%;">
      <div class="header">
        <h4>欢迎登录RUN</h4>
      </div>
      <div class="main">
        <!-- <div v-if="type===2">
          <div class="inpBox">
            <input type="text" placeholder="手机号码" v-model="account" />
          </div>
          <div class="inpBox">
            <input type="text" placeholder="短信验证码" class="short" v-model="password" />
            <a href="javascript:;" @click="sendCode">{{isRun?`${runTime}s后重新获取`:`获取验证码`}}</a>
          </div>
        </div> -->

        <!-- <div v-if="type===2"> -->
        <div>
          <div class="inpBox">
            <input type="text" placeholder="用户名/手机号码" v-model="id" />
          </div>
          <div class="inpBox">
            <input type="password" placeholder="密码" v-model="password" />
          </div>
        </div>

        <button class="submit" @click="loginHandle">立即登录</button>
        <!-- <span class="changeBtn" @click="changeType">{{type===1?'短信验证码登录':'用户名密码登录'}}</span> -->
      </div>

      <div class="register">
        <router-link to="/register">立即注册</router-link>|
        <a>忘记密码</a>
      </div>

      <div class="other">
        <span>其他登录方式</span>
        <div>
          <a></a>
          <a></a>
          <a></a>
        </div>
      </div>
    </a-spin>
  </div>
</template>

<script>
import axios from 'axios';
import {
		Toast
	} from 'mint-ui';
import {
		Spinner
	} from 'mint-ui';


export default {
  data() {
    return {
      id: "",
      password: "",
      isLoading: false,
    };
  },

  methods: {
    
    
    async loginHandle() {
      var that = this;

      // if (!that.id) {
			// 		that.$message.error('请输入用户ID');
			// 		return;
			// 	}
			// 	if (!that.password) {
			// 		that.$message.error('请输入密码');
			// 		return;
			// 	}

      window.alert(that.id);
      let id = that.id;
      let password = that.password;
      console.log("id:"+id);
      console.log("password:"+password);
      console.log("========"+axios);



      that.$http.get('http://localhost:8088' + '/member/loginByPassword', {
					params: {
						id: that.id,
						password: that.password
					}
				}).then(function(response) {
          console.log("response：", response);
          const req = response.body;
					if (response.body.code == 200) {
            console.log("这里是200",req)

              localStorage.setItem("member",JSON.stringify(req.date));
              if(req.date.roleId==1){
                that.$router.push({
                  path: '/managerHome'
                });
              }else if(req.date.roleId==2){
                that.$router.push({
                    path: '/coachHome'
                });
              }else{
                that.$router.push({
                    path: '/home'
                });
              }			
              // that.isLoading = false;         
              // console.log("这里是插入数据后的$myStore",that.$myStore);
              // window.location.href="/personal";
					} else if (response.body.code == 500) {
						that.isLoading = false;
						// that.$message.error(response.body.message);
					}
				}, function(response) {
          alert(JSON.stringify(response));
          console.log(response);
					that.isLoading = false;
					// that.$message.error('访问服务器失败'); 
				}).catch((error)=>{
            console.log("好了error了")
        });

        


    }
  }
};
</script>

<style>
@import "../common/css/login3.css";
</style>

