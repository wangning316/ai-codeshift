# 商品属性项_查询属性项精简列表(api)

## controller粒度
- 独立的商品属性项_查询属性项精简列表controller类，ProductPropertySimpleListController，类名不要改。

### 接口描述
查询商品属性项精简列表

### 请求地址
GET /product/brand/simple-list，不要改。

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
无

### 响应参数
| 参数名         | 类型        | 说明               |
|---------------|-------------|--------------------|
| code          | Integer     | 响应码，200=成功    |
| msg           | String      | 响应提示信息       |
| data          | Array       | 品牌精简信息列表   |
| data.id       | Long        | 品牌编号           |
| data.name     | String      | 品牌名称           |
