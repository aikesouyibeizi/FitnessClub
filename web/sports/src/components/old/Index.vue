<template>
	<div v-cloak>

		<mt-header title="资产管理系统" class="topbar">
			<router-link to="" slot="left" style="color: #000000;">
				<!-- <mt-button icon="back" @click.native="$router.back(-1)">返回</mt-button> -->
				<mt-button icon="back" >返回</mt-button>
			</router-link>
			<mt-button icon="more" style="color: #000000;" slot="right"></mt-button>
		</mt-header>
		<a-spin :spinning="spinning" :delay="delayTime" tip="Loading..." 
		>
<!-- 		<a-spin :spinning="spinning" :delay="delayTime" tip="Loading..." else
		@touchstart="touchStart($event)" @touchmove="touchMove($event)" @touchend="touchEnd($event)"
		> -->
			<div class="spin-content">
				<mt-tab-container class="page-tabbar-container" v-model="selected">
					<!-- 消息 -->
					<mt-tab-container-item id="message" :style="uList">
						<div style="height:100%;" @touchstart="touchStart($event)" @touchmove="touchMove($event)" @touchend="touchEnd($event)" :style="{transform: 'translate3d(0,' + top + 'px, 0)'}">
							<header class="pull-refresh">
								<slot name="pull-refresh">
									<!-- <div class="down-tip" v-if="dropDownState==1">
							            <img v-if="dropDownInfo.downImg" class="down-img" :src="require('../assets/icon/'+dropDownInfo.downImg)">
							            <span class="down-text">{{dropDownInfo.downText}}</span>
							          </div> -->
									<div class="up-tip" v-if="dropDownState==2">
										<img v-if="dropDownInfo.upImg" class="up-img" :src="require('../assets/icon/'+dropDownInfo.upImg)">
										<span class="up-text">{{dropDownInfo.upText}}</span>
									</div>
									<div class="refresh-tip" v-if="dropDownState==3">
										<img v-if="dropDownInfo.refreshImg" class="refresh-img" :src="require('../assets/icon/'+dropDownInfo.refreshImg)">
										<span class="refresh-text">{{dropDownInfo.refreshText}}</span>
									</div>
								</slot>
							</header>
							<mt-cell v-for="(item, index) in messages" :key="index" :to="{path:'/message/dialogue',query:{name:item.name,userId:item.userId}}"
							 is-link>
								<a-badge :count="item.num" />
								<img slot='icon' src="../assets/img/user.jpg" style='width:50px;height:50px;float:left;margin:10px 10px 10px 0;border-radius: 5px;'>
								<div slot='title' style='padding-top:20px;'>
									<div style="margin-left: 50px;">
										<div class="message_name">{{item.name}}</div>
										<div class="message_time">{{item.time}}</div>
									</div>
									<div style="margin-left: 50px;">
										<div class="message_msg" :style="item.num != 0?'color:#3794FF':''">{{item.content}}</div>
										<div class="message_dept">{{item.dept}}</div>
									</div>
								</div>
							</mt-cell>
						</div>
					</mt-tab-container-item>

					<!-- 通讯录 -->
					<mt-tab-container-item id="record" :style="uList">
						<div style="height:100%;"  @touchstart="touchStart2($event)" @touchmove="touchMove2($event)" @touchend="touchEnd2($event)" :style="{transform: 'translate3d(0,' + top2 + 'px, 0)'}">
							<header class="pull-refresh">
								<slot name="pull-refresh">
									<div class="up-tip" v-if="dropDownState2==2">
										<img v-if="dropDownInfo2.upImg" class="up-img" :src="require('../assets/icon/'+dropDownInfo2.upImg)">
										<span class="up-text">{{dropDownInfo2.upText}}</span>
									</div>
									<div class="refresh-tip" v-if="dropDownState2==3">
										<img v-if="dropDownInfo2.refreshImg" class="refresh-img" :src="require('../assets/icon/'+dropDownInfo2.refreshImg)">
										<span class="refresh-text">{{dropDownInfo2.refreshText}}</span>
									</div>
								</slot>
							</header>
							<div class="list" >
								<ul v-for="i in 26" :key="i">
									<li class="record_li" v-show="onshow(i)" name="String.fromCharCode((64+i))">{{String.fromCharCode((64+i))}}</li>
									<li class="record_li2" v-for="(item, index) in usersData" :key="index" :id="String.fromCharCode((64+item.zm))"
									 @click="toUserInfo(item.userId);" v-show="item.zm == i">
										<img class="record_li_img" slot='icon' src="../assets/img/user.jpg">
										<div class="record_li_div">{{item.name}}</div>
										<div class="record_li_div2">{{item.dept}}</div>
									</li>
								</ul>
								<ul v-show="onshow(27)">
									<li class="record_li">#</li>
									<li class="record_li2" v-for="(item, index) in usersData" :key="index" :id="String.fromCharCode((64+item.zm))"
									 @click="toUserInfo(item.userId);" v-show="item.zm == 27">
										<img class="record_li_img" slot='icon' src="../assets/img/user.jpg">
										<div class="record_li_div">{{item.name}}</div>
										<div class="record_li_div2">{{item.dept}}</div>
									</li>
								</ul>
							</div>
							<!-- <div class="record_div_parent">
								<div class="record_div">
									<div v-for="i in 26" v-show="onshow(i)" :key="i" v-bind:class="{zmClass:i==nowIndex}" @click="onZM(i)" style="font-size: 15px;padding-top:1px;">{{String.fromCharCode((64+i))}}</div>
									<div @click="onZM(27)" v-bind:class="{zmClass:27==nowIndex}" style="font-size: 15px;padding-top:1px;">#</div>
								</div>
							</div> -->
						</div>
					</mt-tab-container-item>

					<!-- 功能权限 -->
					<mt-tab-container-item id="search">
						<div style="margin:15px 0">
							<div @click="toAssetInquiry()">
								<mt-cell title="资产查询"  is-link>
									<i slot="icon" class='iconfont icon-icon-chaxun' style='color:lightcoral'></i>
								</mt-cell>
							</div>
							<div @click="toSubmitExamination()">
								<mt-cell title="我提交的审批" is-link>
									<i slot="icon" class='iconfont icon-shenpi' style='color: gold'></i>
								</mt-cell>
							</div>
							<div @click="toPendingApproval()" v-if="roleId == '1' || roleId == '2'">
								<mt-cell title="待审批" is-link>
									<i slot="icon" class='iconfont icon-chakan' style='color: gold'></i>
								</mt-cell>
							</div>
						</div>
						<div style="margin:15px 0" @click="handleClick()">
							<mt-cell title="扫一扫" is-link>
								<i slot="icon" class='iconfont icon-saoyisao' style='color:lightcoral'></i>
							</mt-cell>
						</div>
						<!-- <div style="margin:15px 0" @click="toTest()">
							<mt-cell title="测试" is-link>
								<i slot="icon" class='iconfont icon-gengduogongneng' style='color:lightcoral'></i>
							</mt-cell>
						</div> -->
					</mt-tab-container-item>

					<!-- 我 -->
					<mt-tab-container-item id="my">
						<mt-cell style='margin:10px 0;' is-link>
							<img slot='icon' src="../assets/img/user.jpg" width="60" height="60" style='float:left;margin:10px 10px 10px 0;'>
							<div slot='title' style='padding-top:20px;'>
								<div style='display: inline-block;'>{{userName}}</div>
								<div style='font-size:12px;color:#aaa;padding:7px 0'>工号： {{userId}}</div>
							</div>
						</mt-cell>
						<div @click="toMyAssets()">
							<mt-cell title="我的资产" is-link>
								<i slot="icon" class='iconfont icon-drxx92' style='color:#1296db'></i>
							</mt-cell>
						</div>
						<div style="margin:15px 0">
							<div @click="toUserManager();" v-if="roleId == '1'" >
								<mt-cell title="账号管理" is-link>
									<i slot="icon" class='iconfont icon-shenpi' style='color:lightcoral'></i>
								</mt-cell>
							</div>
							<!-- <div @click="toSysManager();" v-if="roleId == '1'" >
								<mt-cell title="系统管理" is-link>
									<i slot="icon" class='iconfont icon-shenpi' style='color:lightcoral'></i>
								</mt-cell>
							</div> -->
							<!-- <mt-cell title="消息设置" is-link>
								<i slot="icon" class='iconfont icon-shezhi' style='color:lightcoral'></i>
							</mt-cell> -->
						</div>
						<div style="margin:15px 0">
							<div @click="toAssetApply()" >
								<mt-cell title="资产申请" is-link>
									<i slot="icon" class='iconfont icon-jiekuanshenqing' style='color:lightcoral'></i>
								</mt-cell>
							</div>
						</div>
						<!-- <mt-cell title="设置" is-link>
							<i slot="icon" class='iconfont icon-shezhi' style='color:#1296db'></i>
						</mt-cell> -->
						<div @click="logout();" >
							<mt-cell title="退出登录" is-link>
								<i slot="icon" class='iconfont icon-shezhi' style='color:#1296db'></i>
							</mt-cell>
						</div>
					</mt-tab-container-item>
				</mt-tab-container>

				<mt-tabbar v-model="selected" style="background-color:#F7F7F7;" fixed>
					<mt-tab-item id="message">
						<i slot="icon" class='iconfont icon-xiaoxi'></i>
						消息<span v-if="isreadf != 0" style="color: red;font-weight: bold;">({{isreadf}})</span>
					</mt-tab-item>
					<mt-tab-item id="record">
						<i slot="icon" class='iconfont icon-cedaohang-tongxunlu'></i>
						通讯录
					</mt-tab-item>
					<mt-tab-item id="search">
						<i slot="icon" class='iconfont icon-gengduogongneng'></i>
						功能权限
					</mt-tab-item>
					<mt-tab-item id="my">
						<i slot="icon" class='iconfont icon-wo'></i>
						我
					</mt-tab-item>
				</mt-tabbar>
			</div>
		</a-spin>
	</div>
