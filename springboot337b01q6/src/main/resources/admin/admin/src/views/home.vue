<template>
	<div class="home-content">
		<!-- title -->
		<div id="home-title" class="home-title animate__animated">
			<div class="titles" >
				<span>欢迎使用</span>
				{{this.$project.projectName}}
			</div>
		</div>
		<!-- statis -->
		<div class="statis-box">
			<div id="statis1" class="statis1 animate__animated" v-if="isAuth('minsuxinxi','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-zhangjie8"></span>
				</div>
				<div class="right">
					<div class="num">{{minsuxinxiCount}}</div>
					<div class="name">民宿信息总数</div>
				</div>
			</div>
			<div id="statis2" class="statis2 animate__animated" v-if="isAuth('yudingdingdan','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-chujia3"></span>
				</div>
				<div class="right">
					<div class="num">{{yudingdingdanCount}}</div>
					<div class="name">预定订单总数</div>
				</div>
			</div>
			<div id="statis3" class="statis3 animate__animated" v-if="isAuth('dingdanquxiao','首页总数')">
				<div class="left">
					<span class="icon iconfont icon-qita3"></span>
				</div>
				<div class="right">
					<div class="num">{{dingdanquxiaoCount}}</div>
					<div class="name">订单取消总数</div>
				</div>
			</div>
		</div>
		<!-- statis -->
		<!-- 日历 -->
		<div id="calendar" class="calendar animate__animated">
			<div class="option">
				<div class="pyear" @click="pyear"><span class="icon iconfont icon-fanhui"></span>上一年</div>
				<div class="pmonth" @click="pmonth"><span class="icon iconfont icon-fanhui"></span>上一月</div>
				<div class="date-box">
					<div class="year">{{this.year}}年</div>
					<div class="month">{{this.month}}月</div>
				</div>
				<div class="nmonth" @click="nmonth">下一月<span class="icon iconfont icon-jinru"></span></div>
				<div class="nyear" @click="nyear">下一年<span class="icon iconfont icon-jinru"></span></div>
			</div>
			<table v-if="this.weeks.length">
				<thead>
					<tr>
						<th v-for="item,index in this.heads" :key="index">{{item}}</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="week,index in this.weeks" :key="index">
						<td v-for="day,key in week.days" :key="key" :class="{other: day.isOther, festival: day.isFestival, today: day.isToday, rest: day.isRest}">
							<div class="text">
								<div class="new">{{day.day}}</div>
								<div class="old">{{day.text}}</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<!-- echarts -->
		<!-- 4 -->
		<div class="type4">
			<div id="minsuxinxiChart1" class="echarts1 animate__animated" v-if="isAuth('minsuxinxi','首页统计')"></div>
			<div id="yudingdingdanChart1" class="echarts2 animate__animated" v-if="isAuth('yudingdingdan','首页统计')"></div>
			<div id="yudingdingdanChart2" class="echarts3 animate__animated" v-if="isAuth('yudingdingdan','首页统计')"></div>
			<div id="dingdanquxiaoChart1" class="echarts4 animate__animated" v-if="isAuth('dingdanquxiao','首页统计')"></div>
		</div>
	</div>
