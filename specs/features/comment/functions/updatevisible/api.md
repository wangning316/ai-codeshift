# 商品评论_显示隐藏(API)

## Controller粒度
- 独立的商品评论_显示隐藏Controller类，ProductCommentVisibleController

### 接口描述
显示/隐藏商品评论

### 请求地址
PUT /product/comment/update-visible

### 请求方法
PUT

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Body）
| 参数名  | 类型    | 是否必填 | 说明           | 校验说明 |
|--------|---------|----------|----------------|----------|
| id     | Long    | 是       | 评论编号       | @NotNull，校验不通过提示：评价编号不能为空 |
| visible| Boolean | 是       | 是否可见：true-显示、false-隐藏 | @NotNull，校验不通过提示：是否可见不能为空 |

### 响应参数
| 参数名  | 类型    | 说明               |
|--------|---------|--------------------|
| code   | int     | 响应码，200=成功    |
| msg    | String  | 响应信息，成功为空  |
| data   | Boolean | 更新结果，true=成功 |
