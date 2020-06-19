## 一、登录流程：
1.调用接口："/guest/validateCodeImg" 获得验证码

2.调用接口："/login" post方式提交json
- 登录示例：

```json
{
	"username":"username",
	"password":"name",
	"validCode":"填入验证码"
}
```

## 二、帖子的操作


1. 发帖操作
- 请求方式：**Post**
- 接口

	    /user/ties

- 必要参数：Json格式
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | userId        | 发帖人id      |   必填    |
    | username        | 发帖人姓名      |   必填    |
    | communityId    | 发帖人小区Id      |   必填    |
    | title        | 标题      |   必填    |
    | content        | 内容      |   必填    |
    | label        | 标签      |   必填    |
    | publishTime        | 发帖时间      |   null    |
    | pictureAddress        | 图片地址      |   可以为空    |
    | tieTypes        | 帖子类型      |   0或1    |
    
- 发帖示例
    
    ```json
    {
    	"userId":"1",
    	"username":"lzy",
    	"communityId":"100101",
    	"title":"123",
    	"content":"123",
    	"label":"标签1,标签2",
    	"publishTime":"null",
    	"pictureAddress":"D://a.jpg",
    	"tieTypes":"1"
    }
    ```
2. 修改帖子
- 请求方式：**Put**
- 接口

	    /user/ties/{tieId}
	
	
- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId|  当前帖子的tieId      |   必填    |
    
- 必要参数：Json格式

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----  | :----: |
    | title| 发帖人id      |   必填    |
    | content| 发帖人姓名      |   必填    |
    | label| 发帖人小区      |   必填    |
    | picture| 图片      |   必填    |
  
	示例演示
	```json
    {
    	"title":"123",
		"content":"123",
		"label":"标签1,标签2",
		"picture":"null"
    }
    ```
3. 删除帖子
- 请求方式：**Delete**
- 接口

	    /user/ties/{tieId}
	
- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId        | 帖子id    |  必填  |
- 返回值
	```json
    {
    	"code": 200,
    	"message": "删除成功",
    	"data": null
    }
    ```
	

4. 查询所有帖子

- 请求方式：Get
- 接口
	
	    /user/ties

- 请求参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page        | 当前页码    |  必填  |
    | size        | 每页显示的条数    |  必填  |
    
- 返回结果
	```json
    {
    	"total": 8,
    "list": [
        {
            "tieId": 2,
            "userId": 1,
            "username": "lzy",
            "communityId": "10010011",
            "title": "123",
            "content": "123",
            "label": "标签1,标签2",
            "publishTime": "2020-05-27 14:22:12",
            "pictureAddress": "null",
            "browse": 1,
            "tieTypes": 1,
            "likes": 1
        },
        {
            "id": 3,
            "userId": 1,
            "username": "lzy",
            "communityId": "10010011",
            "title": "震惊",
            "content": "内容",
            "label": "标签",
            "publishTime": "2013-01-01 00:00:00",
            "pictureAddress": "D://a.jpg",
            "browse": 1,
            "tieTypes": 1,
            "likes": 1
        	}
    	],
    	"pageNum": 1,
    	"pageSize": 2,
    	"size": 2,
    	"startRow": 1,
   		"endRow": 2,
    	"pages": 4,
    	"prePage": 0,
    	"nextPage": 2,
    	"isFirstPage": true,
    	"isLastPage": false,
    	"hasPreviousPage": false,
    	"hasNextPage": true,
    	"navigatePages": 8,
    	"navigatepageNums": [
        	1,
        	2,
        	3,
        	4
    	],
    	"navigateFirstPage": 1,
    	"navigateLastPage": 4,
    	"firstPage": 1,
    	"lastPage": 4
    }
    ```


5. 查询个人的全部帖子
- 请求方式：Get
- 接口

	    /user/ties/{userId}
	
	路径参数
	
	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | userId | 发帖人id    |  必填  |
    
    请求参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page        | 当前页码    |  非必填，默认 1  |
    | size        | 每页显示的条数    |  非必填，默认 5  |    
    
    
    
    