</template>
<script>
import 'animate.css'
//4
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
			minsuxinxiCount: 0,
			yudingdingdanCount: 0,
			dingdanquxiaoCount: 0,
			// 日历
			year: 2023,
			month: 6,
			heads: ['一', '二', '三', '四', '五', '六', '日'],
			weeks: [],
			now: Solar.fromDate(new Date()),
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#7BD0CB","#00949F","#0097E6","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"showSymbol":true,"symbol":"emptyCircle","symbolSize":4},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#7BD0CB","#00949F","#0097E6","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"colorBy":"data","barCategoryGap":"20%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":false,"interval":2000}},
			pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#7BD0CB","#00949F","#0097E6","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":14,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":0,"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#666","color":"inherit","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#666","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			funnel: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#7BD0CB","#00949F","#0097E6","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"center","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#666","textShadowColor":"transparent","fontSize":14,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			boardBase: {"funnelNum":8,"lineNum":8,"gaugeNum":8,"barNum":8,"pieNum":8},
			gauge: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#7BD0CB","#00949F","#0097E6","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"top":"top","left":"left","textStyle":{"fontSize":14,"lineHeight":24,"color":"#333","fontWeight":600}},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":25,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#fff","borderRadius":3,"width":20,"fontSize":12,"height":10},"title":{"fontSize":14},"animation":true}},
		};
	},
	mounted(){
		this.init();
		this.getminsuxinxiCount();
		if(this.isAuth('minsuxinxi','首页统计')){
			this.minsuxinxiChat1();
		}
		this.getyudingdingdanCount();
		if(this.isAuth('yudingdingdan','首页统计')){
			this.yudingdingdanChat1();
		}
		if(this.isAuth('yudingdingdan','首页统计')){
			this.yudingdingdanChat2();
		}
		this.getdingdanquxiaoCount();
		if(this.isAuth('dingdanquxiao','首页统计')){
			this.dingdanquxiaoChat1();
		}
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
	},
	computed: {
		avatar(){
			return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
		},
	},
	methods:{
		handleScroll() {
			let arr = [
				{id:'home-title',css:'animate__fadeInUp'},
				{id:'statis1',css:'animate__fadeInUp'},
				{id:'statis2',css:'animate__fadeInUp'},
				{id:'statis3',css:'animate__fadeInUp'},
				{id:'calendar',css:'animate__fadeInUp'},
				{id:'minsuxinxiChart1',css:'animate__fadeInUp'},
				{id:'yudingdingdanChart1',css:'animate__fadeInUp'},
				{id:'yudingdingdanChart2',css:'animate__fadeInUp'},
				{id:'dingdanquxiaoChart1',css:'animate__fadeInUp'},
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
		// 统计图动画
		myChartInterval(type, xAxisData, seriesData, myChart) {
			this.$nextTick(() => {
				setInterval(() => {
					let xAxis = xAxisData.shift()
					xAxisData.push(xAxis)
					let series = seriesData.shift()
					seriesData.push(series)
				
					if (type == 1) {
						myChart.setOption({
							xAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
					if (type == 2) {
						myChart.setOption({
							yAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
				}, $template2.back.board.bar.base.interval);
			})
		},
		init(){
			if(this.$storage.get('Token')){
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code != 0) {
						router.push({ name: 'login' })
					}
				});
			}else{
				router.push({ name: 'login' })
			}
			this.$nextTick(() => {
				// --- 日历 ---
				this.year = this.now.getYear()
				this.month = this.now.getMonth()
				this.weeks = this.render(this.year, this.month);
			})
		},
		// 日历
		nyear() {
			this.year = this.year + 1
			this.weeks = this.render(this.year, this.month)
		},
		pyear() {
			this.year = this.year - 1
			this.weeks = this.render(this.year, this.month)
		},
		nmonth() {
			this.month = this.month + 1
			if (this.month > 12) {
				this.month = 1
				this.year = this.year + 1
			}
			this.weeks = this.render(this.year, this.month)
		},
		pmonth() {
			this.month = this.month - 1
			if (this.month < 1) {
				this.month = 12
				this.year = this.year - 1
			}
			this.weeks = this.render(this.year, this.month)
		},
		// 日历
		render(year, month, weekStart = 1) {
			let months = SolarMonth.fromYm(year, month)
			let weeks = []
		
			months.getWeeks(weekStart).forEach(w => {
				let week = {
					index: 0,
					days: []
				}
				week.index = w.getIndexInYear()
				let days = []
				w.getDays().forEach(d => {
					days.push(this.buildDay(d, month))
				})
				week.days = days
				weeks.push(week)
			})
			return weeks
		},
		buildDay(d, month) {
			let lunar = d.getLunar()
			let day = {
				day: 0,
				text: '',
				isFestival: false,
				isToday: false,
				isOther: false,
				isHoliday: false,
				isRest: false
			}
			day.day = d.getDay()
			let text = lunar.getDayInChinese()
			if (1 === d.getDay()) {
				text = lunar.getMonthInChinese() + '月'
			}
			// let otherFestivals = d.getOtherFestivals()
			// if (otherFestivals.length > 0) {
			// 	text = otherFestivals[0]
			// 	day.isFestival = true
			// }
			// otherFestivals = lunar.getOtherFestivals()
			// if (otherFestivals.length > 0) {
			// 	text = otherFestivals[0]
			// 	day.isFestival = true
			// }
			let festivals = d.getFestivals()
			if (festivals.length > 0) {
				text = festivals[0]
				day.isFestival = true
			}
			festivals = lunar.getFestivals()
			if (festivals.length > 0) {
				text = festivals[0]
				day.isFestival = true
			}
			let jq = lunar.getJieQi()
			if (jq) {
				text = jq
				day.isFestival = true
			}
			day.text = text
			if (d.toYmd() === this.now.toYmd()) {
				day.isToday = true
			}
			if (d.getMonth() !== month) {
				day.isOther = true
			}
			let h = HolidayUtil.getHoliday(d.getYear(), d.getMonth(), d.getDay())
			if (h) {
				day.isHoliday = true
				day.isRest = !h.isWork()
			}
			return day
		},
		// 日历
		getminsuxinxiCount() {
			this.$http({
				url: `minsuxinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.minsuxinxiCount = data.data
				}
			})
		},
// 1234 饼3
		minsuxinxiChat1() {
			this.$nextTick(()=>{

				var minsuxinxiChart1 = echarts.init(document.getElementById("minsuxinxiChart1"),'macarons');
				this.$http({
					url: "minsuxinxi/group/fangjianleixing",
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.pieNum){
								break;
							}
							xAxis.push(res[i].fangjianleixing);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].fangjianleixing
							})
						}
						var option = {};
						let titleObj = this.pie.title
						titleObj.text = '房间类型'
						
						const legendObj = this.pie.legend
						let tooltipObj = {trigger: 'item',formatter: '{b} : {c} ({d}%)'}
						tooltipObj = Object.assign(tooltipObj , this.pie.tooltip?this.pie.tooltip:{})
						
						let seriesObj = {
							type: 'pie',
							radius: ['25%', '55%'],
							roseType: 'area',
							center: ['50%', '60%'],
							data: pArray,
							emphasis: {
								itemStyle: {
									shadowBlur: 10,
									shadowOffsetX: 0,
									shadowColor: 'rgba(0, 0, 0, 0.5)'
								}
							}
						}
						seriesObj = Object.assign(seriesObj , this.pie.series)
						const gridObj = this.pie.grid
						option = {
							backgroundColor: this.pie.backgroundColor,
							color: this.pie.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						minsuxinxiChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							minsuxinxiChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


		getyudingdingdanCount() {
			this.$http({
				url: `yudingdingdan/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.yudingdingdanCount = data.data
				}
			})
		},
// 1234 竖
		yudingdingdanChat1() {
			this.$nextTick(()=>{

				var yudingdingdanChart1 = echarts.init(document.getElementById("yudingdingdanChart1"),'macarons');
				this.$http({
					url: `yudingdingdan/value/yuyueshijian/zongjine`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.barNum){
								break;
							}
							xAxis.push(res[i].yuyueshijian);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].yuyueshijian
							})
						}
						var option = {};
						let titleObj = this.bar.title
						titleObj.text = '日金额'
						
						const legendObj = this.bar.legend
						let tooltipObj = {trigger: 'item',formatter: '{b} : {c}'}
						tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
				
						let xAxisObj = this.bar.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis
						
						let yAxisObj = this.bar.yAxis
						yAxisObj.type = 'value'
						let seriesObj = {
							data: yAxis,
							type: 'bar',
						}
						seriesObj = Object.assign(seriesObj , this.bar.series)
						const gridObj = this.bar.grid
						
						option = {
							backgroundColor: this.bar.backgroundColor,
							color: this.bar.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						yudingdingdanChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							yudingdingdanChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},

		yudingdingdanChat2() {
			this.$nextTick(()=>{

				var yudingdingdanChart2 = echarts.init(document.getElementById("yudingdingdanChart2"),'macarons');
				this.$http({
					url: `yudingdingdan/value/yuyueshijian/zongjine/月`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.barNum){
								break;
							}
							xAxis.push(res[i].yuyueshijian);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].yuyueshijian
							})
						}
						var option = {};
						let titleObj = this.bar.title
						titleObj.text = '月金额'
						
						const legendObj = this.bar.legend
						let tooltipObj = {trigger: 'item',formatter: '{b} : {c}'}
						tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
				
						let xAxisObj = this.bar.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis
						
						let yAxisObj = this.bar.yAxis
						yAxisObj.type = 'value'
						let seriesObj = {
							data: yAxis,
							type: 'bar',
						}
						seriesObj = Object.assign(seriesObj , this.bar.series)
						const gridObj = this.bar.grid

						option = {
							backgroundColor: this.bar.backgroundColor,
							color: this.bar.color,
							title: titleObj,
							legend: legendObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: [seriesObj],
							grid: gridObj
						};
						// 使用刚指定的配置项和数据显示图表。
						yudingdingdanChart2.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							yudingdingdanChart2.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},

		getdingdanquxiaoCount() {
			this.$http({
				url: `dingdanquxiao/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.dingdanquxiaoCount = data.data
				}
			})
		},
// 1234 折
		dingdanquxiaoChat1() {
			this.$nextTick(()=>{

				var dingdanquxiaoChart1 = echarts.init(document.getElementById("dingdanquxiaoChart1"),'macarons');
				this.$http({
					url: `dingdanquxiao/value/minsumingcheng/zongjine`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.lineNum){
								break;
							}
							xAxis.push(res[i].minsumingcheng);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].minsumingcheng
							})
						}
						var option = {};
						let titleObj = this.line.title
						titleObj.text = '取消统计'
						
						const legendObj = this.line.legend
						let tooltipObj = { trigger: 'item',formatter: '{b} : {c}'}
						tooltipObj = Object.assign(tooltipObj , this.line.tooltip?this.line.tooltip:{})
						let xAxisObj = this.line.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis
						
						let yAxisObj = this.line.yAxis
						yAxisObj.type = 'value'
						const gridObj = this.line.grid
						
						let seriesObj = {
							data: yAxis,
							type: 'line',
						}
						seriesObj = Object.assign(seriesObj , this.line.series)
						option = {
							backgroundColor: this.line.backgroundColor,
							color: this.line.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						dingdanquxiaoChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							dingdanquxiaoChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


	}
};
</script>
<style lang="scss" scoped>
	.home-content {
		padding: 10px 0;
		background: url(http://codegen.caihongy.cn/20250403/b9291b8534264f6abe80ae3764c553d2.png) no-repeat center top / cover;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: flex-start;
		flex-wrap: wrap;
		.home-title {
			border-radius: 5px;
			padding: 10px 0;
			box-shadow: 0 0px 0px rgba(0,0,0,.3);
			margin: 20px 0;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			transition: 0.3s;
			.titles {
				padding: 0;
				color: #333;
				font-weight: 600;
				font-size: 32px;
				line-height: 44px;
				span {
				}
			}
		}
		.home-title:hover {
			transform: translate3d(0, 0px, 0);
			z-index: 1;
			background: rgba(255,255,255,.12);
		}
		.statis-box {
			padding: 0 10px;
			margin: 0;
			display: flex;
			width: 770px;
			justify-content: flex-start;
			align-items: flex-start;
			flex-wrap: wrap;
			.statis1 {
				border: 1px solid #CACACA;
				border-radius: 0;
				padding: 10px;
				margin: 0;
				background: #fff;
				display: flex;
				width: 185px;
				transition: 0.3s;
				height: 177px;
				.left {
					border-radius: 100%;
					background: #e9f0f9;
					display: none;
					width: 66px;
					justify-content: center;
					align-items: center;
					height: 66px;
					.iconfont {
						color: #2582f3;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis1:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis2 {
				border: 1px solid #CACACA;
				border-radius: 0;
				padding: 10px;
				margin: 0;
				background: #fff;
				display: flex;
				width: 185px;
				transition: 0.3s;
				height: 177px;
				.left {
					border-radius: 100%;
					background: #fcece1;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #f56c17;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis2:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis3 {
				border: 1px solid #CACACA;
				border-radius: 0;
				padding: 10px;
				margin: 0 0 0 10px;
				background: #fff;
				display: flex;
				width: 185px;
				transition: 0.3s;
				height: 177px;
				.left {
					border-radius: 100%;
					background: #e7fbfd;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #21c2f6;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis3:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis4 {
				border: 1px solid #CACACA;
				border-radius: 0;
				padding: 10px;
				margin: 0;
				background: #fff;
				display: flex;
				width: 185px;
				transition: 0.3s;
				height: 177px;
				.left {
					border-radius: 100%;
					background: #e0ffe9;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #45d45a;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis4:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.statis5 {
				border: 1px solid #CACACA;
				border-radius: 0;
				padding: 10px;
				margin: 0;
				background: #fff;
				display: flex;
				width: 185px;
				transition: 0.3s;
				height: 177px;
				.left {
					border-radius: 100%;
					background: #fbe8db;
					display: none;
					width: 60px;
					justify-content: center;
					align-items: center;
					height: 60px;
					.iconfont {
						color: #d26515;
						font-size: 40px;
					}
				}
				.right {
					flex-direction: column;
					display: flex;
					width: 160px;
					justify-content: center;
					align-items: center;
					.num {
						margin: 5px 0;
						color: #333;
						font-weight: bold;
						font-size: 30px;
						line-height: 24px;
						height: 24px;
					}
					.name {
						margin: 5px 0;
						color: #666;
						font-size: 15px;
						line-height: 24px;
						height: 24px;
						order: -1;
					}
				}
			}
			.statis5:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
		}
		.calendar {
			border: 0px solid #ccc;
			border-radius: 0px;
			box-shadow: 0 0px 0px rgba(0,0,0,.1);
			margin: 0 10px 0 0 ;
			background: #fff;
			width: calc(100% - 780px);
			transition: 0.3s;
			height: auto;
			.option {
				padding: 10px 20px;
				color: #157ed2;
				background: #fff;
				display: flex;
				width: 100%;
				font-size: 16px;
				justify-content: space-between;
				flex-wrap: wrap;
				height: auto;
				.pyear {
					cursor: pointer;
					border-radius: 4px;
					padding: 0 12px;
					color: inherit;
					background: none;
					font-weight: 600;
					display: flex;
					width: auto;
					font-size: inherit;
					justify-content: center;
					align-items: center;
					height: 40px;
					.iconfont {
						margin: 0 2px;
						color: inherit;
						display: none;
						font-size: inherit;
					}
				}
				.pyear:hover {
					opacity: 0.8;
				}
				.pmonth {
					cursor: pointer;
					border-radius: 4px;
					padding: 0 12px;
					color: inherit;
					background: none;
					font-weight: 600;
					display: flex;
					width: auto;
					font-size: inherit;
					justify-content: center;
					align-items: center;
					height: 40px;
					.iconfont {
						margin: 0 2px;
						color: inherit;
						display: none;
						font-size: inherit;
					}
				}
				.pmonth:hover {
					opacity: 0.8;
				}
				.date-box {
					padding: 0 10px;
					display: flex;
					justify-content: center;
					align-items: center;
					.year {
						margin: 0 2px;
						color: inherit;
						font-size: 24px;
					}
					.month {
						margin: 0 2px;
						color: inherit;
						font-size: 24px;
					}
				}
				.nmonth {
					cursor: pointer;
					border-radius: 4px;
					padding: 0 12px;
					color: inherit;
					background: none;
					font-weight: 600;
					display: flex;
					width: auto;
					font-size: inherit;
					justify-content: center;
					align-items: center;
					height: 40px;
					.iconfont {
						margin: 0 2px;
						color: inherit;
						display: none;
						font-size: 16px;
					}
				}
				.nmonth:hover {
					opacity: 0.8;
				}
				.nyear {
					cursor: pointer;
					border-radius: 4px;
					padding: 0 12px;
					color: inherit;
					background: none;
					font-weight: 600;
					display: flex;
					width: auto;
					font-size: inherit;
					justify-content: center;
					align-items: center;
					height: 40px;
					.iconfont {
						margin: 0 2px;
						color: inherit;
						display: none;
						font-size: inherit;
					}
				}
				.nyear:hover {
					opacity: 0.8;
				}
			}
			table {
				border-radius: 0px;
				padding: 0;
				background: #fff;
				width: 100%;
				heith: auto;
				thead {
					width: 100%;
					heith: auto;
					tr {
						display: flex;
						width: 100%;
						heith: auto;
						justify-content: center;
						align-items: center;
						th {
							color: #666;
							flex: 1;
							display: flex;
							font-size: 16px;
							line-height: 40px;
							justify-content: center;
							align-items: center;
						}
					}
				}
				tbody {
					width: 100%;
					heith: auto;
					tr {
						display: flex;
						width: 100%;
						heith: auto;
						justify-content: center;
						align-items: center;
						td {
							cursor: pointer;
							padding: 0px 15px 0;
							flex: 1;
							display: flex;
							height: auto;
							.text {
								border-radius: 4px;
								flex-direction: column;
								background: #fff;
								display: flex;
								width: 100%;
								justify-content: center;
								align-items: center;
								height: 100%;
							}
							.text:hover {
								background: rgba(64, 158, 255,.1);
							}
							.text .new {
								color: #000;
								font-size: 20px;
								line-height: 1.4;
							}
							.text .old {
								color: #666;
								font-size: 14px;
								line-height: 1.4;
							}
						}
						td.festival {
							.text {
								border-radius: 4px;
								flex-direction: column;
								background: rgba(64, 158, 255,.1);
								display: flex;
								width: 100%;
								justify-content: center;
								align-items: center;
								height: 100%;
							}
							.text:hover {
								background: rgba(64, 158, 255,.2);
							}
							.text .new {
								color: #000;
								font-size: 24px;
								line-height: 1.4;
							}
							.text .old {
								color: #666;
								font-size: 16px;
								line-height: 1.4;
							}
						}
						td.other {
							.text {
								border-radius: 4px;
								padding: 0 0 10px;
								flex-direction: column;
								background: #fff;
								display: flex;
								width: 100%;
								justify-content: center;
								align-items: center;
								opacity: 0.3;
								height: 100%;
							}
							.text:hover {
								background: none;
							}
							.text .new {
								color: #000;
								font-size: 20px;
								line-height: 1.4;
							}
							.text .old {
								color: #666;
								font-size: 14px;
								line-height: 1.4;
							}
						}
						td.today {
							.text {
								border-radius: 4px;
								flex-direction: column;
								color: #fff;
								background: rgba(64, 158, 255,.6);
								display: flex;
								width: 100%;
								justify-content: center;
								align-items: center;
								height: 100%;
							}
							.text:hover {
								background: rgba(64, 158, 255,.5);
							}
							.text .new {
								color: inherit;
								font-size: 20px;
								line-height: 1.4;
							}
							.text .old {
								color: inherit;
								font-size: 14px;
								line-height: 1.4;
							}
						}
					}
				}
			}
		}
		.calendar:hover {
			transform: translate3d(0, 0px, 0);
			z-index: 1;
		}
		// echarts4
		.type4 {
			padding: 0;
			align-content: flex-start;
			background: none;
			display: flex;
			width: 100%;
			justify-content: space-between;
			flex-wrap: wrap;
			height: auto;
			.echarts1 {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 20px;
				margin: 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 400px;
			}
			.echarts1:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.echarts2 {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 20px;
				margin: 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 400px;
			}
			.echarts2:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.echarts3 {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 20px;
				margin: 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 400px;
			}
			.echarts3:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
			.echarts4 {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 20px;
				margin: 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 400px;
			}
			.echarts4:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
				background: rgba(255,255,255,1);
			}
		}
	}
	
	.echarts-flag-2 {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		padding: 10px 20px;
		background: rebeccapurple;
	
		&>div {
			width: 32%;
			height: 300px;
			margin: 10px 0;
			background: rgba(255,255,255,.1);
			border-radius: 8px;
			padding: 10px 20px;
		}
	}
	.animate__animated {
		animation-fill-mode: none;
	}
</style>
