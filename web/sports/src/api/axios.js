import axios from 'axios';
import qs from 'qs';

// Vue.prototype.$http = axios;

// var http = require('http');
// var server = http.createServer();
//=>基础全局配置
axios.defaults.baseURL = "http://127.0.0.1:8088";
axios.defaults.timeout = 10000;
// axios.defaults.withCredentials = true;
// 跨域
// axios.defaults.headers.post['Content-Type'] = 'application/json';
// axios.defaults.withCredentials = true
//=>POST请求，请求主体数据格式处理
axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.transformRequest = data => qs.stringify(data);

// axios.interceptors.response.use(response => {
// 	// IE 9
// 	if (response.data == null && response.config.responseType === 'JSON' && response.request.responseText != null) {
// 	  try {
// 		response.data = JSON.parse(response.request.responseText);
// 	  } catch (e) {
// 	  }
// 	}
// 	return response;
//   })
/* 
axios.interceptors.request.use(config => {
	//=>TOKEN处理
	let token = localStorage.getItem('token');
	token && (config.headers.Authorization = token);
	return config;
}, error => {
	return Promise.reject(error);
}); 
*/

// 跨域
// server.on('request', function(req, res) {
//     var params = qs.parse(req.url.substring(2));

//     // 向前台写cookie
//     res.writeHead(200, {
//         'Set-Cookie': 'l=a123456;Path=/;Domain=www.domain2.com;HttpOnly'   // HttpOnly:脚本无法读取
//     });

//     res.write(JSON.stringify(params));
//     res.end();
// });





// axios.interceptors.response.use(response => {
// 	//=>只拿到响应主体信息
// 	return response.data;
// }, error => {
// 	if (error.response) {
// 		switch (error.response.status) {
// 			//=>错误状态码处理
// 		}
// 	} else {
// 		if (!window.navigator.onLine) {
// 			//=>断网处理
// 			return;
// 		}
// 		return Promise.reject(error);
// 	}
// });
export default axios;