- 返回🌰
```json
    {
    "total": 6,
    "list": [
        {
            "tieId": 11,
            "userId": 2,
            "username": "lzy",
            "communityId": "10010",
            "title": "123",
            "content": "123",
            "label": "标签1,标签2",
            "publishTime": "2020-05-27 15:36:15",
            "pictureAddress": "null",
            "browse": 0,
            "tieTypes": 1,
            "likes": 0
        },
        {
            "id": 12,
            "publishUserId": 2,
            "publishUsername": "lzy",
            "publishUserCommunity": "10010",
            "title": "123",
            "content": "123",
            "label": "标签1,标签2",
            "publishTime": "2020-05-27 15:36:17",
            "pictureAddress": "null",
            "browse": 0,
            "tieTypes": 1,
            "likes": 0
        }
    ],
    "pageNum": 1,
    "pageSize": 2,
    "size": 2,
    "startRow": 1,
    "endRow": 2,
    "pages": 3,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
        1,
        2,
        3
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 3,
    "lastPage": 3,
    "firstPage": 1
}
```
6. 查询某一个帖子
- 请求方式：Get
- 接口

	    /user/ties/{tieId}

- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子Id    |  必填  |
    
    
 - 返回结果
```json
{
    "code": 200,
    "message": "查询成功",
    "data": {
        "tieId": 5,
        "userId": 1,
        "username": "lzy",
        "communityId": "10010",
        "title": "123",
        "content": "123",
        "label": "标签1,标签2",
        "publishTime": "2020-05-27 16:02:45",
        "pictureAddress": "D://a.jpg",
        "browse": 27,
        "tieTypes": 1,
        "likes": 1
    }
}
```

7. 查询小区的所有帖子
- 请求方式：Get
- 接口

	    /user/community/ties
	

- 请求参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | communityId | 小区id    |  必填  |
    | page        | 当前页码    |  非必填，默认 1  |
    | size        | 每页显示的条数    |  非必填，默认 5  |
         
 - 返回结果
```json
{
    "code": 200,
    "message": "获取成功",
    "data": {
        "total": 6,
        "list": [
            {
                "tieId": 1,
                "userId": 1,
                "username": "李忠毅",
                "communityId": 101,
                "title": "123",
                "content": "123",
                "label": "标签1,标签2",
                "publishTime": "2020-05-27 19:40:19",
                "picture": "null",
                "browse": 0,
                "tieTypes": 1,
                "likes": 0
            },
            {
                "id": 2,
                "userId": 1,
                "username": "李忠毅",
                "communityId": 101,
                "title": "大家好",
                "content": "我是101小区xxx栋的李忠毅",
                "label": "标签1,标签2",
                "publishTime": "2020-05-27 19:37:30",
                "picture": "D://a.jpg",
                "browse": 0,
                "tieTypes": 1,
                "likes": 0
            }
        ],
        "pageNum": 1,
        "pageSize": 2,
        "size": 2,
        "startRow": 1,
        "endRow": 2,
        "pages": 3,
        "prePage": 0,
        "nextPage": 2,
        "isFirstPage": true,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "navigatePages": 8,
        "navigatepageNums": [
            1,
            2,
            3
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 3,
        "lastPage": 3,
        "firstPage": 1
    }
}
```

8. 点赞和取消点赞帖子功能
- 请求方式：Put
- 点赞接口

        /user/ties/likeTie/{tieId}

- 取消点赞接口

        /user/ties/notLikeTie/{tieId}
    
- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子id    |  必填  |

## 三、帖子评论

1. 评论帖子
- 请求类型：Post

- 请求接口
    
        /user/first/comment

- 必要参数：Json格式

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子Id    |  必填  |
    | commentUsername | 评论人姓名    |  必填  |
    | commentUserId | 评论人Id    |  必填  |
    | commentContent | 评论内容    |  必填  |
    | commentTime | 评论时间    |  必填  |
    | commentTypes | 评论类型（0是评论，1是多级评论）    |  必填  |
    | commentPicture | 评论图片    |  非必填  |
    
    
    
- 示例演示
```json
{
	"tieId":"2",
	"commentUsername":"lzy",
	"commentUserId":"123",
	"commentContent":"好帖子,建议加精",
	"commentTime":"null",
	"commentPicture":"D://1.jpg"
}
```

