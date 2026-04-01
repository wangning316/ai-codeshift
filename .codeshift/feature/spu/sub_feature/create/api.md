# 商品SPU_创建(api)
## controller粒度
* 独立的商品SPU_创建controller类，ProductSpuCreateController。

### 接口描述
创建商品SPU

### 请求地址
POST /product/spu/create

### 请求方法
POST

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数(Body)
| 参数名              | 类型                          | 是否必填 | 说明                      | 校验说明                                                     |
|---------------------|-------------------------------|----------|-------------------------|--------------------------------------------------------------|
| id                  | Long                          | 否       | 商品编号                    | 无校验                                                       |
| name                | String                        | 是       | 商品名称                    | 非空校验，校验不通过提示：商品名称不能为空                   |
| keyword             | String                        | 是       | 关键字                     | 非空校验，校验不通过提示：商品关键字不能为空                 |
| introduction        | String                        | 是       | 商品简介                    | 非空校验，校验不通过提示：商品简介不能为空                   |
| description         | String                        | 是       | 商品详情                    | 非空校验，校验不通过提示：商品详情不能为空                   |
| categoryId          | Long                          | 是       | 商品分类编号                  | 非空校验，校验不通过提示：商品分类不能为空                   |
| brandId             | Long                          | 是       | 商品品牌编号                  | 非空校验，校验不通过提示：商品品牌不能为空                   |
| picUrl              | String                        | 是       | 商品封面图                   | 非空校验，校验不通过提示：商品封面图不能为空                 |
| sliderPicUrls       | List<String>                  | 是       | 商品轮播图                   | 无额外注解校验                                               |
| sort                | Integer                       | 是       | 排序字段                    | 必填，非空校验，校验不通过提示：商品排序字段不能为空         |
| specType            | Boolean                       | 是       | 规格类型：false-单规格，true-多规格 | 非空校验，校验不通过提示：商品规格类型不能为空               |
| deliveryTypes       | List<Integer>                 | 是       | 配送方式数组                  | 非空校验，校验不通过提示：配送方式不能为空                   |
| deliveryTemplateId  | Long                          | 是       | 物流配置模板编号                | 无额外注解校验                                               |
| giveIntegral        | Integer                       | 是       | 赠送积分                    | 非空校验，校验不通过提示：商品赠送积分不能为空               |
| subCommissionType   | Boolean                       | 是       | 分销类型                    | 非空校验，校验不通过提示：商品分销类型不能为空               |
| virtualSalesCount   | Integer                       | 否       | 虚拟销量                    | 无校验                                                       |
| salesCount          | Integer                       | 是       | 商品销量                    | 无额外注解校验                                               |
| browseCount         | Integer                       | 是       | 浏览量                     | 无额外注解校验                                               |
| skus                | List<ProductSkuSaveReqVO>     | 否       | SKU列表                   | 嵌套校验，内部属性按SKU校验规则执行                           |

#### SKU数组子参数(skus)
| 参数名                  | 类型                          | 是否必填 | 说明                                 | 校验说明                                                     |
|-------------------------|-------------------------------|----------|--------------------------------------|--------------------------------------------------------------|
| name                    | String                        | 是       | 商品SKU名字                          | 非空校验，校验不通过提示：商品SKU名字不能为空               |
| price                   | Integer                       | 是       | 销售价格，单位：分                   | 非空校验，校验不通过提示：销售价格，单位：分不能为空         |
| marketPrice             | Integer                       | 否       | 市场价                               | 无校验                                                       |
| costPrice               | Integer                       | 否       | 成本价                               | 无校验                                                       |
| barCode                 | String                        | 否       | 条形码                               | 无校验                                                       |
| picUrl                  | String                        | 是       | 图片地址                             | 非空校验，校验不通过提示：图片地址不能为空                   |
| stock                   | Integer                       | 是       | 库存                                 | 非空校验，校验不通过提示：库存不能为空                       |
| weight                  | Double                        | 否       | 商品重量，单位：kg千克               | 无校验                                                       |
| volume                  | Double                        | 否       | 商品体积，单位：m³立方米             | 无校验                                                       |
| firstBrokeragePrice     | Integer                       | 否       | 一级分销的佣金，单位：分             | 无校验                                                       |
| secondBrokeragePrice    | Integer                       | 否       | 二级分销的佣金，单位：分             | 无校验                                                       |
| properties              | List<Property>                | 否       | 属性数组                             | 无校验                                                       |

#### 属性子参数(properties)
| 参数名        | 类型    | 是否必填 | 说明         | 校验说明 |
|---------------|---------|----------|--------------|----------|
| propertyId    | Long    | 否       | 属性编号     | 无校验   |
| propertyName  | String  | 否       | 属性名字     | 无校验   |
| valueId       | Long    | 否       | 属性值编号   | 无校验   |
| valueName     | String  | 否       | 属性值名字   | 无校验   |

### 响应参数
| 参数名  | 类型   | 说明               |
|--------|--------|--------------------|
| code   | int    | 响应码，200=成功    |
| msg    | String | 响应信息           |
| data   | Long   | 创建成功的商品SPU编号 |
