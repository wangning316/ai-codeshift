# 商品SPU_查询(api)

## controller粒度
- 独立的商品SPU_查询controller类，ProductSpuGetController。

### 接口描述
查询商品SPU明细（包含关联SKU列表）

### 请求地址
GET /product/spu/get-detail

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名 | 类型 | 是否必填 | 说明 | 示例  |
|--------|------|----------|------|-------|
| id     | Long | 是       | 商品SPU编号 | 1024 |

### 响应参数
| 参数名 | 类型 | 说明 |
|--------|------|------|
| code | Integer | 响应码，200=成功 |
| msg | String | 响应提示信息 |
| data.id | Long | 商品SPU编号 |
| data.name | String | 商品名称 |
| data.keyword | String | 关键字 |
| data.introduction | String | 商品简介 |
| data.description | String | 商品详情 |
| data.categoryId | Long | 商品分类编号 |
| data.brandId | Long | 商品品牌编号 |
| data.picUrl | String | 商品封面图 |
| data.sliderPicUrls | List<String> | 商品轮播图 |
| data.sort | Integer | 排序字段 |
| data.status | Integer | 商品状态 |
| data.createTime | LocalDateTime | 商品创建时间 |
| data.specType | Boolean | 规格类型 |
| data.price | Integer | 商品价格（单位：分） |
| data.marketPrice | Integer | 市场价（单位：分） |
| data.costPrice | Integer | 成本价（单位：分） |
| data.stock | Integer | 商品库存 |
| data.deliveryTypes | List<Integer> | 配送方式数组 |
| data.deliveryTemplateId | Long | 物流配置模板编号 |
| data.giveIntegral | Integer | 赠送积分 |
| data.subCommissionType | Boolean | 分销类型 |
| data.salesCount | Integer | 商品销量 |
| data.virtualSalesCount | Integer | 虚拟销量 |
| data.browseCount | Integer | 浏览量 |
| data.skus | List<ProductSkuRespVO> | SKU数组 |
| data.skus[].id | Long | SKU主键 |
| data.skus[].name | String | 商品SKU名字 |
| data.skus[].price | Integer | 销售价格（单位：分） |
| data.skus[].marketPrice | Integer | 市场价 |
| data.skus[].costPrice | Integer | 成本价 |
| data.skus[].barCode | String | 条形码 |
| data.skus[].picUrl | String | 图片地址 |
| data.skus[].stock | Integer | 库存 |
| data.skus[].weight | Double | 商品重量（kg） |
| data.skus[].volume | Double | 商品体积（m³） |
| data.skus[].firstBrokeragePrice | Integer | 一级分销佣金（单位：分） |
| data.skus[].secondBrokeragePrice | Integer | 二级分销佣金（单位：分） |
| data.skus[].properties | List<Property> | 属性数组 |
| data.skus[].properties[].propertyId | Long | 属性编号 |
| data.skus[].properties[].propertyName | String | 属性名字 |
| data.skus[].properties[].valueId | Long | 属性值编号 |
| data.skus[].properties[].valueName | String | 属性值名字 |