2. 查看帖子评论

- 请求类型：Get

- 请求接口
    
        /user/first/comment/{tieId}
    
- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子Id    |  必填  |

- 演示例子

过于简单，不写

3. 删除一级评论,二级评论

- 请求类型：Delete

- 请求接口

        /user/comment/{commentId}
    
- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | commentId | 评论Id    |  必填  |    
    
- 演示示例

过于简单，不写


4. 发表二级（多级）评论

- 请求类型：Post

- 请求接口

        /user/second/comment
    
- 必要参数：Json

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子Id    |  必填  |
    | commentUsername | 评论人姓名    |  必填  |
    | commentUserId | 评论人Id    |  必填  |
    | commentContent | 评论内容    |  必填  |
    | commentTime | 评论时间    |  必填  |
    | replyCommentId | 回复目标评论Id    |  必填  |    
    
    
- 示例演示

```json
{
	"tieId":"1",
	"commentUsername":"lzy",
	"commentUserId":"123",
	"commentContent":"这必须是一条好评论",
	"commentTime":"null",
	"replyCommentId":"1"
}
```

5. 查询二级（多级）评论

- 请求类型：Get

- 请求接口

        /user/second/comment/{replyCommentId}
    
- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | replyCommentId | 回复目标评论Id    |  必填  |
    
- 演示示例

过于简单，不写            

6. 点赞、取消点赞一级评论

- 请求类型：Put

- 请求接口

    点赞：
    
        /user/like/comment/{commentId}
    
    取消点赞：
    
        /user/notLike/comment/{commentId}
        
- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | commentId | 一级回复Id    |  必填  |        

## 四、邮件服务

- 请求类型： Post
- 请求接口

    **/email**
    
- 必要参数：Json格式

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | setToEmail | 目标邮件地址    |  必填  |
    | emailTitle | 邮件标题    |  必填  |
    | emailContent | 邮件内容    |  必填  |
    
- 示例展示
```json
{
    "setToEmail":"1111111111@qq.com",
    "emailTitle":"邮件测试--标题",
    "emailContent":"邮件测试--内容"
}
```    

## 五、投诉建议

1. 用户方：投诉建议

1.1 用户发起投诉
- 请求类型：Post

- 请求接口

        /user/complaint

- 必要参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | userId | 用户Id    |  必填  |
    | username | 用户名    |  必填  |
    | complaintContent | 投诉内容    |  必填  |
    | communityId | 小区Id    |  必填  |
    | complaintTime | 投诉时间    |  null  |
    | userEmail | 用户邮件    |  必填  |
    | userPhone | 用户联系方式    |  必填  |
    
    
1.2 用户修改投诉建议
- 请求类型：Put
- 请求接口

        /user/complaint/{complaintId}    

- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | complaintId | 投诉建议Id    |  必填  |
    
- 必要参数：Json格式

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | complaintContent | 投诉建议内容    |  必填  |
    
   

1.3 用户查看自己的投诉建议
- 请求类型：Get
- 请求接口

        /user/complaint/{userId}

- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | userId | 用户Id    |  必填  |
    
- 请求参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page |  当前页数    |  必填  |
    | size | 当前页显示条数    |  必填  |    


1.4 用户查看小区所有的投诉建议

- 请求类型：Get

- 请求接口

        /user/community/complaint/{communityId}

- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | communityId | 小区Id    |  必填  |

- 请求参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page |  当前页数    |  必填  |
    | size | 当前页显示条数    |  必填  |   

1.5 用户删除投诉建议
- 请求类型：Delete
- 请求接口

        /complaint/{complaintId}

- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | complaintId | 投诉建议Id   |  必填  |

2. 物业方：投诉建议

2.1 跟进投诉建议
- 请求类型：Put
- 请求接口

        /pmcAdmin/complaint/{complaintId}           

- 参数类型：json

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | respondComplaintUserId | 回复投诉建议用户Id    |  必填  |
    | respondComplaintUsername |  回复投诉建议用户Id名   |  必填  |
    | respondComplaintContent | 回复投诉内容    |  必填  |
    | respondComplaintTime | 回复时间    |  空  |
    | respondComplaintAuthority |  回复投诉建议用户权限   |  必填  |

