import axios from 'axios';
import qs from 'qs';
//=>基础全局配置
axios.defaults.baseURL = "http://127.0.0.1:8088";
axios.defaults.timeout = 10000;
axios.defaults.withCredentials = true;
//=>POST请求，请求主体数据格式处理
axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.transformRequest = data => qs.stringify(data);
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
axios.interceptors.response.use(response => {
	//=>只拿到响应主体信息
	return response.data;
}, error => {
	if (error.response) {
		switch (error.response.status) {
			//=>错误状态码处理
		}
	} else {
		if (!window.navigator.onLine) {
			//=>断网处理
			return;
		}
		return Promise.reject(error);
	}
});
export default axios;