## 商品品牌_查询(api)

## controller粒度
* 独立的商品品牌_查询controller类，ProductBrandGetController。

### 接口描述
查询商品品牌

### 请求地址
GET /product/brand/get

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名   | 类型   | 是否必填 | 说明     | 示例  |
|---------|--------|----------|----------|-------|
| id      | Long   | 是       | 分类编号 | 1024  |

### 响应参数
| 参数名         | 类型        | 说明               |
|---------------|-------------|--------------------|
| code          | Integer     | 响应码，200=成功    |
| msg           | String      | 响应提示信息       |
| data.id       | Long        | 分类编号           |
| data.parentId | Long        | 父分类编号         |
| data.name     | String      | 分类名称           |
| data.picUrl   | String      | 移动端分类图       |
| data.sort     | Integer     | 分类排序           |
| data.status   | Integer     | 开启状态           |
| data.description | String   | 分类描述           |
| data.createTime | LocalDateTime | 创建时间       |
