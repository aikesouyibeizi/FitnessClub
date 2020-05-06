<script>
	//本地
	const baseURL = 'http://localhost:8088';

	
	//基本用户信息---通过登录时获取
	const memberId = '';//1
	const memberName = '';//杨柳
	const memberEmail = '';//邮箱
	const memberTel = '';
	const memberAddr ='';
	const memberAge = '';
	const memberGender = '';
	const memberWeight='';
	const memberHeight='';
	const memberGoal='';
	const courseId='';
	const roleId = '';//用户权限id:1-管理员；2-教练；3-普通会员
	const roleName = '';//用户权限名称
	
	// function createMember(memberId,memberName,memberEmail,
	// 		memberTel,memberAddr,memberAge,memberGender,memberWeight,
	// 		memberHeight,memberGoal,courseId,roleId,roleName){
	// 			var member=new Object();
	// 			member.memberName = memberName;
	// 			member.memberId = memberId;
	// 			member.memberEmail = memberEmail;
	// 			member.memberTel = memberTel;
	// 			member.memberAddr = memberAddr;
	// 			member.memberAge = memberAge;
	// 			member.memberGender = memberGender;
	// 			member.memberWeight = memberWeight;
	// 			member.memberHeight = memberHeight;
	// 			member.memberGoal = memberGoal;
	// 			member.courseId = courseId;
	// 			member.roleId = roleId;
	// 			member.roleName = roleName;
	// 			return member;
	// 		}
	
	
	export default {
		baseURL,		
		memberId,
		memberName,
		memberEmail, 
		memberTel, 
		memberAddr,
		memberAge,
		memberGender,
		memberWeight,
		memberHeight,
		memberGoal,
		courseId,
		roleId,
		roleName
		// data() {
		// 	return {
		// 		 memberId : '',//1
		// 		 memberName : '',//杨柳
		// 		 memberEmail : '',//邮箱
		// 		 memberTel :'',
		// 		 memberAddr :'',
		// 		 memberAge : '',
		// 		 memberGender : '',
		// 		 memberWeight:'',
		// 		 memberHeight:'',
		// 		 memberGoal:'',
		// 		 courseId:'',
		// 		 roleId :'',//用户权限id:1-管理员；2-教练；3-普通会员
		// 		 roleName :'',//用户权限名称
		// 	};
		// }

		
		

	};
	
	
// const member2 = createMember(this.memberId,this.memberName,this.memberEmail,this.memberTel,
// 	this.memberAddr,this.memberAge,this.memberGender,this.memberWeight,this.memberHeight,this.memberGoal,
// 	this.courseId,this.roleId,this.roleName);
	

// 	localStorage.setItem("member",this.member2);

// 	console.log("member里面有值吗",member2);
// 	console.log("memberName里面有值吗",memberName);
// 	console.log("memberId里面有值吗",memberId);
	
</script>

<style>
</style>
