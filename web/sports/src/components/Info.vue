<template>
<div class="personalBox">
  <!-- Header -->
    <div class="header">
      <div class="pic" @click="upLoad">
        <!-- <img src alt /> -->
        <input
          type="file"
          accept="image/*"  
          @change="changeImage($event)"
          ref="avatarInput"
          style="display:none; width: 100%;height: 100%;"
       >
       <!-- 隐藏原生控件 -->
       <div class="pic_list_box">
          <!-- <div class="pic_list" v-show="imgDatas.length"> -->
          <div class="pic_list" v-show="personalImg!=''">
            <!-- <div v-for="(src,index) in imgDatas" :key="index"> -->
            <div >
              <img :src="personalImg" width="120" height="120" alt srcset>
            </div>
          </div>
          <!-- <img class="upload_btn" v-show="imgDatas.length!=3"  @click="upLoad" src="../common/images/logo.png" alt> -->
        </div>


      </div>
      <!-- <p class="account" @click="goLogin">{{memberName}}</p> -->
       <router-link class="account" :to="{path:'basicInfo'}">{{memberName}}</router-link>
    </div>

    <!-- 四个图标 -->
    <div class="orderIcon"> 
      <router-link class="item" :to="{path:'weightChart'}">
        <i class="iconfont">&#xe7b5;</i>
        <span>训练记录</span>
      </router-link>
      <router-link class="item" :to="{path:'weightChart'}">
        <i class="iconfont">&#xe8da;</i>
        <span>体重记录</span>
      </router-link>
      <router-link class="item" :to="{path:'imgList'}">
        <i class="iconfont">&#xe61b;</i>
        <span >健身相册</span>
      </router-link>
      <router-link class="item" :to="{path:'orderList'}">
        <i class="iconfont">&#xe604;</i>
        <span>我的订单</span>
      </router-link>
    </div>

  <!-- content -->
   <div class="content">
    <router-link class="title" :to="{path:'faq'}">
      <i class="iconfont">&#xe63c;</i>
      <span>我的预约</span>
      <i class="iconfont">&#xe68d;</i>
    </router-link>      
    <router-link class="title" :to="{path:'faq'}">
      <i class="iconfont">&#xe502;</i>
      <span>健身常见问题</span>
      <i class="iconfont">&#xe68d;</i>
    </router-link>      
    <router-link class="title" :to="{path:'basicInfo'}">
      <i class="iconfont">&#xe6e0;</i>
      <span>我的基本资料</span>
      <i class="iconfont">&#xe68d;</i>
    </router-link>
    <router-link class="title" :to="{path:'addr'}">
      <i class="iconfont">&#xe609;</i>
      <span>地址管理</span>
      <i class="iconfont">&#xe68d;</i>
    </router-link>
   </div>
    <router-link class="singoutBtn" :to="{path:'login'}">退出登录</router-link>
  </div>
</template>

<script>
import Tip from "./Tip.vue";
export default {
  components: {
    Tip
  },

  data() {
    return {
      orderIconList: ["待付款", "待收货", "待评价", "退款/售后"],
      memberName:'',
      member:{},
      imgDatas:[],
      personalImg:''
    };
  },
  mounted:function(){
    this.member = JSON.parse(localStorage.getItem("member"));
    this.personalImg = localStorage.getItem("personalImg");
    this.memberName = this.member.memberName;
  },
  methods:{

    // 上传图片事件
    changeImage(e) {
      // 获取file input的File对象（数组）
      var files = this.$refs.avatarInput.files;
      var that = this;
      function readAndPreview(file) {
        console.log("file",file);
        //Make sure `file.name` matches our extensions criteria
        //匹配以.jpg .jpeg .png .gif其中一个结尾的文件 
        if (/\.(jpe?g|png|gif)$/i.test(file.name)) {
          var reader = new FileReader();
          //onload方法表示文件成功读取后
          reader.onload = function(e) {
            that.personalImg = this.result;
            localStorage.setItem("personalImg",that.personalImg);
            console.log("zaihoumian")

          };
          reader.readAsDataURL(file);
        }
      }
      if (files) {
        [].forEach.call(files, readAndPreview);
      }
      if (files.length === 0) {
        return;
      }
    },
    upLoad() {
      // 触发上传图片按钮
      this.$refs.avatarInput.dispatchEvent(new MouseEvent("click"));
    }
  }
};
</script>

<style>
@import "../common/css/Info.css";
@import "../common/iconfont/iconfont.css";
.personalBox .pic_list_box {
  display: flex;
  height: 100%;
}
.personalBox .pic_list_box .upload_btn {
  width: 80px;
  height: 80px;
  padding-left: 15px;
}
.personalBox .pic_list_box .pic_list {
  display: flex;
}
.personalBox .pic_list_box .pic_list img {
  /* width: 80px;
  height: 80px; */
  /*padding-left: 15px;
  padding-bottom: 10px;*/
}
</style>