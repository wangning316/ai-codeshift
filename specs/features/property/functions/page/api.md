# 商品属性项_分页查询(api)

## controller粒度
* 独立的商品属性项_分页查询controller类，ProductPropertyPageController。

### 接口描述
查询商品属性项分页列表

### 请求地址
GET /product/property/page

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
| name          | String      | 否       | 属性项名称               | 颜色    |
| status        | Integer     | 否       | 状态                     | 1       |
| createTime    | LocalDateTime[] | 否    | 创建时间范围（数组）| -       |

### 响应参数
| 参数名             | 类型        | 说明                     |
|--------------------|-------------|--------------------------|
| code               | Integer     | 响应码，200=成功          |
| msg                | String      | 响应提示信息             |
| data               | Object      | 分页数据对象             |
| data.total         | Long        | 数据总条数               |
| data.list          | Array       | 属性项分页数据列表       |
| data.list.id       | Long        | 属性项编号               |
| data.list.name     | String      | 属性项名称               |
| data.list.remark   | String      | 属性项备注               |
| data.list.createTime | LocalDateTime | 创建时间            |
