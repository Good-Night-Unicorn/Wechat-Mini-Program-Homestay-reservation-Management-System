<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"48rpx 0 48rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">客房名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.kefangmingcheng" v-model="ruleForm.kefangmingcheng" placeholder="客房名称"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">房间类型</view>
				<picker :disabled="ro.fangjianleixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="fangjianleixingChange" :value="fangjianleixingIndex" :range="fangjianleixingOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#1ccb96"}' class="uni-input">{{ruleForm.fangjianleixing?ruleForm.fangjianleixing:"请选择房间类型"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">客房价格</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.kefangjiage" v-model.number="ruleForm.kefangjiage" placeholder="客房价格" type="digit"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">房间数量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.fangjianshuliang" v-model.number="ruleForm.fangjianshuliang" placeholder="房间数量" type="number"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="kefangtupianTap">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">客房图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.kefangtupian" :src="baseUrl+ruleForm.kefangtupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">民宿星级</view>
				<picker :disabled="ro.minsuxingji" :style='{"width":"100%","flex":"1","height":"auto"}' @change="minsuxingjiChange" :value="minsuxingjiIndex" :range="minsuxingjiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#1ccb96"}' class="uni-input">{{ruleForm.minsuxingji?ruleForm.minsuxingji:"请选择民宿星级"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">民宿名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.minsumingcheng" v-model="ruleForm.minsumingcheng" placeholder="民宿名称"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">联系方式</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.lianxifangshi" v-model="ruleForm.lianxifangshi" placeholder="联系方式"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">民宿地址</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.minsudizhi" v-model="ruleForm.minsudizhi" placeholder="民宿地址"  type="text"></input>
			</view>
                
			<view :style='{"padding":"10rpx 20rpx","margin":"0","borderColor":"#1ccb96","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#666","fontWeight":"500"}' class="title">民宿介绍</view>
				<xia-editor ref="minsujieshao" :style='{"minHeight":"300rpx","border":"0px solid #efefef","width":"100%","fontSize":"30rpx","height":"auto"}' v-model="ruleForm.minsujieshao" placeholder="民宿介绍" @editorChange="minsujieshaoChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","margin":"40rpx 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0","margin":"0 40rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#1ccb96","width":"250rpx","lineHeight":"80rpx","fontSize":"30rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				kefangmingcheng: '',
				fangjianleixing: '',
				kefangjiage: '',
				fangjianshuliang: '',
				kefangtupian: '',
				minsuxingji: '',
				minsumingcheng: '',
				lianxifangshi: '',
				minsudizhi: '',
				minsujieshao: '',
				shhf: '',
				discussnum: '',
				storeupnum: '',
				},
				fangjianleixingOptions: [],
				fangjianleixingIndex: 0,
				minsuxingjiOptions: [],
				minsuxingjiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   kefangmingcheng : false,
				   fangjianleixing : false,
				   kefangjiage : false,
				   fangjianshuliang : false,
				   kefangtupian : false,
				   minsuxingji : false,
				   minsumingcheng : false,
				   lianxifangshi : false,
				   minsudizhi : false,
				   minsujieshao : false,
				   sfsh : false,
				   shhf : false,
				   clicktime : false,
				   clicknum : false,
				   discussnum : false,
				   storeupnum : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.minsumingcheng = this.user.minsumingcheng
			this.ro.minsumingcheng = true;
			this.ruleForm.lianxifangshi = this.user.lianxifangshi
			this.ro.lianxifangshi = true;
			this.ruleForm.minsudizhi = this.user.minsudizhi
			this.ro.minsudizhi = true;


			// 下拉框
			res = await this.$api.option(`fangjianleixing`,`fangjianleixing`,{});
			this.fangjianleixingOptions = res.data;
			this.fangjianleixingOptions.unshift("请选择房间类型");
			// 自定义下拉框值
			this.minsuxingjiOptions = "一星,二星,三星,四星,五星".split(',')

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`minsuxinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='kefangmingcheng'){
						this.ruleForm.kefangmingcheng = obj[o];
						this.ro.kefangmingcheng = true;
						continue;
					}
					if(o=='fangjianleixing'){
						this.ruleForm.fangjianleixing = obj[o];
						this.ro.fangjianleixing = true;
						continue;
					}
					if(o=='kefangjiage'){
						this.ruleForm.kefangjiage = obj[o];
						this.ro.kefangjiage = true;
						continue;
					}
					if(o=='fangjianshuliang'){
						this.ruleForm.fangjianshuliang = obj[o];
						this.ro.fangjianshuliang = true;
						continue;
					}
					if(o=='kefangtupian'){
						this.ruleForm.kefangtupian = obj[o].split(",")[0];
						this.ro.kefangtupian = true;
						continue;
					}
					if(o=='minsuxingji'){
						this.ruleForm.minsuxingji = obj[o];
						this.ro.minsuxingji = true;
						continue;
					}
					if(o=='minsumingcheng'){
						this.ruleForm.minsumingcheng = obj[o];
						this.ro.minsumingcheng = true;
						continue;
					}
					if(o=='lianxifangshi'){
						this.ruleForm.lianxifangshi = obj[o];
						this.ro.lianxifangshi = true;
						continue;
					}
					if(o=='minsudizhi'){
						this.ruleForm.minsudizhi = obj[o];
						this.ro.minsudizhi = true;
						continue;
					}
					if(o=='minsujieshao'){
						this.ruleForm.minsujieshao = obj[o];
						this.ro.minsujieshao = true;
						continue;
					}
					if(o=='clicktime'){
						this.ruleForm.clicktime = obj[o];
						this.ro.clicktime = true;
						continue;
					}
					if(o=='clicknum'){
						this.ruleForm.clicknum = obj[o];
						this.ro.clicknum = true;
						continue;
					}
					if(o=='discussnum'){
						this.ruleForm.discussnum = obj[o];
						this.ro.discussnum = true;
						continue;
					}
					if(o=='storeupnum'){
						this.ruleForm.storeupnum = obj[o];
						this.ro.storeupnum = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			minsujieshaoChange(e) {
				this.ruleForm.minsujieshao = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			fangjianleixingChange(e) {
				this.fangjianleixingIndex = e.target.value
				this.ruleForm.fangjianleixing = this.fangjianleixingOptions[this.fangjianleixingIndex]
			},
			// 下拉变化
			minsuxingjiChange(e) {
				this.minsuxingjiIndex = e.target.value
				this.ruleForm.minsuxingji = this.minsuxingjiOptions[this.minsuxingjiIndex]
			},

			kefangtupianTap() {
				let _this = this;
				if(this.ro.kefangtupian){
					return false
				}
				this.$api.upload(function(res) {
					_this.ruleForm.kefangtupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				//跨表计算判断
				var obj;
				if((!this.ruleForm.kefangmingcheng)){
					this.$utils.msg(`客房名称不能为空`);
					return
				}
				if((!this.ruleForm.fangjianleixing)){
					this.$utils.msg(`房间类型不能为空`);
					return
				}
				if((!this.ruleForm.kefangjiage)){
					this.$utils.msg(`客房价格不能为空`);
					return
				}
				if(this.ruleForm.kefangjiage&&(!this.$validate.isNumber(this.ruleForm.kefangjiage))){
					this.$utils.msg(`客房价格应输入数字`);
					return
				}
				if(this.ruleForm.fangjianshuliang&&(!this.$validate.isIntNumer(this.ruleForm.fangjianshuliang))){
					this.$utils.msg(`房间数量应输入整数`);
					return
				}
				if(this.ruleForm.clicknum&&(!this.$validate.isIntNumer(this.ruleForm.clicknum))){
					this.$utils.msg(`点击次数应输入整数`);
					return
				}
				if(this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`minsuxinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`minsuxinxi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`minsuxinxi`, this.ruleForm);
						}
						if(this.cross){
							uni.setStorageSync('crossCleanType',true);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`minsuxinxi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`minsuxinxi`, this.ruleForm);
					}
					if(this.cross){
						uni.setStorageSync('crossCleanType',true);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
