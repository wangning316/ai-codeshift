# 商品属性项_查询(api)
## controller粒度
* 独立的商品属性项_查询controller类，ProductPropertyGetController。

### 接口描述
查询商品属性项

### 请求地址
GET /product/property/get

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名   | 类型   | 是否必填 | 说明     | 示例  |
|---------|--------|----------|----------|-------|
| id      | Long   | 是       | 属性项编号 | 1024  |

### 响应参数
| 参数名         | 类型        | 说明               |
|---------------|-------------|--------------------|
| code          | Integer     | 响应码，200=成功    |
| msg           | String      | 响应提示信息       |
| data.id       | Long        | 属性项编号           |
| data.name     | String      | 属性项名称           |
| data.remark   | String      | 属性项备注           |
| data.createTime | LocalDateTime | 创建时间       |
