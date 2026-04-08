# 商品SPU_查询列表(api)

## Controller粒度
* 独立的商品SPU_查询列表Controller类：ProductSpuListController类

### 接口描述
获得商品SPU详情列表

### 请求地址
GET /product/spu/list

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名   | 类型            | 是否必填 | 说明               | 示例          |
|---------|-----------------|----------|--------------------|---------------|
| spuIds  | Collection<Long> | 是       | 商品SPU编号列表        | [1,2,3]       |

### 响应参数
| 参数名                        | 类型                          | 说明                     | 示例                                   |
|------------------------------|-------------------------------|--------------------------|----------------------------------------|
| code                         | int                           | 响应码，200=成功         | 200                                    |
| msg                          | String                        | 响应信息                 | 成功                                   |
| data                         | Array                         | 商品SPU列表数据          | -                                      |
| data.id                      | Long                          | 商品SPU编号              | 111                                    |
| data.name                    | String                        | 商品名称                 | 清凉小短袖                             |
| data.keyword                 | String                        | 关键字                   | 清凉丝滑不出汗                         |
| data.introduction            | String                        | 商品简介                 | 清凉小短袖简介                         |
| data.description             | String                        | 商品详情                 | 清凉小短袖详情                         |
| data.categoryId              | Long                          | 商品分类编号             | 1                                      |
| data.brandId                 | Long                          | 商品品牌编号             | 1                                      |
| data.picUrl                  | String                        | 商品封面图               | https://www.iocoder.cn/xx.png          |
| data.sliderPicUrls           | List<String>                  | 商品轮播图               | [https://www.iocoder.cn/xx.png, https://www.iocoder.cn/xxx.png] |
| data.sort                    | Integer                       | 排序字段                 | 1                                      |
| data.status                  | Integer                       | 商品状态                 | 1                                      |
| data.createTime              | LocalDateTime                 | 商品创建时间             | 2023-05-24 00:00:00                    |
| data.specType                | Boolean                       | 规格类型                 | true                                   |
| data.price                   | Integer                       | 商品价格（单位：分）| 1999                                   |
| data.marketPrice             | Integer                       | 市场价（单位：分）| 199                                    |
| data.costPrice               | Integer                       | 成本价（单位：分）| 19                                     |
| data.stock                   | Integer                       | 商品库存                 | 10000                                  |
| data.skus                    | List<ProductSkuRespVO>        | SKU数组                  | -                                      |
| data.skus.id                 | Long                          | SKU主键                  | 1024                                   |
| data.skus.name               | String                        | 商品SKU名字              | 清凉小短袖                             |
| data.skus.price              | Integer                       | 销售价格（单位：分）| 1999                                   |
| data.skus.marketPrice        | Integer                       | 市场价                   | 2999                                   |
| data.skus.costPrice          | Integer                       | 成本价                   | 19                                     |
| data.skus.barCode            | String                        | 条形码                   | 15156165456                            |
| data.skus.picUrl             | String                        | 图片地址                 | https://www.iocoder.cn/xx.png          |
| data.skus.stock              | Integer                       | 库存                     | 200                                    |
| data.skus.weight             | Double                        | 商品重量（单位：kg）| 1.2                                    |
| data.skus.volume             | Double                        | 商品体积（单位：m³）| 2.5                                    |
| data.skus.firstBrokeragePrice | Integer                      | 一级分销佣金（单位：分）| 199                                    |
| data.skus.secondBrokeragePrice | Integer                     | 二级分销佣金（单位：分）| 19                                     |
| data.skus.properties         | List<Property>                | 属性数组                 | -                                      |
| data.skus.properties.propertyId | Long                        | 属性编号                 | 10                                     |
| data.skus.properties.propertyName | String                    | 属性名字                 | 颜色                                   |
| data.skus.properties.valueId | Long                          | 属性值编号               | 10                                     |
| data.skus.properties.valueName | String                      | 属性值名字               | 红色                                   |
| data.deliveryTypes           | List<Integer>                 | 配送方式数组             | 1                                      |
| data.deliveryTemplateId      | Long                          | 物流配置模板编号         | 111                                    |
| data.giveIntegral            | Integer                       | 赠送积分                 | 111                                    |
| data.subCommissionType       | Boolean                       | 分销类型                 | true                                   |
| data.salesCount              | Integer                       | 商品销量                 | 2000                                   |
| data.virtualSalesCount       | Integer                       | 虚拟销量                 | 66                                     |
| data.browseCount             | Integer                       | 浏览量                   | 888                                    |
