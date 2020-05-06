<template>
  <div class="weightChart">
	<!-- Header -->
	<mt-header fixed title="体重记录">
	  <router-link to="/" slot="left">
	    <mt-button icon="back">返回</mt-button>
	  </router-link>
	</mt-header>
	<!-- Content -->
	<div class="main"  ref="main" style="height: 400px; width: 100%;">
		
	</div>
	<div class="detail">
		<div class="change">
			<span>体重变化(kg)：</span>
			<span>{{weightChange}}</span>
		</div>
		<div class="goal">
			<span>距离目标体重(kg)：</span>
			<span>{{goalDistance}}</span>
		</div>
	</div>
	<!-- Footer -->
	<div class="footer">
		<mt-button type="primary" size="large" @click="addWeight">添加体重</mt-button>
	</div>

  </div>
</template>
<style>
@import "../../common/css/record/weightChart.css";

</style>
<script>
import $ from 'jquery';
import { MessageBox } from 'mint-ui';
import { Toast } from 'mint-ui';
export default {
  name: "scatter",
  props: {
    options: {
      default: null,
      type: Object
    }
  },
  data() {
    return {
      daysX:[],
      weightY:[],
      memberId:'',
      weightChange:'',
      goalDistance:''
    };
  },
  methods: {
    
  	// ======EChart开始=======
    drawLine(charts) {
      var colors = ['#5793f3', '#d14a61', '#675bba'];
      let options = {
        color: colors,

        tooltip: {
            trigger: 'axis',
            axisPointer: {
                // type: 'cross'      //图表x和y都有信息
            }
        },
        legend: {
        	// show:false,
            data:['','体重(kg)'],
            top:28,

        },
        grid: {
            top: 70,
            bottom: 50,
            height:300,
            show:false

        },
        xAxis: [
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: '#000'
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                        	console.log(params);
                            return '' + params.value;
                        }
                    }
                },
                data: this.daysX
            },
            {}
        ],
        yAxis: [
            {
                type: 'value',
                scale:true
            }
        ],
        series: [
            {
                name: '体重(kg)',
                type: 'line',
                smooth: true,
                data:this.weightY
            }
        ]
      };
      charts.setOption(options);
    },
    // ======EChart结束=======
    addWeight(){
      var that = this;
      var member = JSON.parse(localStorage.getItem("member"));
      this.memberId = member.memberId;
      MessageBox.prompt('请输入今天的体重(kg)').then(({ value, action }) => {
         console.log("value",value);
         that.$http.get("http://127.0.0.1:8088/weight/insertWeight",{
           params:{
             memberId:that.memberId,
             weightNum:value
           }
         }).then(response=>{
           console.log(response);
           if(response.body.code==200){
             window.location.reload();
             Toast({
                message: '添加成功',
                iconClass: 'icon icon-success'
              });
              
           }else{
             Toast({
                message: '添加失败',
                iconClass: 'icon icon-success'
              });
           }
         })
       	
      });
    }

  },


  created(){
    var that = this;
    that.$http.get("http://127.0.0.1:8088/weight/getXDays").then(response=>{
      console.log(response);
      this.daysX = response.body.date;
    }).catch(error=>{
      console.log(error);
    });

    

  },
  mounted(){
     var that = this;
    that.$http.get("http://127.0.0.1:8088/weight/getWeightById").then(response=>{
      console.log(response);
      var req = response.body.date;
      this.goalDistance = req.goalDistance;
      this.weightChange = req.weightChange;
    }).catch(error=>{
      console.log(error);
    });
  },
  beforeMount() {
    var that = this;
    that.$http.get("http://127.0.0.1:8088/weight/getYWeights").then(response=>{
      console.log(response);
      this.weightY = response.body.date;
    }).catch(error=>{
      console.log(error);
    });

    
   



    setTimeout(() => {
      const charts = this.$echarts.init(this.$refs.main);
      this.drawLine(charts);
      window.onresize = function() {
        charts.resize();
      };
    }, 1 * 1000);




  }
};
</script>

