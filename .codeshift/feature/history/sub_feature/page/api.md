# 商品浏览记录_分页查询(api)

## controller粒度
- 独立的商品浏览记录_分页查询controller类，ProductBrowseHistoryController。

### 接口描述
查询商品浏览记录分页列表

### 请求地址
GET /product/browse-history/page

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名        | 类型              | 是否必填 | 说明                     | 示例值  |
|---------------|-----------------|----------|--------------------------|---------|
| pageNo        | Integer         | 是       | 页码，从 1 开始         | 1       |
| pageSize      | Integer         | 是       | 每页条数，最大值 200     | 10      |
| userId        | Long            | 否       | 用户编号                 | 4314    |
| userDeleted   | Boolean         | 否       | 用户是否删除             | false   |
| spuId         | Long            | 否       | 商品 SPU 编号            | 42      |
| createTime    | LocalDateTime[] | 否    | 创建时间，时间范围查询   | 2026-01-01 00:00:00,2026-04-02 23:59:59 |
| sortingFields | List            | 否       | 排序字段集合，支持多字段排序 | 详见下方结构体定义 |

#### sortingFields 构体定义
sortingFields 为**List列表类型**，每个元素是一个排序对象，支持多字段排序：

| 子参数名 | 类型   | 是否必填 | 说明                          | 可选值                  | 示例值  |
|----------|--------|----------|-------------------------------|-------------------------|---------|
| field    | String | 是       | 排序字段名（数据库对应字段）  | id、createTime、spuId 等 | createTime |
| order    | String | 是       | 排序方式                      | asc：升序；desc：降序   | desc    |

### 响应参数
| 参数名                     | 类型             | 说明                     |
|----------------------------|------------------|--------------------------|
| code                       | Integer          | 响应码，200=成功          |
| msg                        | String           | 响应提示信息             |
| data                       | Object           | 分页数据对象             |
| data.total                 | Long             | 数据总条数               |
| data.list                  | Array            | 商品浏览记录分页数据列表 |
| data.list.id               | Long             | 浏览记录编号             |
| data.list.spuId            | Long             | 商品SPU编号              |
| data.list.spuName          | String           | 商品SPU名称              |
| data.list.picUrl           | String           | 商品封面图               |
| data.list.price            | Integer          | 商品单价                 |
| data.list.salesCount       | Integer          | 商品销量                 |
| data.list.stock            | Integer          | 商品库存                 |
