<template>
    <div class="orderComfirm">
    	<!-- Header -->
    	<mt-header fixed title="确认订单">
		  <router-link :to="{name:'courseDetail',params:{id:this.courseId}}" slot="left">
		    <mt-button icon="back">返回</mt-button>
		  </router-link>
		</mt-header>
		<!-- Content -->
		<div class="content">
			<div class="addr" @click="toChooseAddr">
				<i class="iconfont">&#xe609;</i>
				<div class="center">
					<div class="personInfo">
						<div class="name">{{memberName}}</div>
						<div class="tel">{{memberTel}}</div>
					</div>
					<div class="detailAddr">
						{{addrProvince}}{{addrCity}}{{addrCounty}}{{addrDetail}}
					</div>
				</div>
				
				<i class="iconfont">&#xe68d;
</i>
			</div>
			<div class="info">
				<div class="title">
					<img src="../../common/images/logo.png" alt="">
					<span class="run">RUN超级超级营</span>
				</div>
				<div class="course">
					<img :src=courseImg alt="">
					<div class="detail">
						<div class="name">{{courseName}}</div>
						<div class="date">2020年6月11号开班</div>
					</div>

				</div>
				<div class="orderContent">
					<div class="nav">
						订单内容
					</div>
					<div class="con">
						<div class="con1">• {{courseName}}</div>
						<div class="con2">• 健康食谱书籍</div>
					</div>
				</div>
			</div>

		</div>
		<div class="footer">
			<div class="price">
				合计：￥{{coursePrice}}
			</div>
			<mt-button type="primary" size="small" @click="submit" >提交订单</mt-button>
		</div>
    </div>
</template>
<style>
@import "../../common/css/course/orderComfirm.css";
@import "../../common/iconfont/iconfont.css";
</style>
<script>
import { Toast } from 'mint-ui';
export default {
    name:"OrderComfirm",
    data(){
        return {
            courseId:'',
            courseName:'',
            courseImg:'',
            courseDesc:'',
            coursePrice:'',
            memberId:'',
            orderMemberName:'',
            addrId:'',
            addrProvince:'',
            addrCity:'',
            addrCounty:'',
            addrDetail:'',
            memberTel:'',
            memberName:'',
        }
    },
    created:function(){
        this.courseId = this.$route.params.courseId;
        var that = this;
        that.$http.get("http://localhost:8088/course/findCourseById",{
            params:{
                id:this.courseId
            }
        }).then(response=>{
            console.log(response);
            var req = response.body.date;
            this.courseId = req.courseId;
            this.courseName = req.courseName;
            this.courseDesc = req.courseDesc;
            this.courseImg = req.courseImg;
            this.coursePrice = req.coursePrice;
        }).error(error=>{
            console.log(error);
        });
    },
    mounted:function(){
         var that = this;

        var member = JSON.parse(localStorage.getItem("member"));
        this.orderMemberName = member.memberName;
        this.memberId = member.memberId;
        this.addrId = member.defaultAddrId;
        console.log("defaultAddr",this.addrId);
      
       
        // if(!this.$route.params.addrId){
        //     console.log("this.$route.params.addrId为空吗",this.$route.params.addrId);
        //     var addr = JSON.parse(localStorage.getItem("addr"));
        //     this.addrId = addr.addrId;
        //      console.log("memberId",this.memberId);
        
        // }else{
        //     this.addrId = this.$route.params.addrId;
        // }

        that.$http.get("http://localhost:8088/member/findAddrById",{
            params:{
                id:this.addrId
            }
        }).then(response=>{
            console.log(response);
            var req = response.body.date;
            this.addrId = req.addrId;
            this.addrProvince = req.addrProvince;
            this.addrCity = req.addrCity;
            this.addrCounty = req.addrCounty;
            this.addrDetail = req.addrDetail;
            this.memberTel = req.memberTel;
            this.memberName = req.memberName;
        }).catch(error=>{
            console.log(error);
        })
        

    },
    methods:{
        submit(){
            var that = this;
            that.$http.get("http://localhost:8088/order/insertOrder",{
                params:{
                    courseId:this.courseId,
                    orderMemberName:this.orderMemberName,
                    memberId:this.memberId,
                    addrId:this.addrId,
                    courseName:this.courseName,
                    courseImg:this.courseImg,
                }
            }).then(response=>{
                console.log(response);
                let instance = Toast({
                    message: response.body.message,
                    iconClass: 'icon icon-success'
                });
                setTimeout(() => {
                    instance.close();
                }, 2000);
            }).catch(error=>{

            });

            setTimeout(()=>{
                that.$router.push({
                    name:"orderList",
                })
            },2500);
        },
        toChooseAddr(){
            localStorage.setItem("order",true);
            this.$router.push({
                name:"addr",
                params:{
                    courseId:this.courseId
                }
            })
        }
    }
}
</script>