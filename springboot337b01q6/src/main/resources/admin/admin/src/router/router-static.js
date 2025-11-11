import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import minsuxinxi from '@/views/modules/minsuxinxi/list'
	import dingdanquxiao from '@/views/modules/dingdanquxiao/list'
	import sensitivewords from '@/views/modules/sensitivewords/list'
	import syslog from '@/views/modules/syslog/list'
	import fangjianleixing from '@/views/modules/fangjianleixing/list'
	import forum from '@/views/modules/forum/list'
	import forumtype from '@/views/modules/forumtype/list'
	import yonghu from '@/views/modules/yonghu/list'
	import yudingdingdan from '@/views/modules/yudingdingdan/list'
	import chat from '@/views/modules/chat/list'
	import forumreport from '@/views/modules/forumreport/list'
	import fangdong from '@/views/modules/fangdong/list'
	import discussminsuxinxi from '@/views/modules/discussminsuxinxi/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '民宿公告',
		component: news
	}
	,{
		path: '/minsuxinxi',
		name: '民宿信息',
		component: minsuxinxi
	}
	,{
		path: '/dingdanquxiao',
		name: '订单取消',
		component: dingdanquxiao
	}
	,{
		path: '/sensitivewords',
		name: '敏感词',
		component: sensitivewords
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/fangjianleixing',
		name: '房间类型',
		component: fangjianleixing
	}
	,{
		path: '/forum',
		name: '交流论坛',
		component: forum
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/yudingdingdan',
		name: '预定订单',
		component: yudingdingdan
	}
	,{
		path: '/chat',
		name: '在线客服',
		component: chat
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/fangdong',
		name: '房东',
		component: fangdong
	}
	,{
		path: '/discussminsuxinxi',
		name: '民宿信息评论',
		component: discussminsuxinxi
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '民宿公告分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
