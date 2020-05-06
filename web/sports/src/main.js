import Vue from 'vue';
import App from './App';

// 新增
import router from './router';
import iView from 'iview';
import api from "./api/index";
import 'mpvue-calendar/src/browser-style.css';
import VueResource from 'vue-resource';
import Mint from 'mint-ui';
import 'mint-ui/lib/style.css';
import { Header } from 'mint-ui';
import { Navbar, TabItem } from 'mint-ui';
import { Search } from 'mint-ui';
import { Button } from 'mint-ui';
import echarts from 'echarts';
import '../node_modules/echarts/map/js/china.js'; // 引入中国地图数据
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// import axios from 'axios';
import { provinceAndCityData, regionData, provinceAndCityDataPlus, regionDataPlus, CodeToText, TextToCode } from 'element-china-area-data'
// Vue.prototype.$axios = axios
// Vue.prototype.$http = axios

Vue.use(ElementUI);
Vue.prototype.$echarts = echarts;
Vue.component(Button.name, Button);
Vue.component(Search.name, Search);
Vue.use(VueResource); 
Vue.use(iView);
Vue.use(Mint);
Vue.component(Navbar.name, Navbar);
Vue.component(TabItem.name, TabItem);
Vue.component(Header.name, Header);

Vue.prototype.$api = api;

Vue.config.productionTip = false


new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})



// import { Message } from 'element-ui';
// import 'element-ui/lib/theme-default/base.css';
// import 'element-ui/lib/theme-default/message.css';
// //由于Message组件并没有install 方法供Vue来操作的，是直接返回的，因此按照官方文档单独引入的方法是
// //会报错的，需要给 Message 添加 install 方法
// Message.install = function (Vue, options) {
//   Vue.prototype.$message = Message
// }
// Vue.use(Message )//消息提示



// vconsole控制台
// import Vconsole from 'vconsole';
// let vConsole = new Vconsole();
// export default vConsole;
// import myStore from '@/util/Store.vue';
// Vue.prototype.$myStore = myStore



// import axios from 'axios';
// import qs from 'qs';
// Vue.prototype.$http = axios;
// axios.defaults.baseURL = "http://127.0.0.1:8088";
// axios.defaults.timeout = 10000;
// axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';
// axios.defaults.transformRequest = data => qs.stringify(data);





// router.beforeEach((to, from, next) => {
// 	// if (to.meta.title) {
// 	//   document.title = to.meta.title
// 	// }
 
//   const type = from.meta.type;
//   // 判断该路由是否需要登录权限
//   if(type=='login'){
//     const member = JSON.parse(localStorage.getItem("member"));
//     if (member.roleId==1) {
//       next('/managerHome')
//     } else {
//       next()  // 确保一定要有next()被调用
//     }
//   }else{
//     next();
//   }
    
//   })
















// router.beforeEach((to, from, next) => {
// 	if (to.meta.title) {
// 	  document.title = to.meta.title
// 	}
// 	console.log("to.meta.title:",to.meta.title);
// 	const type = to.meta.type
// 	// 判断该路由是否需要登录权限
// 	if (type === 'login') {
// 	  if (window.localStorage.getItem('login')) {
// 		next()
// 	  } else {
// 		next('/login')
// 	  }
// 	} else {
// 	  next()  // 确保一定要有next()被调用
// 	}
//   })


// router.beforeEach((to,from,next)=>{
//     console.log(from.path);
//     console.log(to.path);
//     if(from.path == '/login' && to.path == '/personal'){
//       console.log("router的reload有执行吗");
//       // window.location.reload();
//       console.log("href之前",this.$myStore);
//       // window.location.href="/personal";
//       console.log("href之后",this.$myStore);
//     }else{
//       next();
//     }

// })
 