</template>

<script>
	// import Test from './homePage/Test.vue'
	import {
		Toast
	} from 'mint-ui';
	export default {
		name: 'Index',
		components: {
			// Test: Test
		},
		data() {
			return {
				selected: '',
				nowIndex: 0,
				usersData: [], //通讯录
				messages: [], //我的消息
				isreadf:0,//消息总未读数
				zm: [
					// 1, 2, 3, 6, 20, 27
				], //字母1-26  =   A-Z
				spinning: true,
				delayTime: 500,
				uList: 'overflow: auto;',

				//下拉刷新参数
				defaultOffset: 50, // 默认高度, 相应的修改.releshMoudle的margin-top和.down-tip, .up-tip, .refresh-tip的height
				top: 0,
				scrollIsToTop: 0,
				startY: 0,
				isDropDown: false, // 是否下拉
				isRefreshing: false, // 是否正在刷新
				dropDownState: 1, // 显示1:下拉可以刷新, 2:松开立即刷新, 3:正在刷新数据中...
				diffTop:0,//距离顶部
				diff:1,
				move:1,
				dropDownInfo: {
					downText: '下拉可以刷新',
					downImg: 'saoyisao.png',
					upText: '松开立即刷新',
					upImg: 'saoyisao.png',
					refreshText: '正在刷新数据...',
					refreshImg: 'saoyisao.png'
				},
				//通讯录下拉刷新的操作参数
				defaultOffset2: 50, // 默认高度, 相应的修改.releshMoudle的margin-top和.down-tip, .up-tip, .refresh-tip的height
				top2: 0,
				scrollIsToTop2: 0,
				startY2: 0,
				isDropDown2: false, // 是否下拉
				isRefreshing2: false, // 是否正在刷新
				dropDownState2: 1, // 显示1:下拉可以刷新, 2:松开立即刷新, 3:正在刷新数据中...
				diffTop2:0,//距离顶部
				diff2:0,
				move2:0,
				dropDownInfo2: {
					downText: '下拉可以刷新',
					downImg: 'saoyisao.png',
					upText: '松开立即刷新',
					upImg: 'saoyisao.png',
					refreshText: '正在刷新数据...',
					refreshImg: 'saoyisao.png'
				},
				 roleId:'',
				 
				 isM:false,//是否已经初始化消息列表
				 isT:false,//是否已经初始化通讯录列表
				 
				 userName:'未登录',//用户名
				 userId:'',//工号
			}
		},
		watch: {
			selected: function(val, oldVal) {
				// 这里就可以通过 val 的值变更来确定
				this.selected = val;
				// console.log(val)
			}
		},
		methods: {
			
			//实现下拉刷新操作
			touchStart(e) {
				console.log("touchStart。。。");
				this.startY = e.targetTouches[0].pageY
				console.log("this.startY：" + this.startY);
			},
			touchStart2(e) {
				console.log("touchStart2。。。");
				this.startY2 = e.targetTouches[0].pageY
				console.log("this.startY2：" + this.startY2);
			},
			touchMove(e) {
				console.log("touchMove。。。");
				this.scrollIsToTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop // safari 获取scrollTop用window.pageYOffset
				if (e.targetTouches[0].pageY > this.startY) {
					// 下拉
					this.isDropDown = true
					if (this.scrollIsToTop === 0 && !this.isRefreshing) {
						// 拉动的距离
						let diff = e.targetTouches[0].pageY - this.startY - this.scrollIsToTop;
						this.move = diff;
						this.top = Math.pow(diff, 0.8) + (this.dropDownState === 3 ? this.defaultOffset : 0)
						if (this.top >= this.defaultOffset) {
							this.dropDownState = 2
						} else {
							this.dropDownState = 1
						}
						if(this.diffTop <= 0){
							// 去掉会导致ios无法刷新
							e.preventDefault()
						}else{}
					}
				} else {
					let diff = this.startY - e.targetTouches[0].pageY - this.scrollIsToTop;
					this.diff = diff;
					// console.log("diff:",diff);
					this.isDropDown = false
					this.dropDownState = 1
				}
			},
			touchMove2(e) {
				console.log("touchMove2。。。");
				this.scrollIsToTop2 = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop // safari 获取scrollTop用window.pageYOffset
				
				if (e.targetTouches[0].pageY > this.startY2) {// 下拉
					this.isDropDown2 = true
					if (this.scrollIsToTop2 === 0 && !this.isRefreshing2) {
						// 拉动的距离
						let diff = e.targetTouches[0].pageY - this.startY2 - this.scrollIsToTop2;
						this.move2 = diff;
						this.top2 = Math.pow(diff, 0.8) + (this.dropDownState2 === 3 ? this.defaultOffset2 : 0)
						if (this.top2 >= this.defaultOffset2) {
							this.dropDownState2 = 2
						} else {
							this.dropDownState2 = 1
						}
						if(this.diffTop2 <= 0){
							// 去掉会导致ios无法刷新
							e.preventDefault()
						}else{}
						
					}
				} else {
					let diff = this.startY2 - e.targetTouches[0].pageY - this.scrollIsToTop2;
					this.diff2 = diff;
					// console.log("diff:",diff);
					this.isDropDown2 = false
					this.dropDownState2 = 1
				}
			},
			touchEnd(e) {
				this.diffTop = this.diffTop + this.diff;
				console.log("touchEnd。。。");
				console.log("是否下拉：" + this.isDropDown + "; 是否正在刷新：" + this.isRefreshing);
				if (this.isDropDown && !this.isRefreshing) {
					this.diffTop = this.diffTop - this.move;
					if(this.diffTop <= 0){
						if (this.top >= this.defaultOffset) {
							// do refresh
							this.refresh()
							this.isRefreshing = true
						} else {
							// cancel refresh
							this.isRefreshing = false
							this.isDropDown = false
							this.dropDownState = 1
							this.top = 0
						}
					}else{
						this.isRefreshing = false;
						this.isDropDown = false;
						this.dropDownState = 1;
						this.top = 0;
					}
					this.move = 0;
				}
			},
			touchEnd2(e) {
				this.diffTop2 = this.diffTop2 + this.diff2;
				console.log("touchEnd2。。。");
				// console.log(this.diffTop2)
				console.log("是否下拉：" + this.isDropDown2 + "; 是否正在刷新：" + this.isRefreshing2);
				if (this.isDropDown2 && !this.isRefreshing2) {
					this.diffTop2 = this.diffTop2 - this.move2;
					if(this.diffTop2 <= 0){
						if (this.top2 >= this.defaultOffset2) {
							this.refresh2();
							this.isRefreshing2 = true;
						} else {
							// cancel refresh
							this.isRefreshing2 = false;
							this.isDropDown2 = false;
							this.dropDownState2 = 1;
							this.top2 = 0;
						}
						this.diffTop2 = 0;
					}else{
						this.isRefreshing2 = false;
						this.isDropDown2 = false;
						this.dropDownState2 = 1;
						this.top2 = 0;
					}
					this.move2 = 0;
				}
			},
			refresh() {
				console.log("refresh。。。");
				this.dropDownState = 3
				this.top = this.defaultOffset
				// this.spinning = true;
				// 这是全是静态数据,延时1200毫秒，给用户一个刷新的感觉，如果是接口数据的话，直接调接口即可
				this.$http.get(this.$myStore.baseURL + '/message/getMessageUserList', {
					params: {
						'id': this.$myStore.userId
					}
				}).then(function(response) {
					console.log("response：", response);
					var msgs = response.body.date;
					var isreadf = 0;
					for (var i = 0; i < msgs.length; i++) {
						msgs[i].time = this.timestampToTime(+msgs[i].time);
						isreadf += msgs[i].num;
						// console.log("s:" + msgs[i].time);
					}
					this.isreadf = isreadf;
					this.messages = msgs;
					this.isM = true;
					this.$myStore.isreadf = isreadf;
					this.$myStore.messages = msgs;
					// this.$myStore.spinning = false;
					this.$myStore.isM = true;
					this.refreshDone();
					Toast({
						message: '刷新成功!',
						iconClass: 'icon icon-success'
					});
					// this.spinning = false;
				}, function(response) {
					// console.log("response：",response);
					Toast({
						message: '服务器异常!',
						iconClass: 'icon icon-success'
					});
					this.refreshDone();
					// this.spinning = false;
				});
			},
			refresh2() {
				console.log("refresh2。。。");
				this.dropDownState2 = 3
				this.top2 = this.defaultOffset2
				// this.spinning2 = true;
				// 这是全是静态数据,延时1200毫秒，给用户一个刷新的感觉，如果是接口数据的话，直接调接口即可
				this.$http.get(this.$myStore.baseURL + '/user/getAllUsers', {
				}).then(function(response) {
					console.log("response：", response);
					this.usersData = response.body.date;
					this.$myStore.usersData = response.body.date;
					var zm = [];
					for(var i = 0; i < response.body.date.length; i++){
						var j = 0;
						for(; j < zm.length; j++){
							if(zm[j] == +response.body.date[i].zm){
								break;
							}
						}
						if(j == zm.length){
							zm.push(+response.body.date[i].zm);
						}
					}
					this.zm = zm;
					this.isT = true;
					this.$myStore.zm = zm;
					this.$myStore.isT = true;
					this.refreshDone2();
					Toast({
						message: '刷新成功!',
						iconClass: 'icon icon-success'
					});
				}, function(response) {
					Toast({
						message: '服务器异常!',
						iconClass: 'icon icon-success'
					});
					this.refreshDone2();
					// this.spinning2 = false;
				});
			},
			refreshDone() {
				console.log("refreshDone。。。");
				this.isRefreshing = false
				this.isDropDown = false
				this.dropDownState = 1
				this.top = 0
			},
			refreshDone2() {
				console.log("refreshDone2。。。");
				this.isRefreshing2 = false
				this.isDropDown2 = false
				this.dropDownState2 = 1
				this.top2 = 0
			},
			//完成刷新
		
			onshow(i) {
				let that = this;
				let arr = that.zm;
				if (arr.includes(i)) {
					return true;
				} else {
					return false;
				}
			},
			toUserInfo(userId) {
				// console.log("工号 == ", userId);
				this.$router.push({
					path: '/message/userInfo',
					query: {
						userId: userId,
					},
				});
			},
			toTest() {
				// console.log("进入到测试页");
				// this.$router.push({
				// 	path: '/homePage/Test'
				// });

				this.$router.push({
					path: '/functionalModule/assetDetail', 
					query: {
					  id: "9992"
					},
				});
			},
			toAssetInquiry(){//资产查询页面
				console.log("进入资产查询页面");
				this.$router.push({
					path: '/functionalModule/asset/assetInquiry', 
				});
			},
			toSubmitExamination(){//进入我提交的审批页面
				console.log("进入我提交的审批页面");
				this.$router.push({
					path: '/functionalModule/asset/submitExamination', 
					// query: {
					//   id: "10002"
					// },
				});
			},
			toPendingApproval(){//进入待审批页面
				console.log("进入待审批页面");
				this.$router.push({
					path: '/functionalModule/asset/pendingApproval', 
					// query: {
					//   id: "10002"
					// },
				});
			},
			onZM(vl) {
				this.nowIndex = vl;
				var totop = 0;
				var userData = this.usersData;
				let zm = this.zm;
				var vlIndex = this.getArrayIndex(zm, vl); //获得当前点击的字母在zm数组中下标
				for (var i = 0; i < vlIndex; i++) {
					totop += 30;
					vl = zm[i];
					for (var j = 0; j < userData.length; j++) {
						if (userData[j].zm == vl) {
							totop += 61; //下边框线占一像素
						}
					}
				}
				javascript: scroll(0, totop);
			},
			getArrayIndex(arr, obj) { //得到数组元素中下标
				var i = arr.length;
				while (i--) {
					if (arr[i] === obj) {
						return i;
					}
				}
				return -1;
			},
			//移动端扫一扫方法
			handleClick: function() {
				var id = '';
				var text = '';
				var that = this;
				var isImplement = 0;
				//二维码{"id":"123456","name":"陈厚伯"}
				// cordova.plugins.barcodeScanner.scan(
				// 	function(result) {
				// 		alert("result.text:" + result.text + "\nJSON.parse(result.text).id:" + JSON.parse(result.text).id)
				// 		result = result.text;
				// 		result = typeof result == 'string' ? JSON.parse(result) : result;
				// 		isImplement = 1;
				// 		id = result.id;
				// 	},
				// 	function(error) {
				// 		if (isImplement == 0) {
				// 			Toast({
				// 				message: '扫描失败，请稍后再试!',
				// 				iconClass: 'icon icon-success'
				// 			});
				// 		}
				// 		isImplement = 0;
				// 	}
				// );
				// setTimeout(function() {
				// 	if (isImplement == 1) {
				// 		that.$router.push({
				// 			path: '/functionalModule/assetDetail',
				// 			query: {
				// 				id: id
				// 			},
				// 		});
				// 	}
				// }, 3000);
				
				that.$router.push({
					path: '/functionalModule/assetDetail',
					query: {
						aaa: 0,//0表示有扫一扫入口进入
					},
				});
			},
			timestampToTime: function(timestamp) {
				var date = new Date(timestamp); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
				var Y = date.getFullYear() + '-';
				var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
				var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
				var h = (date.getHours() < 10 ? '0' + (date.getHours()) : date.getHours()) + ':';
				var m = (date.getMinutes() < 10 ? '0' + (date.getMinutes()) : date.getMinutes()) + ':';
				var s = (date.getSeconds() < 10 ? '0' + (date.getSeconds()) : date.getSeconds());
				return Y + M + D + h + m + s;
			},
			toMyAssets(){
				console.log("跳转到当前用户的使用资产列表");
				this.$router.push({
					path: '/message/assetInfo',
					query: {
						userId:this.$myStore.userId
					},
				});
			},
			toUserManager(){
				console.log("跳转到系统管理页面");
				this.$router.push({
					path: '/user/userManager',
					// query: {
					// 	userId:this.$myStore.userId
					// },
				});
			},
			toSysManager(){
				console.log("跳转到用户管理页面");
				this.$router.push({
					path: '/user/systemManager',
					// query: {
					// 	userId:this.$myStore.userId
					// },
				});
			},
			logout(){
				console.log("退出登录");
				this.clearAll();
			},
			clearAll(){
				console.log("清空全局所有的数据");
				//基本用户信息---通过登录时获取
				this.$myStore.userId = '';//100888
				this.$myStore.userName = '';//陈厚伯
				this.$myStore.userDeptId = '';//0
				this.$myStore.userDept = '';//总部
				this.$myStore.roleId = '';//用户权限id:1-超级管理员；2-管理员；3-普通用户
				this.$myStore.roleName = '';//用户权限名称
				
				//tabbar初始化值设置
				this.$myStore.selected = 'message';//tabbar默认值
				this.$myStore.isM = false;//是否已经初始化消息列表
				this.$myStore.isT = false;//是否已经初始化通讯录列表
				//消息列表
				this.$myStore.isreadf = '';//总未读消息数
				this.$myStore.messages = [];//消息列表
				this.$myStore.spinning = true;//默认加载中。。。
				//通讯录列表
				this.$myStore.usersData = [];//通讯录列表
				this.$myStore.zm = [];//字母
				this.$router.push({
					path: '/user/login',
				});
			},
			toAssetApply(){
				console.log("进入登录资产申请界面！");
				this.$router.push({
					path: '/user/ownAssetApply',
					// query: {
					// 	userId:this.$myStore.userId
					// },
				});
			},
			init(){
				//我   --信息显示
				this.userName = this.$myStore.userName;
				this.userId = this.$myStore.userId;
				//加载消息列表
				this.$http.get(this.$myStore.baseURL + '/message/getMessageUserList', {
					params: {
						'id': this.$myStore.userId
					}
				}).then(function(response) {
					console.log("response：", response);
					var msgs = response.body.date;
					var isreadf = 0;
					for (var i = 0; i < msgs.length; i++) {
						msgs[i].time = this.timestampToTime(+msgs[i].time);
						isreadf += msgs[i].num;
						// console.log("s:" + msgs[i].time);
					}
					this.isreadf = isreadf;
					this.messages = msgs;
					this.spinning = false;
					this.isM = true;
					this.$myStore.isreadf = isreadf;
					this.$myStore.messages = msgs;
					this.$myStore.spinning = false;
					this.$myStore.isM = true;
				}, function(response) {
					// console.log("response：",response);
					Toast({
						message: '加载失败!',
						iconClass: 'icon icon-success'
					});
					this.spinning = false;
				});
				// this.spinning = false;
				
				//加载通讯录
				this.$http.get(this.$myStore.baseURL + '/user/getAllUsers', {
				}).then(function(response) {
					console.log("response：", response);
					this.usersData = response.body.date;
					this.$myStore.usersData = response.body.date;
					var zm = [];
					for(var i = 0; i < response.body.date.length; i++){
						var j = 0;
						for(; j < zm.length; j++){
							if(zm[j] == +response.body.date[i].zm){
								break;
							}
						}
						if(j == zm.length){
							zm.push(+response.body.date[i].zm);
						}
					}
					this.zm = zm;
					this.isT = true;
					this.$myStore.zm = zm;
					this.$myStore.isT = true;
				}, function(response) {
					Toast({
						message: '服务器异常..!',
						iconClass: 'icon icon-success'
					});
				});
			},
		},
		beforeCreate() {
			console.log("钩子函数：beforeCreate..........在实例初始化之后");
		},
		created() {
			console.log("钩子函数：created...........实例已经创建完成之后被调用。");
			if (document.querySelector('.down-tip')) {
				// 获取不同手机的物理像素（dpr）,以便适配rem
				this.defaultOffset = document.querySelector('.down-tip').clientHeight || this.defaultOffset
			}
		},
		beforeMount() {
			console.log("钩子函数：beforeMount...........在挂载开始之前被调用");
		},
		mounted() {
			console.log("钩子函数：mounted...........el 被新创建的 vm.$el 替换，并挂载到实例上去之后调用该钩子");
			if(this.$myStore.isT || this.$myStore.isM){
				this.isreadf = this.$myStore.isreadf;
				this.messages = this.$myStore.messages;
				this.spinning = this.$myStore.spinning;
				this.isM = this.$myStore.isM;
				this.usersData = this.$myStore.usersData;
				this.zm = this.$myStore.zm;
				this.isT = this.$myStore.isT;
				this.userId = this.$myStore.userId;
				this.userName = this.$myStore.userName;
			}else{
				this.init();
			}
			//获取当前屏幕高度
			var h = document.documentElement.clientHeight || document.body.clientHeight;
			this.uList = this.uList + 'height:' + (h - 55 - 48) + 'px;'; //减去页面上固定高度height
			console.log("h:" + h + ",this.uList:" + this.uList);
			
			//获取用户权限
			this.roleId = this.$myStore.roleId;
			this.selected =  this.$myStore.selected;
		},
		beforeUpdate() {
			console.log("钩子函数：beforeUpdate...........数据更新时调用，");
		},
		updated() {
			console.log("钩子函数：updated...........当这个钩子被调用时，组件 DOM 已经更新，所以你现在可以执行依赖于 DOM 的操作");
			this.$myStore.selected = this.selected ;
		},
		activated() {
			console.log("钩子函数：activated...........keep-alive 组件激活时调用。");
		},
		deactivated() {
			console.log("钩子函数：deactivated...........keep-alive 组件停用时调用。");
		},
		beforeDestroy() {
			console.log("钩子函数：beforeDestroy...........实例销毁之前调用。");
		},
		destroyed() {
			console.log("钩子函数：destroyed...........Vue 实例销毁后调用");
		}
	}
