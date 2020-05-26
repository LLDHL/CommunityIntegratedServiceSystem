## 登录流程：
1.调用接口："/validateCodeImg" 获得验证码

2.调用接口："/login" post方式提交json
登录示例：

`{
	"username":"username",
	"password":"name",
	"validCode":"填入验证码"
}`