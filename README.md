## 登录流程：
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

## 帖子的操作

1. 发帖操作
- 请求方式：**Post**
- 接口

	**/publish**

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

	**/update/{id}**
	
	
- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | id|  当前帖子的id      |   必填    |
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

	**/delete/{id}**
	
- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | id        | 帖子id    |  必填  |
- 返回值
	```json
    {
    	"code": 200,
    	"message": "删除成功",
    	"data": null
    }
    ```
	

5. 查询帖子

- 查询所有帖子
- 请求方式：Get
- 接口
	
	**/selectAllTie/{page}/{size}**  

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
            "id": 2,
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


- 查询个人的全部帖子
- 请求方式：Get
- 接口

	**selectPersonTie/{userId}/{page}/{size}**
	
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
            "id": 11,
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
- 查询某一个帖子
- 请求方式：Get
- 接口

	**selectOneTie/{id}**
	

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
        "id": 5,
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

- 查询小区的所有帖子
- 请求方式：Get
- 接口

	**selectCommunityTie/{communityId}/{page}/{size}**
	

- 路径参数

	| 参数名        | 参数说明    |  备注  |
    | --------   | -----   | :----: |
    | id | 帖子id    |  必填  |
    
 - 返回结果
```json
{
    "code": 200,
    "message": "获取成功",
    "data": {
        "total": 6,
        "list": [
            {
                "id": 1,
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