import axios from './axios';
import md5 from 'blueimp-md5';
export default {
	phone(phone) {
		return axios.post('/user/phone', {
			phone
		});
	},
	code(phone) {
		return axios.post('/user/code', {
			phone
		});
	},
	checkCode(phone, code) {
		return axios.post('/user/checkCode', {
			phone,
			//=>对于验证码或者密码这些东西都要传输加密（MD5不可逆转的加密）
			//=>1)MD5靠不住（网上有碰撞检测数据解密的方式），服务器都要二次加密
			//=>2)服务器生成验证码的时候，数据库中存储的就是MD5再二次加密的结果
			code: md5(code)
		});
	},
	register(options = {}) {
		return axios.post('/user/register', options);
	},
	loginPOST(account, password, type = 1) {
		return axios.post('/user/login', {
			account,
			password: md5(password),
			type
		});
	}
};