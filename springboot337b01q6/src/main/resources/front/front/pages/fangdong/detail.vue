
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"minHeight":"100vh","width":"100%","padding":"0","position":"relative","background":"#f8f8f8","height":"auto"}'>
			<swiper :style='{"width":"100%","background":"#fff","height":"440rpx","zIndex":"0"}' class="swiper" :indicator-dots='false' :autoplay='false' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","background":"#fff","height":"440rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"440rpx"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper" @tap="imgView(swiper)"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"440rpx"}' mode="aspectFill" v-else :src="baseUrl+swiper" @tap="imgView(baseUrl+swiper)"></image>
				</swiper-item>
			</swiper>
			<view :style='{"alignContent":"flex-start","padding":"24rpx","margin":"0 auto","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20241110/41bb20fa3b804b2191d135a6f8653ad5.png) no-repeat center top / 100% auto","display":"flex","width":"100%","position":"relative","height":"auto","zIndex":"9"}' class="detail-content">

				<view :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="lable">民宿名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.minsumingcheng}}</view>
				</view>
				<view :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="lable">法人：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.faren}}</view>
				</view>

				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>联系方式：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' style="text-decoration: underline" @tap="callClick(detail.lianxifangshi)" >{{detail.lianxifangshi}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>民宿地址：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.minsudizhi}}</view>
				</view>




				<view v-if="userid" class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>审核状态：</view>
					<view v-if="detail.sfsh=='是'" class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>通过</view>
					<view v-if="detail.sfsh=='否'" class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>不通过</view>
					<view v-if="detail.sfsh=='待审核'" class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>待审核</view>
				</view>
				<view v-if="userid" class="detail-list-item" :style='{"padding":"0 20rpx","margin":"0","borderColor":"#ccc","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>审核回复</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.shhf}}</view>
				</view>




				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"0","margin":"40rpx auto","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"flex-end","height":"auto","order":"20"}'>

					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#03b882","borderRadius":"8rpx","background":"#c8dbd5","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="userid&&isAuth('fangdong','审核')" @tap="onSHTap">审核</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#03b882","borderRadius":"8rpx","background":"#c8dbd5","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('fangdong','审核')" @tap="onSHTap">审核</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#03b882","borderRadius":"8rpx","background":"#c8dbd5","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="userid&&isAuth('fangdong','私聊')" @tap="chatClick">私聊</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#03b882","borderRadius":"8rpx","background":"#c8dbd5","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('fangdong','私聊')" @tap="chatClick">私聊</button>
					
				</view>
			</view>
		</view>
		<!-- 确认完成弹窗 -->
		<uni-popup class="popup-content" ref="popup" type="center">
			<form class="popup-form" style="background: #fff;width: 300px;display: block;border-radius: 10px;padding: 20px;text-align: center;">
				<view class=" margin-top" style="border: 1px solid #666;line-height: 30px;border-radius: 5px;margin-bottom: 10px">
					<picker @change="sfshChange" :value="sfshIndex" :range="sfshOptions">
						<view class="uni-input">{{detail.sfsh?detail.sfsh:'选择审核结果'}}</view>
					</picker>
				</view>
				<view class="" style="border: 1px solid #666;border-radius: 5px;margin-bottom: 10px;text-align: left;padding: 10px">
					<!-- <view class="title">审核回复</view> -->
					<textarea style="width: 200px;" v-model="detail.shhf" placeholder="审核回复"></textarea>
					<!-- <input v-model="douyinId" placeholder="审核回复" name="input"></input> -->
				</view>
				<view class="btn-content">
					<button style="margin: 0 10px" @tap="onCloseWinTap" class="cu-btn bg-cyan">取消</button>
					<button style="margin: 0 10px" @tap="onFinishTap" class="cu-btn bg-red">确认</button>
				</view>
			</form>
		</uni-popup>
	</view>
