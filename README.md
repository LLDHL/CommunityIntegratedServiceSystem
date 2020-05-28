## 一、登录流程：
1.调用接口："/validateCodeImg" 获得验证码

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

	    /tie/publish

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

	    /tie/update/{id}
	
	
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

	    /tie/delete/{tieId}
	
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
	

4. 查询帖子

查询所有帖子
- 请求方式：Get
- 接口
	
	    /tie/selectAllTie/{page}/{size}**

- 路径参数

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

	    /tie/selectPersonTie/{userId}/{page}/{size}
	
	路径参数
	
	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | userId | 发帖人id    |  必填  |
    | page        | 当前页码    |  必填  |
    | size        | 每页显示的条数    |  必填  |

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

	    /tie/selectOneTie/{tieId}
	

- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | communityId | 小区Id    |  必填  |
    | page        | 当前页码    |  必填  |
    | size        | 每页显示的条数    |  必填  |
    
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

	    /tie/selectCommunityTie/{communityId}/{page}/{size}
	

- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子id    |  必填  |
    
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

        /tie/likeTie/{tieId}

- 取消点赞接口

        /tie/NotLikeTie/{tieId}
    
- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子id    |  必填  |


## 三、帖子评论

1. 评论帖子
- 请求类型：Post

- 请求接口
    
        /comment/doPublishComment

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
    
        /comment/selectTieComment/{tieId}
    
- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子Id    |  必填  |

- 演示例子

过于简单，不写

3. 删除一级评论,二级评论

- 请求类型：Delete

- 请求接口

        /comment/deleteTieComment/{commentId}
    
- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | commentId | 评论Id    |  必填  |    
    
- 演示示例

过于简单，不写


4. 发表二级（多级）评论

- 请求类型：Post

- 请求接口

        /comment/doPublishSecondComment
    
- 必要参数：Json

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | tieId | 帖子Id    |  必填  |
    | commentUsername | 评论人姓名    |  必填  |
    | commentUserId | 评论人Id    |  必填  |
    | commentContent | 评论内容    |  必填  |
    | commentTime | 评论时间    |  必填  |
    | commentTypes | 评论类型（0是评论，1是多级评论）    |  必填  |
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

        /comment/selectSecondComment/{replyCommentId}
    
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
    
        likeComment/{commentId}
    
    取消点赞：
    
        /notLikeComment/{commentId}
        
- 路径参数

    | 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | commentId | 一级回复Id    |  必填  |        

## 四、邮件服务

- 请求类型： Post
- 请求接口

    **/email/deSendEmail**
    
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