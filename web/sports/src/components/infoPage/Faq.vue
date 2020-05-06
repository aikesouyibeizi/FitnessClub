

<template>
    <div class="faq">
        <!-- Header -->
        <mt-header fixed title="常见问题解答">
		  <router-link to="/" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
        <!-- 搜索栏 -->
        <div class="search">
            <div class="bar">
                <div class="inner">
                    <i class="iconfont">&#xe6b1;</i>
                    <input type="search" placeholder="搜索" v-model="searchString">
                </div>
                <div class="cancel" @click="cancel">取消</div>
            </div> 
        </div>

        <!-- Content -->
        <div class="questions" :class="index == 0 ? 'clickNow':' '" v-for="(item,index) in filteredQuestions" :key="item.ids"  @click="toAnswer(item.ids)">
            <span class="question" >{{item.titles}}</span>
            <i class="iconfont">&#xe68d;</i>
        </div>

    </div>
</template>
<style>
@import '../../common/css/infoPage/faq.css';
@import '../../common/iconfont/iconfont.css';
</style>
<script>
export default {
    name:"Faq",
    data(){
        return {
            searchString:"",
            id:'',
            questions:[]
        }
    },
    mounted:function(){
        var that = this;
        that.$http.get("http://localhost:8088/member/findAllQas").then(response=>{
            var req = response.body.date;
            this.questions = req;
            console.log(response);
        }).catch(error=>{
            console.log(error);
        })
    },
    computed:{
        
        filteredQuestions: function () {
            var questions_array = this.questions,
                searchString = this.searchString;
 
            if(!searchString){
                return questions_array;
            }
 
            searchString = searchString.trim().toLowerCase();
 
            questions_array = questions_array.filter(function(item){
                if(item.titles.toLowerCase().indexOf(searchString) !== -1){
                    return item;
                }
            })
            return questions_array;
            //
        }
   
    },
 methods:{
        cancel:function() {
            console.log("重置了吗")
            this.searchString="";
        },
        toAnswer(id){
            console.log("id",id);
            this.$router.push({
                name:'answer',
                params:{
                    id:id
                }
               
            });
        }
    }
}
</script>