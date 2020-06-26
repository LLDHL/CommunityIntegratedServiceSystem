<template>
	<div class="login_contrain">
		<div class="login_box">
			<div class="avatar_box">
				<img src="../assets/logo.png" />
			</div>
			<el-form>
				<el-form-item>
					<el-input></el-input>
				</el-form-item>
				<el-form-item>
					<el-input></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="info">注册</el-button>
					<el-button type="primary">登录</el-button>
				</el-form-item>
			</el-form>
		</div>
	</div>
	<el
</template>

<script>
	export default{
		
	}
</script>

<style lang="less" scoped>
	.login_contrain{
		background-color: #2b4b6b;
		height: 100%;
	}
	.login_box{
		width: 450px;
		height: 300px;
		background-color: #fff;
		border-radius: 3px;
		position: absolute;
			left: 50%;
			top: 50%;
		transform: translate(-50%,-50%);
	}
	.avatar_box{
		height: 130px;
		width: 130px;
		border: 1px solid #eee;
		border-radius: 50%;
		padding: 10px;
		box-shadow: 0 0 10px #ddd;
		position: absolute;
			left: 50%;
		transform: translate(-50%,-50%);
		background-color: #fff;
		img{
			height: 100%;
			width: 100%;
			border-radius: 50%;
			background-color: #eee;
		}
	}
</style>