</mescroll-uni>
	<uni-popup class="popup-content" ref="chatPopup" type="bottom" :maskClick="true" @change="clearChat">
		<view class="popup-chat">
			<view class="chat-content" id="chat-content">
				<view v-bind:key="item.id" v-for="item in chatList">
					<div v-if="item.addtime" style="width: 100%;text-align: center;font-size: 10px;color: #666;">{{timeFormat(item.addtime)}}</div>
					<view v-if="item.uid==user.id" class="right-content">
						<view v-if="item.format==1" class="text-content">{{item.content}}</view>
						<img v-else :src="item.content?baseUrl + item.content:''" @click="preViewImg(baseUrl + item.content)"
							style="width: 100px;height: 100px;object-fit: cover;" />
						<img :src="mpic?baseUrl + mpic:''" alt=""
							style="width: 40px;border-radius: 50%;height: 40px;margin: 0 0 0 10px;object-fit: cover;" />
					</view>
					<view v-else class="left-content">
						<img :src="fpic?baseUrl + fpic:''" alt=""
							style="width: 40px;border-radius: 50%;height: 40px;margin: 0 10px 0 0;object-fit: cover;" />
						<view v-if="item.format==1" class="text-content">{{item.content}}</view>
						<img v-else :src="item.content?baseUrl + item.content:''" @click="preViewImg(baseUrl + item.content)"
							style="width: 100px;height: 100px;object-fit: cover;" />
					</view>
					<view class="clear-float"></view>
				</view>
			</view>
			<view style="">
				<input v-model="chatForm.content" placeholder="请输入内容" confirm-type="send" @confirm="addChat"
					style="width: calc(100% - 20px);font-size: 14px;background: #eee;margin: 0 10px 10px;padding: 0 10px;">
				</input>
				<view style="display: flex;justify-content: space-around;">
					<button @click="addChat" style="width: auto;padding: 0 10px;background: #29A19C;font-size: 14px;border: none;color: #fff;">发送</button>
					<button @click="uploadSuccess" style="width: auto;padding: 0 10px;background: #0BB2C7;font-size: 14px;border: none;color: #fff;">上传图片</button>
				</view>
				
			</view>
		</view>
	</uni-popup>
</view>
</template>

