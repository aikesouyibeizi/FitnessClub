<template>
    <div class="imgList">
      <!-- Header -->
  		<mt-header fixed title="健身相册">
  		  <router-link to="/" slot="left">
  		    <mt-button icon="back">返回</mt-button>
  		  </router-link>
  		</mt-header>
        <!-- Content -->
        <input
          type="file"
          accept="image/*"  
          @change="changeImage($event)"
          ref="avatarInput"
          class="avatarInput"
          style="display:none"
       >
       <div class="pic_list_box">
        <div class="pic_list" v-show="imgDatas.length">
          <div :class="index == imgDatas.length-1 ? 'addDiv':' '" v-for="(src,index) in imgDatas"  :key="index">
            <img :src="src" width="80" height="80"  alt>
            <!-- <img class="upload_btn" v-show="imgDatas.length!=10" @click="upLoad" src="../../common/images/upload.png" alt> -->
          </div>
          <br>
        </div>
        
      </div>
    </div>
    
</template>
<style>
@import '../../common/css/record/imgList.css';

</style>
<script>
export default {
    name:"ImgList",
    data(){
        return {
          imgDatas:[],
          addDiv:''
        }
    },
    methods:{
        changeImage(e) {
            // 上传图片事件
            var files = this.$refs.avatarInput.files;
            var that = this;
            function readAndPreview(file) {
                //Make sure `file.name` matches our extensions criteria
                if (/\.(jpe?g|png|gif)$/i.test(file.name)) {
                var reader = new FileReader();
                reader.onload = function(e) {      
                    var add = that.imgDatas.pop();  
                    if (that.imgDatas.indexOf(this.result) === -1) {
                      that.imgDatas.push(this.result);
                      
                      localStorage.setItem("imgList",JSON.stringify(that.imgDatas));
                      that.imgDatas.push(add);
                    }
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
        
        
    },
    created:function(){
        if(localStorage.getItem("imgList")){
            this.imgDatas = JSON.parse(localStorage.getItem("imgList"));
            console.log(JSON.parse(localStorage.getItem("imgList")));
        }
        
    },
    mounted:function(){
      var that = this;
      that.imgDatas.push("http://img0.imgtn.bdimg.com/it/u=1540497191,917380171&fm=15&gp=0.jpg");
      
    //   this.addDiv = ad;
    }
}

window.onload = function(){
    var ad = document.getElementsByClassName("addDiv")[0];
    console.log(ad);
    ad.onclick = function(){
        console.log("外面===============")
        document.getElementsByClassName("avatarInput")[0].dispatchEvent(new MouseEvent("click"));         
    }
}
</script>