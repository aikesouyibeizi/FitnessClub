<template>
	<div class="orderList">
	 	<!-- Header -->
    	<mt-header fixed title="订单列表">
		  <router-link to="/" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
		<div class="info" :class="index == 0 ? 'clickNow':' '" v-for="(item,index) in orders" :key="item.courseId" @click="toCourseDetail(item.courseId)">
			<div class="title">
				<img src="../../common/images/logo.png" alt="">
				<span class="run">RUN超级超级营</span>
			</div>
			<div class="course">
				<img :src=item.courseImg alt="">
				<div class="detail">
					<div class="name">{{item.courseName}}</div>
					<div class="date">2020年6月11号开班</div>
				</div>
			</div>
		</div>
	</div>
</template>
<style>
@import "../../common/css/order/orderList.css";
</style>
<script>
export default {
    name:"OrderList",
    data(){
        return {
            orders:[],
            courseId:'',
            memberId:''
        }
    },
    mounted:function(){
        var member = JSON.parse(localStorage.getItem("member"));
        this.memberId = member.memberId;
        var that = this;
        that.$http.get("http://localhost:8088/order/findAllOrders",{
            params:{
                id:this.memberId
            }
        }).then(response=>{
            console.log(response);
            var req = response.body.date;
            this.orders = req;
        }).catch(error=>{
            console.log(error);
        })
    },
    methods:{
        toCourseDetail(id){
            this.$router.push({
                name:"courseDetail",
                params:{
                    id:id
                }
            })
        }
    }
}
</script>