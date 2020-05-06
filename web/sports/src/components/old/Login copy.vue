<template>
  <div class="loginBox">
    <div class="header">
      <h4>欢迎登录RUN</h4>
    </div>
    <div class="main">
      <div v-if="type===2">
        <div class="inpBox">
          <input type="text" placeholder="手机号码" v-model="account" />
        </div>
        <div class="inpBox">
          <input type="text" placeholder="短信验证码" class="short" v-model="password" />
          <a href="javascript:;" @click="sendCode">{{isRun?`${runTime}s后重新获取`:`获取验证码`}}</a>
        </div>
      </div>

      <div v-if="type===1">
        <div class="inpBox">
          <input type="text" placeholder="用户名/手机号码" v-model="account" />
        </div>
        <div class="inpBox">
          <input type="password" placeholder="密码" v-model="password" />
        </div>
      </div>

      <button class="submit" @click="loginHandle">立即登录</button>
      <span class="changeBtn" @click="changeType">{{type===1?'短信验证码登录':'用户名密码登录'}}</span>
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
  </div>
</template>

<script>
export default {
  data() {
    return {
      type: 2,
      account: "",
      password: "",
      isRun: false,
      runTime: 30
    };
  },
  methods: {
    changeType() {
      this.type = this.type === 2 ? 1 : 2;
      this.account = "";
      this.password = "";
    },
    async sendCode() {
      if (this.isRun) return;
      //=>防止不必要的服务器请求 + 防止XSS攻击（输入恶意的JS或者SQL脚本）
      if (!/^1\d{10}$/.test(this.account)) {
        window.alert("请保证手机号码正确~~");
        return;
      }
      //=>验证手机号是否被注册
      let data = await this.$api.personal.phone(this.account);
      if (parseInt(data.code) !== 0) {
        window.alert("手机号码没有注册，请先注册~~");
        return;
      }
      //=>通知服务器发送验证码
      data = await this.$api.personal.code(this.account);
      if (parseInt(data.code) === 1) {
        window.alert("当前网络繁忙，请稍后再试~~");
        return;
      }
      //=>开启倒计时
      this.isRun = true;
      this.autoTimer = setInterval(() => {
        if (this.runTime === 0) {
          this.runTime = 30;
          this.isRun = false;
          clearInterval(this.autoTimer);
          return;
        }
        this.runTime--;
      }, 1000);
    },
    async loginHandle() {
      //=>分情况
      //=>表单校验
      //=>校验验证码正确性
      let data = await this.$api.personal.checkCode(
        this.account,
        this.password
      );
      if (parseInt(data.code) !== 0) {
        window.alert("验证码不正确~~");
        return;
      }
      data = await this.$api.personal.loginPOST(
        this.account,
        this.password,
        this.type
      );
      if (parseInt(data.code) !== 0) {
        window.alert("登录失败~~");
        return;
      }
      window.alert("登录成功~~", {
        handled: () => {
          this.$router.push("/");
        }
      });
    }
  }
};
</script>

<style>
@import "../common/css/login3.css";
</style>