</script>

<style>
	@import url("../assets/fonts/iconfont.css");

	ul,
	li {
		padding: 0;
		margin: 0;
		list-style: none
	}

	body {
		margin: 0;
	}

	html {
		background: #eaeaea;
	}

	[v-cloak] {
		display: none;
	}

	/* .list{
		position: relative;
		overflow: auto;
	} */
	.iconfont {
		font-size: 20px;
	}

	.mint-cell-allow-right {
		display: none;
	}

	.mint-cell-wrapper {
		padding: 0px 12px;
	}

	.topbar {
		background: #F7F7F7;
		/* opacity: 0.8; */
		height: 3.5em;
	}

	.mint-indexsection-index {
		background: #eaeaea;
	}

	.mint-tabbar>.mint-tab-item.is-selected {
		background: none;
		color: cornflowerblue;
	}

	.mint-cell-text {
		position: relative;
		top: -4px;
		padding-left: 10px;
	}

	.mint-tab-container {
		margin-bottom: 55px;
		margin-top: 3em;
		/* height:90%; */
		overflow: auto;
	}

	.mint-header {
		top: 0;
		display: flex;
		right: 0;
		left: 0;
		position: fixed;
		z-index: 11;
	}

	.zmClass {
		background-color: aquamarine;
	}

	.record_li {
		height: 30px;
		font-size: 12px;
		margin-left: 10px;

		/* 元素垂直居中 */
		display: flex;
		align-items: center;

	}

	.record_li2 {
		border-bottom: 1px solid darkgray;
		height: 60px;
		background-color: white;
	}

	.record_li_img {
		padding: 5px 0px 0px 5px;
		width: 50px;
		height: 50px;
		border-radius: 10px;
		float: left;
	}

	.record_li_div {
		width: 30%;
		float: left;
		padding-top: 16px;
		padding-left: 10px;
		font-size: 16px;
	}

	.record_li_div2 {
		width: 40%;
		float: left;
		padding-top: 16px;
		font-size: 14px;
		text-align: right;
		color: darkgray;
	}

	.record_div_parent {
		display: table;
		height: 86%;
		width: 19px;
		position: fixed;
		z-index: 1;
		right: 0;
		top: 3.1em;
		bottom: 5em;
		opacity: 1;
	}

	.record_div {
		display: table-cell;
		vertical-align: middle;
		text-align: center;
	}

	.mint-cell-value.is-link {
		position: absolute;
		top: 6px;
		left: 45px;
		overflow: hidden;
	}

	.mint-tabbar.is-fixed {
		z-index: 11;
	}

	.mint-tabbar>.mint-tab-item.is-selected {
		color: cornflowerblue;
	}

	.mint-tabbar>.mint-tab-item.is-selected {
		color: #1e33d8;
	}

	a {
		color: #8F8F8F;
	}

	.message_msg {
		font-size: 12px;
		color: #aaa;
		padding: 7px 0;
		width: 50%;
		display: inline-block;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}

	.message_dept {
		font-size: 12px;
		color: #aaa;
		display: inline-block;
		position: absolute;
		right: 12px;
		padding-top: 10px;
	}

	.message_name {
		font-size: 12px;
		color: #aaa;
		width: 60%;
		display: inline-block;
	}

	.message_time {
		font-size: 12px;
		color: #aaa;
		position: absolute;
		right: 12px;;
		display: inline-block;
		text-align: right;
	}


	/* 下拉刷新 */
	.refresh-moudle {
		width: 100%;
		margin-top: -100px;
		-webkit-overflow-scrolling: touch;
		/* ios5+ */
	}

	.pull-refresh {
		width: 100%;
		color: #999;
		transition-duration: 200ms;
		font-size: 24px;
	}

	.refresh-moudle .down-tip,
	.up-tip,
	.refresh-tip {
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100px;
	}

	.down-img {
		width: 35px;
		height: 35px;
		margin-right: 15px;
		transform: rotate(0deg);
		animation: anticlockwise 0.8s ease;
	}

	@keyframes anticlockwise {
		0% {
			transform: rotate(-180deg);
		}

		100% {
			transform: rotate(0deg);
		}
	}

	.up-img {
		width: 35px;
		height: 35px;
		margin-right: 15px;
		transform: rotate(180deg);
		animation: clockwise 0.8s ease;
	}

	@keyframes clockwise {
		0% {
			transform: rotate(0deg);
		}

		100% {
			transform: rotate(-180deg);
		}
	}

	.refresh-img {
		width: 35px;
		height: 35px;
		margin-right: 15px;
		animation: rotating 1.5s linear infinite;
	}

	@keyframes rotating {
		0% {
			transform: rotate(0deg);
		}

		100% {
			transform: rotate(1turn);
		}
	}
</style>