- 路径参数：

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | complaintId | 投诉建议Id   |  必填  |
    
    
    
2.2 查询自己跟进过的投诉建议
- 请求类型：Get
- 请求接口

        /pmcAdmin/complaint/{respondComplaintUserId}     

- 路径参数：

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | respondComplaintUserId | 处理投诉跟进Id   |  必填  |

    
 - 请求参数：
 
     | 参数名        | 参数说明    |  备注  |
     | --------   | -----   | :----: |
     | page | 当前页数   |  必填  |
     | size | 当前显示条数   |  必填  |
    
2.3 查询还未跟进的投诉建议
- 请求类型：Get
- 请求接口

        /pmcAdmin/not/complaint        

- 路径参数：

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page | 当前页数   |  必填  |
    | size | 当前显示条数   |  必填  |   
    
    
    
    
## 六、图片操作

1. 图片上传

- 请求方式：Post

- 请求路径：

        /picture/upload
        
- 图片格式：.jpg             

## 七、报修功能

#### 用户报修

1. 用户报修发布

- 请求方式 Post

- 请求接口

        /user/repair

- 必要参数 

    Json格式
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | repairUserId | 用户Id   |  必填  |
    | repairUsername | 用户名   |  必填  | 
    | communityId | 小区Id   |  必填  | 
    | repairContent | 报修内容   |  必填  | 
    | repairPicture | 图片   |  非必填  | 
    | homeId | 门牌号   |  必填  | 
    | repairPhone | 报修人手机号码   |  必填  | 
    | repairEmail | 报修人Email   |  必填  | 
    | repairTime | 时间   |  null  | 

2. 用户报修删除

- 请求方式 Delete

- 请求接口

        /user/repair/{repairId}

- 必要参数

    路径参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | repairId | 报修Id   |  必填  |


3. 完成维修后用户修改状态

- 请求方式 Put

- 请求接口

        /user/repair/ok/{repairId}

- 必要参数

    路径参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | repairId | 报修Id   |  必填  |
      

4. 查看自己所有的报修记录

- 请求方式 Get

- 请求接口

        /user/repair/{repairUserId}

- 必要参数

    路径参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | repairUserId | 用户Id   |  必填  |
    
    请求参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page | 当前页数   |  必填  |
    | size | 当前显示条数   |  必填  |      


#### 维修师傅维修

1. 查询未修理的报修

- 请求方式 Get

- 请求接口

        /worker/not/repair

- 请求参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page | 当前页数   |  非必填，默认1  |
    | size | 当前显示条数   |  非必填，默认5  |   


2. 接单，去维修

- 请求方式 Put

- 请求接口

        /worker/repair/{repairId}

- 必要参数

    路径参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | repairId | 报修Id   |  必填  |
    
    Json格式
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | okRepairUserId | 维修师傅Id   |  必填  |
    | okRepairUsername | 维修师傅名   |  必填  | 
    | okRepairTime | 接单时间   |  null  | 
    

3. 查询已接维护

- 请求方式 Get

- 请求接口

        /worker/yes/repair/{okRepairUserId}

- 路径参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | okRepairUserId | 维修师傅Id   |  必填  |
    
- 请求参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | page | 当前页数   |  非必填，默认1  |
    | size | 当前显示条数   |  非必填，默认5  |     
      
##八、用户注册及管理员审核
###1.用户提交注册申请

1.1 用户上传房产图片等佐证文件

- 请求方式Post
- 接口

        /guest/registerImageUpload
        
- 返回值

        文件名用于1.2内的headurl

1.2 用户提交申请

- 请求方式Post
- 接口
    
        /guest/register

        
- 必要参数

    参数解读
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | address | 具体住址   |  必填  |
    | communityId | 小区id   |  必填  |
    | email | 邮箱   |  必填  |  
    | headUrl | 佐证材料名   |  多个图片用‘;’隔开  |  
    | id | 无意义参数   |  必填  |  
    | name | 用户名   |  必填  |  
    | password | 用户密码   |  必填  |  
    | role | 用户权限，默认填2   |  必填  |  
    | sex | 性别   |  必填  |  
    | tel | 联系电话   |  必填  |  
        
