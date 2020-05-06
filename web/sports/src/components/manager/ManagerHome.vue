<template>
    <div class="managerHome">
    	<!-- Header -->
		<mt-header fixed title="首页管理导航">
		  <router-link to="/" slot="left">
		    <!-- <mt-button icon="back">返回</mt-button> -->
		  </router-link>
		</mt-header>
		<!-- Content -->
		<div class="content">
			<div class="title">
				管理选项
			</div>
			<div class="list" >
				<router-link class="item" :to="{path:'addMember'}">
					<i class="iconfont">&#xe633;</i>
					<span>添加会员</span>
				</router-link>
				<router-link class="item" :to="{path:'deleteMember'}">
					<i class="iconfont">&#xe804;</i>
					<span>删除会员</span>
				</router-link>
				<router-link class="item" :to="{path:'modifyMemberList'}">
					<i class="iconfont">&#xe709;</i>
					<span>修改会员</span>
				</router-link>
				<router-link class="item" :to="{path:'addCoach'}">
					<i class="iconfont">&#xe644;</i>
					<span>添加教练</span>
				</router-link>
				<router-link class="item" :to="{path:'deleteCoach'}">
					<i class="iconfont">&#xea9d;</i>
					<span>删除教练</span>
				</router-link>
				<router-link class="item" :to="{path:'modifyCoachList'}">
					<i class="iconfont">&#xe692;</i>
					<span>修改教练</span>
				</router-link>
				<router-link class="item" :to="{path:'addCourse'}">
					<i class="iconfont">&#xe8cd;</i>
					<span>添加课程</span>
				</router-link>
				<router-link class="item" :to="{path:'deleteCourse'}">
					<i class="iconfont">&#xe61e;</i>
					<span>删除课程</span>
				</router-link>
				<router-link class="item" :to="{path:'modifyCourseList'}">
					<i class="iconfont">&#xe501;</i>
					<span>修改课程</span>
				</router-link>
			</div>
			<div class="other">
				<div class="title">其他</div>
				<div class="list">
					<router-link class="item" :to="{path:'modifyManager'}">
						<i class="iconfont">&#xe69c;</i>
						<span>修改密码</span>
					</router-link>
					<router-link class="item" :to="{path:'login'}">
						<i class="iconfont">&#xe501;</i>
						<span>查看日志</span>
					</router-link>
					<router-link class="item" :to="{path:'login'}">
						<i class="iconfont">&#xe653;</i>
						<span>退出系统</span>
					</router-link>
					<div class="item">
						<i class="iconfont">&#xe61b;</i>
						<span>待扩充</span>
					</div>
					<div class="item">
						<i class="iconfont">&#xe61b;</i>
						<span>待扩充</span>
					</div>
					<div class="item">
						<i class="iconfont">&#xe61b;</i>
						<span>待扩充</span>
					</div>
				</div>
			</div>
		</div>

    </div>
</template>
<script>
export default {
    
}
</script>
<style>
@import "../../common/css/manager/managerHome.css";
@import "../../common/iconfont/iconfont.css";
</style>