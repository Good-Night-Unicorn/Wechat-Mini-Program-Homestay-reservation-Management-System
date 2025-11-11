<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="120px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="客房名称" prop="kefangmingcheng" >
					<el-input v-model="ruleForm.kefangmingcheng" placeholder="客房名称" clearable  :readonly="ro.kefangmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="客房名称" prop="kefangmingcheng" >
					<el-input v-model="ruleForm.kefangmingcheng" placeholder="客房名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="房间类型" prop="fangjianleixing" >
					<el-input v-model="ruleForm.fangjianleixing" placeholder="房间类型" clearable  :readonly="ro.fangjianleixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="房间类型" prop="fangjianleixing" >
					<el-input v-model="ruleForm.fangjianleixing" placeholder="房间类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="客房价格" prop="kefangjiage" >
					<el-input-number v-model="ruleForm.kefangjiage" placeholder="客房价格" :disabled="ro.kefangjiage"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="客房价格" prop="kefangjiage" >
					<el-input v-model="ruleForm.kefangjiage" placeholder="客房价格" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="房间数量" prop="fangjianshuliang" >
					<el-input v-model.number="ruleForm.fangjianshuliang" placeholder="房间数量" clearable  :readonly="ro.fangjianshuliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="房间数量" prop="fangjianshuliang" >
					<el-input v-model="ruleForm.fangjianshuliang" placeholder="房间数量" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="总金额" prop="zongjine" >
					<el-input-number v-model="ruleForm.zongjine" placeholder="总金额" :disabled="ro.zongjine"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="总金额" prop="zongjine" >
					<el-input v-model="ruleForm.zongjine" placeholder="总金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.kefangtupian" label="客房图片" prop="kefangtupian" >
					<file-upload
						tip="点击上传客房图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.kefangtupian?ruleForm.kefangtupian:''"
						@change="kefangtupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.kefangtupian" label="客房图片" prop="kefangtupian" >
					<img v-if="ruleForm.kefangtupian.substring(0,4)=='http'&&ruleForm.kefangtupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.kefangtupian" width="100" height="100">
					<img v-else-if="ruleForm.kefangtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.kefangtupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.kefangtupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="民宿名称" prop="minsumingcheng" >
					<el-input v-model="ruleForm.minsumingcheng" placeholder="民宿名称" clearable  :readonly="ro.minsumingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="民宿名称" prop="minsumingcheng" >
					<el-input v-model="ruleForm.minsumingcheng" placeholder="民宿名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="民宿地址" prop="minsudizhi" >
					<el-input v-model="ruleForm.minsudizhi" placeholder="民宿地址" clearable  :readonly="ro.minsudizhi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="民宿地址" prop="minsudizhi" >
					<el-input v-model="ruleForm.minsudizhi" placeholder="民宿地址" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="取消时间" prop="quxiaoshijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.quxiaoshijian" 
						type="datetime"
						:readonly="ro.quxiaoshijian"
						placeholder="取消时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.quxiaoshijian" label="取消时间" prop="quxiaoshijian" >
					<el-input v-model="ruleForm.quxiaoshijian" placeholder="取消时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'"  label="取消原因" prop="quxiaoyuanyin" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.quxiaoyuanyin" 
					class="editor"
					myQuillEditor="quxiaoyuanyin"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.quxiaoyuanyin" label="取消原因" prop="quxiaoyuanyin" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.quxiaoyuanyin"></span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
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
				},

				rules: {
					kefangmingcheng: [
						{ required: true, message: '客房名称不能为空', trigger: 'blur' },
					],
					fangjianleixing: [
						{ required: true, message: '房间类型不能为空', trigger: 'blur' },
					],
					kefangjiage: [
						{ required: true, message: '客房价格不能为空', trigger: 'blur' },
						{ validator: validateNumber, trigger: 'blur' },
					],
					fangjianshuliang: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					zongjine: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					kefangtupian: [
					],
					minsumingcheng: [
					],
					minsudizhi: [
					],
					yonghuzhanghao: [
					],
					yonghuxingming: [
					],
					quxiaoshijian: [
					],
					quxiaoyuanyin: [
					],
					sfsh: [
					],
					shhf: [
					],
					ispay: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.quxiaoshijian = this.getCurDateTime()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
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
							this.ruleForm.kefangtupian = obj[o];
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
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
							this.ro.yonghuzhanghao = true;
						}
						if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yonghuxingming = json.yonghuxingming
							this.ro.yonghuxingming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `dingdanquxiao/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.quxiaoyuanyin = this.ruleForm.quxiaoyuanyin.replace(reg,'../../../springboot337b01q6/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(!this.ruleForm.id) {
						this.ruleForm.ispay = '未支付'
					}
					if(this.ruleForm.kefangtupian!=null) {
						this.ruleForm.kefangtupian = this.ruleForm.kefangtupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `dingdanquxiao/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.dingdanquxiaoCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.dingdanquxiaoCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			kefangtupianUploadChange(fileUrls) {
				this.ruleForm.kefangtupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 10px;
		background: #F9F9F9;
	}
	.add-update-preview {
		padding: 0px;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		font-weight: 600;
		width: 120px;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 120px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 12px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		width: auto;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 12px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		width: auto;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 50%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 10px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 50%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 12px;
		box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
		color: #666;
		background: #fff;
		width: auto;
		font-size: 14px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 14px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #7ED0CC;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #0097E6;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #48BAB6;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #BBBBBB;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #91BFD8;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
