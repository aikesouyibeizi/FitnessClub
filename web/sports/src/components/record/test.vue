<template>
  <div class="productRate">
    <div class="header">
      <div class="card_title">
        <span class="card_title_tip">产品占比</span>
        <div class="card_title_icon">
          <i class="el-icon-question"></i>
        </div>
        <div class="card_title_link">
          更多
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <!--<span class="select">
                <el-select v-model="value" placeholder="请选择">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </span>-->
    </div>
    <!-- 环形 -->
    <el-card class="box-card box">
      <!--<div class="data_tip">
        <span>截至2020-02-13 10：34 全国数据统计</span>
      </div>-->
      <!-- <productRateTab :selectbar="options" ref="productRateTab"></productRateTab> -->
      <!--<div class="textCenter" @click="handleClick">
        <span name="productNum" :class="[select==='productNum'?'selected':'unselected']">产品数</span>
        <span name="assetsScale" :class="[select!=='productNum'?'selected':'unselected']">资产规模</span>
      </div>
      <pie></pie>
      <div class="textCenter" @click="handleClick">
        <span :class="[select===item.value?'selected':'unselected']" v-for="item in options" :key="item.value">{{item.label}}</span>
      </div>-->
    </el-card>
  </div>
</template>

<script>
import productRateTab from "@/view/productAnalysis/components/productRateTab"
import pie from "../../echarts/pie"
export default {
  props: {

  },
  components: {
    productRateTab
  },
  data() {
    return {
      // 下拉数据
      options: [{
        value: '选项1',
        text: '资产规模'
      }, {
        value: '选项2',
        text: '有效产品数'
      }],
      value: "选项1",
      select: "productNum"
    }
  },
  methods: {
    rewrite(){
      this.$refs.productRateTab.rewrite();
    },
    handleClick(e) {
      this.select = e.target.attributes.name.value
    },
    handleClick1(e) {
      this.select = e.target.attributes.key.value
    }
  },
  created() {

  }
}
</script>

<style lang="less" scoped>
.productRate {
  .header {
    width: calc(100% - 0.3rem);
    margin: 0.10rem auto 0;
    line-height: 0.32rem;
    overflow: hidden;
    .card_title {
      display: flex;
      .card_title_link {
        width: 74%;
        font-size: 0.28rem;
        padding-right: 0.10rem;
        text-align: right;
        color: #999;
      }
      .card_title_icon {
        width: 8%;
        padding-left: 0.10rem;
      }
      .card_title_tip {
        width: 18%;
        padding-left: 0.10rem;
        height: 0.4rem;
        font-size: 0.28rem;
        color: rgba(0,
        0,
        0,
        1);
      }
    }
    .label {
      // width: 160rem;
      display: inline-block;
      height: 0.21rem;
      font-size: 0.16rem;
      color: #000000;
    }
    .select {
      float: right;
      /deep/ .el-select {
        width: 0.80rem;
      }
      /deep/ .el-input__inner {
        background: #CFE3F4;
        border-radius: 0.20rem;
        padding-right: 0;
        color: rgba(42, 141, 226, 1);
        border: unset;
      }
      /deep/ .el-icon-arrow-up {
        line-height: 0.32rem;
      }
      /deep/ .el-input__suffix {
        right: 0;
      }
      /deep/ .el-icon-arrow-up:before {
        content: "\e78f";
        color: rgba(42, 141, 226, 1);
      }
    }
  }
  /deep/ .el-icon-arrow-up {
    line-height: 0.27rem;
  }
  .box {
    .data_tip {
      margin-top: -0.10rem;
      margin-bottom: 0.20rem;
      margin-left: -0.10rem;
    }
    span {
      display: inline-block; // width
      color: #999999;
      font-size: 0.13rem;
      padding-bottom: 0.10rem;
      border: unset;
      margin: 0 0.10rem;
    }
  }
  .selected {
    color: #2A8DE2 !important;
    border-bottom: 0.02rem solid #2A8DE2 !important;
  }
  .unselected {}
}
</style>
