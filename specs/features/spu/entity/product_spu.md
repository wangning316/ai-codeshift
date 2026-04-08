# 商品SPU(entity)

## 数据库表名
product_spu

## 属性
| 属性名              | 类型            | MyBatis-Plus注解 | 说明                                              |
|---------------------|-----------------|------------------|-------------------------------------------------|
| id                  | Long            | @TableId         | 商品SPU编号，自增                                      |
| name                | String          | 无               | 商品名称                                            |
| keyword             | String          | 无               | 关键字                                             |
| introduction        | String          | 无               | 商品简介                                            |
| description         | String          | 无               | 商品详情                                            |
| categoryId          | Long            | 无               | 商品分类编号，关联ProductCategoryDO.getId()              |
| brandId             | Long            | 无               | 商品品牌编号，关联ProductBrandDO.getId()                 |
| picUrl              | String          | 无               | 商品封面图                                           |
| sliderPicUrls       | List<String>    | @TableField(typeHandler = JacksonTypeHandler.class) | 商品轮播图                                           |
| sort                | Integer         | 无               | 排序字段                                            |
| status              | Integer         | 无               | 商品状态，枚举ProductSpuStatusEnum，回收站(-1)，下架(0)，上架(1) |
| specType            | Boolean         | 无               | 规格类型：false-单规格，true-多规格                         |
| price               | Integer         | 无               | 商品价格，单位：分（取SKU最低单价）                             |
| marketPrice         | Integer         | 无               | 市场价，单位：分（取SKU最低单价）                              |
| costPrice           | Integer         | 无               | 成本价，单位：分（取SKU最低单价）                              |
| stock               | Integer         | 无               | 库存（SKU库存求和）                                     |
| deliveryTypes       | List<Integer>   | @TableField(typeHandler = JacksonTypeHandler.class) | 配送方式数组，对应DeliveryTypeEnum枚举                     |
| deliveryTemplateId  | Long            | 无               | 物流配置模板编号                                        |
| giveIntegral        | Integer         | 无               | 赠送积分                                            |
| subCommissionType   | Boolean         | 无               | 分销类型：false-默认，true-自行设置                         |
| salesCount          | Integer         | 无               | 商品销量                                            |
| virtualSalesCount   | Integer         | 无               | 虚拟销量                                            |
| browseCount         | Integer         | 无               | 浏览量                                             |
| createTime          | LocalDateTime    | @TableField(fill = FieldFill.INSERT) | 创建时间                                            |
| updateTime          | LocalDateTime    | @TableField(fill = FieldFill.INSERT_UPDATE) | 最后更新时间                                          |
| creator             | String          | @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR) | 创建者（SysUser的id编号）                               |
| updater             | String          | @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR) | 更新者（SysUser的id编号）                               |
| deleted             | Boolean         | @TableLogic      | 是否删除（逻辑删除字段）                                    |
