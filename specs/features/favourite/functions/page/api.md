# 商品收藏_分页查询(api)

## controller粒度
- 独立的商品收藏_分页查询controller类，ProductFavouriteController。

### 接口描述
查询商品收藏分页列表

### 请求地址
GET /product/favorite/page

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
| userId        | Long        | 否       | 用户编号                 | 5036    |

### 响应参数
| 参数名                     | 类型             | 说明                     |
|----------------------------|------------------|--------------------------|
| code                       | Integer          | 响应码，200=成功          |
| msg                        | String           | 响应提示信息             |
| data                       | Object           | 分页数据对象             |
| data.total                 | Long             | 数据总条数               |
| data.list                  | Array            | 商品收藏分页数据列表     |
| data.list.id               | Long             | 商品SPU编号              |
| data.list.name             | String           | 商品名称                 |
| data.list.keyword          | String           | 商品关键字               |
| data.list.introduction     | String           | 商品简介                 |
| data.list.description      | String           | 商品详情                 |
| data.list.categoryId       | Long             | 商品分类编号             |
| data.list.brandId          | Long             | 商品品牌编号             |
| data.list.picUrl           | String           | 商品封面图               |
| data.list.sliderPicUrls    | List<String>     | 商品轮播图               |
| data.list.sort             | Integer          | 排序字段                 |
| data.list.status           | Integer          | 商品状态                 |
| data.list.createTime       | LocalDateTime    | 商品创建时间             |
| data.list.specType         | Boolean          | 规格类型                 |
| data.list.price            | Integer          | 商品价格                 |
| data.list.marketPrice      | Integer          | 市场价                   |
| data.list.costPrice        | Integer          | 成本价                   |
| data.list.stock            | Integer          | 商品库存                 |
| data.list.skus             | List             | SKU数组                  |
| data.list.deliveryTypes    | List<Integer>    | 配送方式数组             |
| data.list.deliveryTemplateId | Long          | 物流配置模板编号         |
| data.list.giveIntegral     | Integer          | 赠送积分                 |
| data.list.subCommissionType| Boolean          | 分销类型                 |
| data.list.salesCount       | Integer          | 商品销量                 |
| data.list.virtualSalesCount| Integer          | 虚拟销量                 |
| data.list.browseCount      | Integer          | 浏览量                   |
| data.list.userId           | Long             | 用户编号                 |
| data.list.spuId            | Long             | 商品SPU编号              |
