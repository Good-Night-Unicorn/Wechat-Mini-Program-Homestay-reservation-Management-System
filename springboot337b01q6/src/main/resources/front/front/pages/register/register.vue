<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"48rpx 24rpx 24rpx","background":"url(http://codegen.caihongy.cn/20241110/7c0eb818b4354c67a925429688e757f4.jpg) no-repeat center top / cover,#fff","height":"auto"}'>
		<view :style='{"border":"2rpx solid #fff","padding":"48rpx 48rpx 24rpx","margin":"240rpx 0 0","borderRadius":"20rpx","textAlign":"center","background":"rgba(255,255,255,.9)","display":"block","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"margin":"0 auto 24rpx auto","borderRadius":"8rpx","top":"-220rpx","left":"40%","display":"block","width":"160rpx","position":"absolute","height":"160rpx"}' src="http://codegen.caihongy.cn/20241110/fb3701a50e5b4b859d96f84453ffd375.jpg" mode="aspectFill"></image>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">用户账号：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.yonghuzhanghao"  type="text"  class="uni-input" name="" placeholder="用户账号" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">用户姓名：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.yonghuxingming"  type="text"  class="uni-input" name="" placeholder="用户姓名" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">密码：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">性别：</view>
				<picker :style='{"border":"0px solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"border":"0px solid #23baf7","padding":"0 20rpx","color":"#666","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">联系电话：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
            <view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","margin":"0px 0 0 10rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","margin":"0px 0 0 10rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">身份证：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.shenfenzheng"  type="text"  class="uni-input" name="" placeholder="身份证" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='fangdong'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">民宿名称：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.minsumingcheng"  type="text"  class="uni-input" name="" placeholder="民宿名称" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='fangdong'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">密码：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='fangdong'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='fangdong'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">法人：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.faren"  type="text"  class="uni-input" name="" placeholder="法人" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='fangdong'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">联系方式：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.lianxifangshi"  type="text"  class="uni-input" name="" placeholder="联系方式" />
			</view>
			<view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='fangdong'" class="uni-form-item uni-column">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">民宿地址：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.minsudizhi"  type="text"  class="uni-input" name="" placeholder="民宿地址" />
			</view>
            <view :style='{"border":"2rpx solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='fangdong'" @tap="fangdongtouxiangTap" class="">
				<view :style='{"color":"#fff","borderRadius":"20rpx","textAlign":"center","background":"#1ccb96","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">logo：</view>
				<image :style='{"width":"120rpx","margin":"0px 0 0 10rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","margin":"0px 0 0 10rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0 40rpx","margin":"24rpx auto","color":"rgb(255, 255, 255)","borderRadius":"20rpx","background":"#1ccb96","display":"inline-block","width":"calc(100% - 0px)","lineHeight":"88rpx","fontSize":"36rpx","minWidth":"200rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
				ruleForm: {
                yonghuzhanghao: '',
                yonghuxingming: '',
                mima: '',
                xingbie: '',
                lianxidianhua: '',
                touxiang: '',
                shenfenzheng: '',
                shhf: '',
                minsumingcheng: '',
                mima: '',
                faren: '',
                lianxifangshi: '',
                minsudizhi: '',
                touxiang: '',
                shhf: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

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
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
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
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
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
                if(`fangdong` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`fangdong` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
					this.$utils.msg(`联系方式应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