- 示例
    
    
    {
      "address": "string",
      "communityId": "string",
      "email": "chaogaowen@foxmail.com",
      "headUrl": "佐证材料名称",
      "id": 0,
      "name": "string",
      "password": "string",
      "role": "string",
      "sex": "string",
      "tel": "string"
    }

###2.管理员审核

2.1获取待审核列表

- GET接口

        /admin/getAuthstrs
        
- 返回值示例

        {
          "code": 200,
          "data": [
            {
              "address": "string",
              "communityId": "string",
              "email": "string",
              "headUrl": "佐证材料名称，通过‘;’分割",
              "id": 0,
              "name": "string",
              "password": "string",
              "role": "string",
              "sex": "string",
              "tel": "string"
            }
          ],
          "message": "string"
        }
        
2.2获取佐证材料
    
- GET接口

        /admin/getRegisterImage
        
- 参数
        imageName 即 headurl切割后的文件名
        
2.3提交审核意见

- Post接口

        /admin/checkAuthstr
        
- 参数示例

        {
          "authstrId": 0,
          "message": "string",
          "result": true
        }
 - 必要参数
 
     参数解读
     
     | 参数名        | 参数说明    |  备注  |
     | --------   | -----   | :----: |
     | authstrId | 被审核用户id，id源于2.1中的‘id’   |  必填  |
     | message | 审核意见   |  必填  |
     | result | Boolean 类型的审核结果  |  必填  |  
     
     
##九、通知

###1.获取当前用户全部通知

- Get接口 userId为当前用户id

        /user/notification

###2.删除指定通知

- Delete接口 noticeId为通知id

        /user/notification/{noticeId}

###3.标记通知已读

- Put接口 noticeId为通知id

       /user/notification/{noticeId}


## 十、新闻插件
1.接口地址：http://120.79.242.138/api/news

2.请求类型：POST

3.请求参数：

- 必要参数
    
    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | Date | 传入当天日期：2020-06-19   |  必填  |  
        
    
4.返回结果：     
```json
{
    "status": 1,
    "data": [
        {
            "model": "news.news",
            "pk": 1,
            "fields": {
                "标题": "三进新发地，中国疾控中心病毒病所发现了什么？",
                "图片": "p1.img.cctvpic.com/photoAlbum/page/performance/img/2020/6/19/1592533496594_280.jpg",
                "链接": "http://news.cctv.com/2020/06/19/ARTIZGtzKfXnanVY8fpB5s7F200619.shtml",
                "内容": "6月11日，北京在连续57天无新增本地确诊病例后，再次出现本地病例。突如其来的新冠病毒究竟来自何方，受到各方关注。三进新发地，中国疾控中心病毒病所发现了什么？",
                "时间": "2020-06-19"
            }
        },
        {
            "model": "news.news",
            "pk": 2,
            "fields": {
                "标题": "@上班族，多地公积金基数将调整 到手工资或变",
                "图片": "p1.img.cctvpic.com/photoAlbum/page/performance/img/2020/6/19/1592533431278_812.jpg",
                "链接": "http://news.cctv.com/2020/06/19/ARTIxpWw1ssdHhVAzh1iFwmK200619.shtml",
                "内容": "近期，昆明、重庆、石家庄、哈尔滨、乌鲁木齐等多地纷纷发布公积金调整方案，上调公积金缴存基数上限成一致操作，但各地调整额度差异明显。",
                "时间": "2020-06-19"
            }
        }
    ]
}
    ```





##附录

###1.权限设计

- 权限解读

| 用户类别        | 注释    |  权限  |
     | --------   | -----   | :----: |
     | 工作人员 | 如维修师傅  |  worker  |
     | 物业人员 | 物业方面的管理员   |  pmcAdmin  |
     | 业委会成员 | 拥有小区论坛的admin权限   |  admin  | 
     | 普通业主 | 略  |  user  | 

- 测试用账户

   | 用户名        | 密码    |  权限  |
     | --------   | -----   | :----: |
     | test | string  |  worker  |
     | pmcAdmin | string   |  pmcAdmin  |
     | username | name   |  admin  | 
     | string | string  |  user  |  
