<template>
    <div class="addr">
         <!-- Header -->
        <mt-header fixed title="我的地址">
		  <router-link to="/" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
        <!-- Content -->
        <div class="addrs" :class="index == 0 ? 'clickNow':' '" v-for="(item,index) in addrs" :key="item.addId"  @click="toModifyAddr(item.addrId)">
            <span class="info" >{{item.memberName}}, {{item.memberTel}}</span>
            <span class="addr">{{item.addrProvince}} {{item.addrCity}} {{item.addrCounty}}  {{item.addrDetail}}</span>
        </div>
    </div>
</template>
<style>
@import "../../common/css/infoPage/addr.css";
</style>
<script>
export default {
    name:"Addr",
     data(){
        return {
            id:'',
            addrs:[],
            courseId:''
        }
    },
    mounted:function(){
        var that = this;
        that.$http.get("http://localhost:8088/member/findAllAddr").then(response=>{
            var req = response.body.date;
            this.addrs = req;
            // console.log("这里是addr吗",response.body.date[0]);
            // console.log("这里是addr吗",JSON.stringify(req[0]));
            localStorage.setItem("addr",JSON.stringify(req[0]));
        }).catch(error=>{
            console.log(error);
        });
        this.courseId = this.$route.params.courseId;
    },
    methods:{
        toModifyAddr(id){
            var order = JSON.parse(localStorage.getItem("order"));
            console.log("id",id);

            if(order!=true){
                this.$router.push({
                    name:'modifyAddr',
                    params:{
                        id:id
                    }
                
                });
            }else{
                localStorage.setItem("order",false);
                this.$router.push({
                    name:'orderComfirm',
                    params:{
                        courseId:this.courseId,
                        addrId:id
                    }
                
                });
            }
            
        }
    }
}
</script>