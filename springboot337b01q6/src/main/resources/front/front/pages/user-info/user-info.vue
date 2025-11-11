<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"0","position":"relative","background":"#fff","height":"auto"}'>
		<view :style='{"width":"100%","padding":"0","background":"none","display":"block","height":"auto"}'>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>用户账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.yonghuzhanghao" placeholder="用户账号"></input>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>用户姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}'   v-model="ruleForm.yonghuxingming" placeholder="用户姓名"></input>
			</view>
			<view v-if="tableName=='yonghu'" :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#1ccb96"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>联系电话</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}'   v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>身份证</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}'   v-model="ruleForm.shenfenzheng" placeholder="身份证"></input>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fangdong'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>民宿名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.minsumingcheng" placeholder="民宿名称"></input>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fangdong'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>法人</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}'   v-model="ruleForm.faren" placeholder="法人"></input>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fangdong'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>联系方式</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}'   v-model="ruleForm.lianxifangshi" placeholder="联系方式"></input>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fangdong'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>民宿地址</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}'   v-model="ruleForm.minsudizhi" placeholder="民宿地址"></input>
			</view>
			<view :style='{"padding":"12rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"0","borderWidth":"2rpx 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='fangdong'" @tap="fangdongtouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","minWidth":"200rpx","fontWeight":"500"}'>logo</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"width":"100%","margin":"40rpx 0 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn">
				<button @tap="update()" class="cu-btn lg" :style='{"border":"0","padding":"0px","margin":"0 20rpx","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#1ccb96","width":"250rpx","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}'>保存</button>
				<button @tap="logout()" class="cu-btn lg" :style='{"border":"2rpx solid #1ccb96","padding":"0px","margin":"0 20rpx","color":"#1ccb96","borderRadius":"16rpx","background":"none","width":"250rpx","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}'>退出登录</button>
			</view>
		</view>
	</view>
</view>
</template>

<script>

    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				yonghuxingbieOptions: [],
				yonghuxingbieIndex: 0,
			}
		},
        components: {
            multipleSelect,
			xiaEditor
        },
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let that = this
			let res = {}
			this.tableName = table;
			this.getSession()
			// 自定义下拉框值
			if(this.tableName=='yonghu'){
				this.yonghuxingbieOptions = "男,女".split(',');
				this.yonghuxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.yonghuxingbieIndex = index;
					}
				});
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let res = await this.$api.session(this.tableName)
				this.ruleForm = res.data;
				uni.setStorageSync('userSession',JSON.stringify(res.data))
			},
            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
			yonghutouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
			fangdongtouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('. .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.clearStorageSync()
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {

				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}

				if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$utils.msg(`用户姓名不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}


				if(`yonghu` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}


				if(`yonghu` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
					this.$utils.msg(`身份证应输入身份证格式`);
					return
				}



				if((!this.ruleForm.minsumingcheng) && `fangdong` == this.tableName){
					this.$utils.msg(`民宿名称不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `fangdong` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}


				if(`fangdong` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
					this.$utils.msg(`联系方式应输入手机格式`);
					return
				}




				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
				this.getSession()
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
