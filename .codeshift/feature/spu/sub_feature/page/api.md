# 商品SPU_分页查询(api)
## controller粒度
* 独立的商品SPU_分页查询controller类，ProductSpuPageController。

### 接口描述
获得商品SPU分页列表

### 请求地址
GET /product/spu/page

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
| name          | String      | 否       | 商品名称                 | 清凉小短袖 |
| tabType       | Integer     | 是       | 前端请求的tab类型        | 1       |
| categoryId    | Long        | 否       | 商品分类编号             | 1       |
| createTime    | LocalDateTime[] | 否    | 创建时间范围（数组）| [2022-07-01 00:00:00, 2022-07-01 23:59:59] |

### 响应参数
| 参数名             | 类型        | 说明                     |
|--------------------|-------------|--------------------------|
| code               | Integer     | 响应码，200=成功          |
| msg                | String      | 响应提示信息             |
| data               | Object      | 分页数据对象             |
| data.total         | Long        | 数据总条数               |
| data.list          | Array       | 商品SPU分页数据列表      |
| data.list.id       | Long        | 商品SPU编号              |
| data.list.name     | String      | 商品名称                 |
| data.list.keyword  | String      | 关键字                   |
| data.list.introduction | String  | 商品简介                 |
| data.list.description | String   | 商品详情                 |
| data.list.categoryId | Long      | 商品分类编号             |
| data.list.brandId  | Long        | 商品品牌编号             |
| data.list.picUrl   | String      | 商品封面图               |
| data.list.sliderPicUrls | List<String> | 商品轮播图 |
| data.list.sort     | Integer     | 排序字段                 |
| data.list.status   | Integer     | 商品状态                 |
| data.list.createTime | LocalDateTime | 商品创建时间 |
| data.list.specType | Boolean     | 规格类型                 |
| data.list.price    | Integer     | 商品价格（单位：分）|
| data.list.marketPrice | Integer   | 市场价（单位：分）|
| data.list.costPrice | Integer    | 成本价（单位：分）|
| data.list.stock    | Integer     | 商品库存                 |
| data.list.skus     | List<ProductSkuRespVO> | SKU数组 |
| data.list.deliveryTypes | List<Integer> | 配送方式数组 |
| data.list.deliveryTemplateId | Long | 物流配置模板编号 |
| data.list.giveIntegral | Integer | 赠送积分 |
| data.list.subCommissionType | Boolean | 分销类型 |
| data.list.salesCount | Integer | 商品销量 |
| data.list.virtualSalesCount | Integer | 虚拟销量 |
| data.list.browseCount | Integer | 浏览量 |
