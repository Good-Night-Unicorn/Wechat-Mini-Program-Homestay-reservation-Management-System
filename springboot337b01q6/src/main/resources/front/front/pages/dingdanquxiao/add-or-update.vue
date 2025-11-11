<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"48rpx 0 48rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">客房名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.kefangmingcheng" v-model="ruleForm.kefangmingcheng" placeholder="客房名称"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">房间类型</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.fangjianleixing" v-model="ruleForm.fangjianleixing" placeholder="房间类型"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">客房价格</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.kefangjiage" v-model.number="ruleForm.kefangjiage" placeholder="客房价格" type="digit"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">房间数量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.fangjianshuliang" v-model.number="ruleForm.fangjianshuliang" placeholder="房间数量" type="number"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">总金额</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.zongjine" v-model.number="ruleForm.zongjine" placeholder="总金额" type="digit"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="kefangtupianTap">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">客房图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.kefangtupian" :src="baseUrl+ruleForm.kefangtupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">民宿名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.minsumingcheng" v-model="ruleForm.minsumingcheng" placeholder="民宿名称"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">民宿地址</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.minsudizhi" v-model="ruleForm.minsudizhi" placeholder="民宿地址"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">用户账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.yonghuzhanghao" v-model="ruleForm.yonghuzhanghao" placeholder="用户账号"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">用户姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.yonghuxingming" v-model="ruleForm.yonghuxingming" placeholder="用户姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">取消时间</view>
				<input :disabled="ro.quxiaoshijian" :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' v-model="ruleForm.quxiaoshijian" placeholder="取消时间" @tap="toggleTab('quxiaoshijian')"></input>
			</view>
               
			<view :style='{"padding":"10rpx 20rpx","margin":"0","borderColor":"#1ccb96","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#666","fontWeight":"500"}' class="title">取消原因</view>
				<xia-editor ref="quxiaoyuanyin" :style='{"minHeight":"300rpx","border":"0px solid #efefef","width":"100%","fontSize":"30rpx","height":"auto"}' v-model="ruleForm.quxiaoyuanyin" placeholder="取消原因" @editorChange="quxiaoyuanyinChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","margin":"40rpx 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0","margin":"0 40rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#1ccb96","width":"250rpx","lineHeight":"80rpx","fontSize":"30rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="quxiaoshijianConfirm" ref="quxiaoshijian" themeColor="#333333"></w-picker>
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
				zongjine: '',
				kefangtupian: '',
				minsumingcheng: '',
				minsudizhi: '',
				yonghuzhanghao: '',
				yonghuxingming: '',
				quxiaoshijian: '',
				quxiaoyuanyin: '',
				shhf: '',
				ispay: '',
				},
				// 登录用户信息
				user: {},
				ro:{
				   kefangmingcheng : false,
				   fangjianleixing : false,
				   kefangjiage : false,
				   fangjianshuliang : false,
				   zongjine : false,
				   kefangtupian : false,
				   minsumingcheng : false,
				   minsudizhi : false,
				   yonghuzhanghao : false,
				   yonghuxingming : false,
				   quxiaoshijian : false,
				   quxiaoyuanyin : false,
				   sfsh : false,
				   shhf : false,
				   ispay : false,
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
			this.ruleForm.quxiaoshijian =  this.$utils.getCurDateTime();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.yonghuzhanghao = this.user.yonghuzhanghao
			this.ro.yonghuzhanghao = true;
			this.ruleForm.yonghuxingming = this.user.yonghuxingming
			this.ro.yonghuxingming = true;



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
				res = await this.$api.info(`dingdanquxiao`, this.ruleForm.id);
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
					if(o=='zongjine'){
						this.ruleForm.zongjine = obj[o];
						this.ro.zongjine = true;
						continue;
					}
					if(o=='kefangtupian'){
						this.ruleForm.kefangtupian = obj[o].split(",")[0];
						this.ro.kefangtupian = true;
						continue;
					}
					if(o=='minsumingcheng'){
						this.ruleForm.minsumingcheng = obj[o];
						this.ro.minsumingcheng = true;
						continue;
					}
					if(o=='minsudizhi'){
						this.ruleForm.minsudizhi = obj[o];
						this.ro.minsudizhi = true;
						continue;
					}
					if(o=='yonghuzhanghao'){
						this.ruleForm.yonghuzhanghao = obj[o];
						this.ro.yonghuzhanghao = true;
						continue;
					}
					if(o=='yonghuxingming'){
						this.ruleForm.yonghuxingming = obj[o];
						this.ro.yonghuxingming = true;
						continue;
					}
					if(o=='quxiaoshijian'){
						this.ruleForm.quxiaoshijian = obj[o];
						this.ro.quxiaoshijian = true;
						continue;
					}
					if(o=='quxiaoyuanyin'){
						this.ruleForm.quxiaoyuanyin = obj[o];
						this.ro.quxiaoyuanyin = true;
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
			quxiaoyuanyinChange(e) {
				this.ruleForm.quxiaoyuanyin = e
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
			quxiaoshijianConfirm(val) {
				console.log(val)
				this.ruleForm.quxiaoshijian = val.result;
				this.$forceUpdate();
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
				if(!this.ruleForm.id) {
					this.ruleForm.ispay = '未支付'
				}
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
				if(this.ruleForm.zongjine&&(!this.$validate.isNumber(this.ruleForm.zongjine))){
					this.$utils.msg(`总金额应输入数字`);
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
					let res = await this.$api.list(`dingdanquxiao`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`dingdanquxiao`, this.ruleForm);
						}else{
							oet = await this.$api.add(`dingdanquxiao`, this.ruleForm);
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
						await this.$api.update(`dingdanquxiao`, this.ruleForm);
					}else{
						oet = await this.$api.add(`dingdanquxiao`, this.ruleForm);
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
