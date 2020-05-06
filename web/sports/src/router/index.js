import Vue from 'vue'
import Router from 'vue-router'
import Info from '@/components/Info.vue';
import Login from '@/components/Login.vue';
import Register from '@/components/Register.vue';
import Home from '@/components/Home.vue';
import Course from '@/components/Course.vue';
import Exercise from '@/components/Exercise.vue';
import BasicInfo from '@/components/infoPage/BasicInfo.vue';
import Faq from '@/components/infoPage/Faq.vue';
import Answer from '@/components/infoPage/Answer.vue';
import Addr from '@/components/infoPage/Addr.vue';
import ModifyAddr from '@/components/infoPage/ModifyAddr.vue';
import CourseDetail from '@/components/course/CourseDetail.vue';
import OrderComfirm from '@/components/course/OrderComfirm.vue';
import OrderList from '@/components/order/OrderList.vue';
import WeightChart from '@/components/record/WeightChart.vue';
import ImgList from '@/components/record/ImgList.vue';
import ManagerHome from '@/components/manager/ManagerHome.vue';
import AddMember from '@/components/manager/AddMember.vue';
import DeleteMember from '@/components/manager/DeleteMember.vue';
import ModifyMember from '@/components/manager/ModifyMember.vue';
import ModifyMemberList from '@/components/manager/ModifyMemberList.vue';
import AddCoach from '@/components/manager/AddCoach.vue';
import DeleteCoach from '@/components/manager/DeleteCoach.vue';
import ModifyCoachList from '@/components/manager/ModifyCoachList.vue';
import ModifyCoach from '@/components/manager/ModifyCoach.vue';
import AddCourse from '@/components/manager/AddCourse.vue';
import DeleteCourse from '@/components/manager/DeleteCourse.vue';
import ModifyCourseList from '@/components/manager/ModifyCourseList.vue';
import ModifyCourse from '@/components/manager/ModifyCourse.vue';
import ModifyManager from '@/components/manager/ModifyManager.vue';
import Environment from '@/components/home/Environment.vue';
import Sports from '@/components/home/Sports.vue';

 Vue.use(Router);
 export default new Router({
	mode: "hash",
	routes: [
	{path: '/',redirect: '/personal', meta: {keepAlive: true}}, 
	{path: '/personal',name: 'personal',component: Info, meta: {keepAlive: true}}, 
	{path: '/login',name: 'login',component: Login, meta: {keepAlive: false,type:'login'}}, 
	{path: '/register',name: 'register',component: Register, meta: {keepAlive: false}},
	{path: '/home',name: 'home',component: Home, meta: {keepAlive: true,type:'login'}},
	{path: '/course',name: 'course',component: Course, meta: {keepAlive: true}},
	{path: '/exercise',name: 'exercise',component: Exercise, meta: {keepAlive: true}},
	{path: '/basicInfo',name: 'basicInfo',component: BasicInfo, meta: {keepAlive: false}},
	{path: '/faq',name: 'faq',component: Faq, meta: {keepAlive: false}},
	{path: '/answer',name: 'answer',component: Answer, meta: {keepAlive: false}},
	{path: '/addr',name: 'addr',component: Addr, meta: {keepAlive: false}},
	{path: '/modifyAddr',name: 'modifyAddr',component: ModifyAddr, meta: {keepAlive: false}},
	{path: '/courseDetail',name: 'courseDetail',component: CourseDetail, meta: {keepAlive: false}},
	{path: '/orderComfirm',name: 'orderComfirm',component: OrderComfirm, meta: {keepAlive: false}},
	{path: '/orderList',name: 'orderList',component: OrderList, meta: {keepAlive: false}},
	{path: '/weightChart',name: 'weightChart',component: WeightChart, meta: {keepAlive: false}},
	{path: '/imgList',name: 'imgList',component: ImgList, meta: {keepAlive: false}},
	{path: '/managerHome',name: 'managerHome',component: ManagerHome, meta: {keepAlive: false,isManager:true,type:'login'}},
	{path: '/addMember',name: 'addMember',component: AddMember, meta: {keepAlive: false}},
	{path: '/deleteMember',name: 'deleteMember',component: DeleteMember, meta: {keepAlive: false}},
	{path: '/modifyMember',name: 'modifyMember',component: ModifyMember, meta: {keepAlive: false}},
	{path: '/modifyMemberList',name: 'modifyMemberList',component: ModifyMemberList, meta: {keepAlive: false}},
	{path: '/addCoach',name: 'addCoach',component:AddCoach, meta: {keepAlive: false}},
	{path: '/deleteCoach',name: 'deleteCoach',component:DeleteCoach, meta: {keepAlive: false}},
	{path: '/modifyCoachList',name: 'modifyCoachList',component:ModifyCoachList, meta: {keepAlive: false}},
	{path: '/modifyCoach',name: 'modifyCoach',component:ModifyCoach, meta: {keepAlive: false}},
	{path: '/addCourse',name: 'addCourse',component:AddCourse, meta: {keepAlive: false}},
	{path: '/deleteCourse',name: 'deleteCourse',component:DeleteCourse, meta: {keepAlive: false}},
	{path: '/modifyCourseList',name: 'modifyCourseList',component:ModifyCourseList, meta: {keepAlive: false}},
	{path: '/modifyCourse',name: 'modifyCourse',component:ModifyCourse, meta: {keepAlive: false}},
	{path: '/modifyManager',name: 'modifyManager',component:ModifyManager, meta: {keepAlive: false}},
	{path: '/environment',name: 'environment',component:Environment, meta: {keepAlive: false}},
	{path: '/sports',name: 'sports',component:Sports, meta: {keepAlive: false}},
	{path: '*',redirect: '/personal'}
	]
});





