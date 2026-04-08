# 商品评价_分页查询(api)

## controller粒度
- 独立的商品评论_分页查询Controller类，ProductCommentPageController。

### 接口描述
查询商品评价分页列表

### 请求地址
GET /product/comment/page

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名        | 类型        | 是否必填 | 说明                     | 示例值  |
|---------------|-------------|----------|--------------------------|---------|
| pageNo        | Integer     | 是       | 页码，从 1 开始         | 1       |
| pageSize      | Integer     | 是       | 每页条数，最大值 200     | 10      |
| userNickname  | String      | 否       | 评价人名称               | 王二狗    |
| orderId       | Long        | 否       | 交易订单编号             | 24428    |
| spuId         | Long        | 否       | 商品SPU编号              | 29502    |
| spuName       | String      | 否       | 商品SPU名称              | 感冒药    |
| scores        | Integer     | 否       | 评分星级 1-5 分          | 5        |
| replyStatus   | Boolean     | 否       | 商家是否回复             | true     |
| createTime    | LocalDateTime[] | 否    | 创建时间范围（数组）| -       |

### 响应参数
| 参数名                     | 类型        | 说明                     |
|----------------------------|-------------|--------------------------|
| code                       | Integer     | 响应码，200=成功          |
| msg                        | String      | 响应提示信息             |
| data                       | Object      | 分页数据对象             |
| data.total                 | Long        | 数据总条数               |
| data.list                  | Array       | 商品评价分页数据列表     |
| data.list.id               | Long        | 订单项编号               |
| data.list.userId           | Long        | 评价人编号               |
| data.list.userNickname     | String      | 评价人名称               |
| data.list.userAvatar       | String      | 评价人头像               |
| data.list.anonymous        | Boolean     | 是否匿名                 |
| data.list.orderId          | Long        | 交易订单编号             |
| data.list.orderItemId      | Long        | 评价订单项编号           |
| data.list.spuId            | Long        | 商品SPU编号              |
| data.list.skuId            | Long        | 商品SKU编号              |
| data.list.spuName          | String      | 商品SPU名称              |
| data.list.skuPicUrl        | String      | 商品SKU图片地址          |
| data.list.skuProperties    | List        | 商品SKU规格值数组        |
| data.list.visible          | Boolean     | 是否可见                 |
| data.list.scores           | Integer     | 评分星级 1-5 分          |
| data.list.descriptionScores| Integer     | 描述星级 1-5 分          |
| data.list.benefitScores    | Integer     | 服务星级 1-5 分          |
| data.list.content          | String      | 评论内容                 |
| data.list.picUrls          | List        | 评论图片地址数组         |
| data.list.replyStatus      | Boolean     | 商家是否回复             |
| data.list.replyUserId      | Long        | 回复管理员编号           |
| data.list.replyContent     | String      | 商家回复内容             |
| data.list.replyTime        | LocalDateTime | 商家回复时间         |
| data.list.createTime       | LocalDateTime | 创建时间             |
