<template>
	<div id="app">
		<hr />
		<h2>登录/验证码（成功）</h2>
		用户名<input type="test" v-model="login_form.username" /><br />
		密 码<input type="password" v-model="login_form.password" /><br />
		验证码<input type="test" v-model="login_form.validCode"/><img :src="pin_url" /><br />
		<button @click="login_btn()">提交</button>
		<button @click="test_pin()">get测试</button>
		<hr />
		<!-- <table border="1">
			<th v-for="(v,i) in list[0]">{{i}}</th>
			<tr v-for="it in list">
				<td v-for="item in it">{{item}}</td>
			</tr>
		</table> -->
		<h2>用户投诉（成功）</h2>
		<textarea v-model="complaint_form.complaintContent"></textarea>
		<button @click="complaint_btn()">发送</button>
		<hr />
		<h2>修改投诉（成功）</h2>
		<button @click="get_complaint_one()">获取</button>
		<hr />
		<h2>获取投诉记录（成功）</h2>
		<button @click="get_complaint_history()">获取</button>
		<hr />
		<h2>用户信息获取（失败）</h2>
		<button @click="get_user_info()">获取</button>
		<hr />
		<h2>跳转到login（成功）</h2>
		<button @click="go_login()">获取</button>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				login_form: {
					username: 'string',
					password: 'string',
					validCode: ''
				},
				// username: 'username',
				// password: 'name',
				// validCode: '',
				// pin_url: 'http://116.62.159.13:8932/guest/validateCodeImg',
				pin_url: 'http://116.62.15.76/guest/validateCodeImg',
				data:{},
				list:{},
				complaint_form:{
					userId:1,
					username:'lzy',
					complaintContent:'',//投诉内容
					communityId:100101,//小区id
					userEmail:'1111111111@qq.com',
					userPhone:'15218856825'
				}
			}
		},
		methods: {
			login_btn() {
				console.log(this.login_form)
				this.$http.post('/login',this.login_form
				// {
				// 	username:this.username,
				// 	password:this.password,
				// 	validCode:this.validCode
				// }
				)
					.then(d=>{
						console.log(d.data)
					})
			},
			test_pin(){
				this.$http.get('/guest/validateCodeImg')
					.then(d=>{
						console.log(d.data)
					})
			},
			complaint_btn(){
				this.$http.post('/user/complaint',this.complaint_form)
					.then(d=>{
						console.log(d.data)
					})
			},
			get_complaint_one(){
				this.$http.put('/user/complaint/1')
					.then(d=>{
						console.log(d.data)
					})
			},
			get_complaint_history(){
				this.$http.get('/user/complaint/1')
					.then(d=>{
						console.log(d.data)
					})
			},
			get_user_info(){
				this.$http.get('/user/userInfo')
					.then(d=>{
						console.log(d.data)
					})
			},
			go_login(){
				this.$router.push('/login')
			}
		},
		created(){
			// this.$http.get('http://116.62.15.76/user/ties?pgae=1&size=5')
			// 	.then(d=>{
			// 		console.log(d.data.data.list)
			// 		// this.data = d.data
			// 		this.list = d.data.data.list
			// 		console.log(this.list[0])
			// 	})
		}
	}
</script>

<style>

</style>
