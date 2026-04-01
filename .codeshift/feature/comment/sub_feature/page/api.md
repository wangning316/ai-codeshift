# 商品品牌_查询品牌分页(api)

## controller粒度
* 独立的商品品牌_查询品牌分页controller类，ProductBrandPageController。

### 接口描述
查询品牌分页列表

### 请求地址
GET /product/brand/page

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
| name          | String      | 否       | 品牌名称                 | 苹果    |
| status        | Integer     | 否       | 状态                     | 0       |
| createTime    | LocalDateTime[] | 否    | 创建时间范围（数组）| -       |

### 响应参数
| 参数名             | 类型        | 说明                     |
|--------------------|-------------|--------------------------|
| code               | Integer     | 响应码，200=成功          |
| msg                | String      | 响应提示信息             |
| data               | Object      | 分页数据对象             |
| data.total         | Long        | 数据总条数               |
| data.list          | Array       | 品牌分页数据列表         |
| data.list.id       | Long        | 品牌编号                 |
| data.list.name     | String      | 品牌名称                 |
| data.list.picUrl   | String      | 品牌图片地址             |
| data.list.sort     | Integer     | 品牌排序                 |
| data.list.description | String   | 品牌描述                 |
| data.list.status   | Integer     | 状态                     |
| data.list.createTime | LocalDateTime | 创建时间            |