<script>
	import timeMethod from '@/utils/timeMethod'
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
				userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				sfshIndex: -1,
				sfshOptions: ['通过','不通过', '待审核'],
				count: 0,
				timer: null,
				title:'',
				chatList: [],
				chatForm: {
					content: ''
				},
				fpic: '',
				fname: '',
				fid: '',
				mpic: uni.getStorageSync('headportrait'),
			}
		},
		components: {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			// #ifdef APP-PLUS
			let page = getCurrentPages()
			this.href = this.baseUrl + 'front/h5/#/' + page[page.length - 1].route
			// #endif
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.id = options.id;
			if(options.userid) {
				this.userid = options.userid;
			}
			// 渲染数据
			this.init();
		},
		// #ifdef MP-WEIXIN
		onShareAppMessage(){
			var obj = {
				title: this.title,
				imageUrl: this.swiperList[0]?this.baseUrl + this.swiperList[0]: ''
			}
			return obj
		},
		// #endif
		onUnload() {
			if(this.timer) {
				clearInterval(this.timer);
			}
		},
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			let crossCleanType = uni.getStorageSync('crossCleanType')
			if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
				res = await this.$api.info('fangdong', this.id);
				let reg=new RegExp('http://localhost:8080/springboot337b01q6/upload','g')//g代表全部
				this.detail = res.data;
				this.title = this.detail.minsumingcheng
			}
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			imgView(url){
				let arr = []
				for(let x in this.swiperList){
					arr.push(this.swiperList[x].substr(0,4)=='http'?this.swiperList[x]:this.baseUrl + this.swiperList[x])
				}
				uni.previewImage({
					current: url,
					urls: arr
				})
			},
			// 拨打电话
			callClick(row){
				uni.makePhoneCall({
					phoneNumber: row
				})
			},
			// 支付
			onPayTap(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				if(this.detail.sfsh!='是') {
					this.$utils.msg("请审核通过后再操作");
					return
				}
				uni.setStorageSync('paytable','fangdong');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
			onDetailTap(item) {
				uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 跨表
			async onAcrossTap(tableName,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				if(crossOptAudit=='是'&&this.detail.sfsh!='是') {
					this.$utils.msg("请审核通过后再操作");
					return
				}
				uni.setStorageSync('crossTable','fangdong');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(type=1){
				if(this.timer) {
					clearInterval(this.timer);
				}
				let res = await this.$api.info('fangdong', this.id);
				if (res.data.touxiang) {
					this.fpic = res.data.touxiang.split(',')[0]
				} else if (res.data.headportrait) {
					this.fpic = res.data.headportrait.split(',')[0]
				}
				if(res.data.minsumingcheng){
					this.fname = res.data.minsumingcheng
				}
				this.fid = res.data.id
				let reg=new RegExp('http://localhost:8080/springboot337b01q6/upload','g')//g代表全部
				this.detail = res.data;

				this.title = this.detail.minsumingcheng





				// 轮播图片
				this.swiperList = this.detail.touxiang ? this.detail.touxiang.split(",") : [];
				



				if(type==2){
					this.detail.discussnum++
					await this.$api.update('fangdong',this.detail)
				}
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				mescroll.endSuccess(mescroll.size, this.hasNext);

			},



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url ){
				if(!url){
					return false
				}
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							// #ifdef H5
							 window.open(url);
							// #endif
							// #ifndef H5
							uni.saveFile({
								tempFilePath: res.tempFilePath, //临时路径
								success: function(obj) {
									uni.showToast({
										icon: 'success',
										mask: true,
										title: '下载成功' , 
										duration: 2000,
									});
									setTimeout(() => {
										console.log('obj.savedFilePath',obj.savedFilePath);
										var filePath = obj.savedFilePath;
										uni.openDocument({ //新开页面打开文档，支持格式：doc, xls, ppt, pdf, docx, xlsx, pptx。
											filePath: filePath,
											showMenu: true,
											success: function(res) {
												console.log('打开文档成功');
											}
										});
									}, 2000)
								}
							});
							// #endif
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			onSHTap() {
				if(this.detail.sfsh=='是'||this.detail.sfsh=='否') {
					this.$utils.msg('已审核完成');
					return;
				}
				this.$refs.popup.open()
			},
			// 完成审核
			async onFinishTap() {
				if(!this.detail.sfsh){
					this.$utils.msg('请选择审核状态');
					return
				}
				if(!this.detail.shhf){
					this.$utils.msg('请填写审核回复');
					return
				}
				if(this.detail.sfsh=="通过"){
					this.detail.sfsh = '是'
				}
				if(this.detail.sfsh=="不通过"){
					this.detail.sfsh = '否'
				}
				if(this.detail.sfsh=="待审核"){
					this.detail.sfsh = '待审核'
				}
				await this.$api.update('fangdong', this.detail);
				this.$utils.msg('审核成功');
				this.$refs.popup.close();
			},
			// 关闭窗口
			onCloseWinTap() {
				this.$refs.popup.close()
			},
			sfshChange(e){
				this.sfshIndex = e.target.value
				this.detail.sfsh = this.sfshOptions[this.sfshIndex]
			},
			chatClick() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				if(this.detail.id==this.user.id){
					this.$utils.msg('不能给自己发信息！');
					return false
				}
				this.getChatList()
				uni.connectSocket({
					url: 'ws' + this.$base.url.split('http')[1] + '/ws?user_id=' + uni.getStorageSync("appUserid") + '&to_id=' + this.fid
				})
				uni.onSocketMessage((res)=> {
					this.getChatList()
				})
				this.$refs.chatPopup.open()
			},
			formatMessages(messages) {
				let lastTime = null;
				messages.forEach((message, index) => {
					const currentTime = new Date(message.addtime).getTime();
					if (lastTime !== null) {
						const timeDiff = (currentTime - lastTime) / 1000 / 60; // 转换为分钟
						if (timeDiff < 3) {
							message.addtime = ''; // 如果小于3分钟，不显示时间
						}
					}
					lastTime = currentTime;
				});
				return messages;
			},
			timeFormat(time) {
				const Time = timeMethod.getTime(time).split("T");
				//当前消息日期属于周
				const week = timeMethod.getDateToWeek(time);
				//当前日期0时
				const nti = timeMethod.setTimeZero(timeMethod.getNowTime());
				//消息日期当天0时
				const mnti = timeMethod.setTimeZero(timeMethod.getTime(time));
				//计算日期差值
				const diffDate = timeMethod.calculateTime(nti, mnti);
				//本周一日期0时 （后面+1是去除当天时间）
				const fwnti = timeMethod.setTimeZero(timeMethod.countDateStr(-timeMethod.getDateToWeek(timeMethod
					.getNowTime()).weekID + 1));
				//计算周日期差值
				const diffWeek = timeMethod.calculateTime(mnti, fwnti);
			
				if (diffDate === 0) { //消息发送日期减去当天日期如果等于0则是当天时间
					return Time[1].slice(0, 5);
				} else if (diffDate < 172800000) { //当前日期减去消息发送日期小于2天（172800000ms）则是昨天-  一天最大差值前天凌晨00:00:00到今天晚上23:59:59
					return "昨天 " + Time[1].slice(0, 5);
				} else if (diffWeek >= 0) { //消息日期减去本周一日期大于0则是本周
					return week.weekName;
				} else { //其他时间则是日期
					return Time[0].slice(5, 10);
				}
			},
			async getChatList() {
				let res = await this.$api.mlist('chatmessage',{
					page: 1,
					limit: 1000,
					uid: this.user.id,
					fid: this.fid
				})
				this.chatList = this.formatMessages(res.data.list)
				// #ifdef H5
				let div = document.getElementsByClassName('chat-content')[0]
				setTimeout(() => {
					if (div)
						div.scrollTop = div.scrollHeight
				}, 0)
				// #endif
				
			},
			clearChat(e) {
				if(!e.show){
					uni.closeSocket()
				}
			},
			preViewImg(img){
				uni.previewImage({
					urls: [img],
					current:img
				})
			},
			async uploadSuccess() {
				let _this = this;
				await this.$api.upload(async function(obj) {
					let res = await _this.$api.page('friend', {
						uid: _this.user.id,
						fid: _this.fid,
					})
					if(!res.data.list.length){
						await _this.$api.add('friend',{
							uid: _this.user.id,
							fid: _this.fid,
							name: _this.fname,
							picture: _this.fpic,
							type: 2,
							tablename:  'fangdong',
						})
						await _this.$api.add('friend',{
							fid: _this.user.id,
							uid: _this.fid,
							name: uni.getStorageSync("nickname"),
							picture: _this.mpic,
							type: 2,
							tablename: uni.getStorageSync("nowTable")
						})
					}
					await _this.$api.add('chatmessage',{
						uid: _this.user.id,
						fid: _this.fid,
						content: 'upload/' + obj.file,
						format: 2
					})
					_this.chatForm = {
						content: ''
					}
					uni.sendSocketMessage({
						data: 'upload/' + obj.file
					})
					_this.getChatList()
				})
			},
			async addChat() {
				let res = await this.$api.page('friend', {
					uid: this.user.id,
					fid: this.fid,
				})
				if(!res.data.list.length){
					await this.$api.add('friend',{
						uid: this.user.id,
						fid: this.fid,
						name: this.fname,
						picture: this.fpic,
						type: 2,
						tablename:  'fangdong',
					})
					await this.$api.add('friend',{
						fid: this.user.id,
						uid: this.fid,
						name: uni.getStorageSync("nickname"),
						picture: this.mpic,
						type: 2,
						tablename: uni.getStorageSync("nowTable")
					})
				}
				await this.$api.add('chatmessage',{
					uid: this.user.id,
					fid: this.fid,
					content: this.chatForm.content,
					format: 1
				})
				uni.sendSocketMessage({
					data: this.chatForm.content
				})
				this.chatForm = {
					content: ''
				}
				this.getChatList()
			},
		}
	}
</script>

<style lang="scss">
	page {
	  --animate-duration: 1s;
	  --animate-delay: 1s;
	  --animate-repeat: 1;
	}
	
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio .uni-audio-default {
		width: inherit !important;
	}
	

	.popup-chat{
		 background: #fff;
		 padding-bottom: 40px;
		 .chat-content {
			padding-bottom: 20px;
			width: 100%;
			margin-bottom: 10px;
			max-height: 400px;
			height: 400px;
			overflow-y: scroll;
			border: 1px solid #eeeeee;
			background: #eee;
			display: flex;
			flex-direction: column;
			
		 
			.left-content {
				float: left;
				margin-bottom: 10px;
				padding: 10px;
				max-width: 80%;
				display: flex;
				align-items: center;
				.text-content{
					background: #e5ffff;
					padding: 8px 12px;
					border-radius: 5px;
				}
			}
					 
			.right-content {
				float: right;
				margin-bottom: 10px;
				padding: 10px;
				max-width: 80%;
				display: flex;
				align-items: center;
				.text-content{
					background: #fff;
					padding: 8px 12px;
					border-radius: 5px;
				}
			}
		 }
	}
</style>
