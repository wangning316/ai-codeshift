# 商品SKU(entity)

## 数据库表名
product_sku

## 属性
| 属性名                  | 类型            | MyBatis-Plus注解 | 说明 |
|-------------------------|-----------------|------------------|------|
| id                      | Long            | @TableId         | 商品SKU编号，自增 |
| spuId                   | Long            | 无               | SPU编号，关联ProductSpuDO.getId() |
| properties              | List<Property>  | @TableField(typeHandler = JacksonTypeHandler.class) | 属性数组，JSON格式 |
| price                   | Integer         | 无               | 商品价格，单位：分 |
| marketPrice             | Integer         | 无               | 市场价，单位：分 |
| costPrice               | Integer         | 无               | 成本价，单位：分 |
| barCode                 | String          | 无               | 商品条码 |
| picUrl                  | String          | 无               | 图片地址 |
| stock                   | Integer         | 无               | 库存 |
| weight                  | Double          | 无               | 商品重量，单位：kg 千克 |
| volume                  | Double          | 无               | 商品体积，单位：m³ 立方米 |
| firstBrokeragePrice     | Integer         | 无               | 一级分销的佣金，单位：分 |
| secondBrokeragePrice    | Integer         | 无               | 二级分销的佣金，单位：分 |
| salesCount              | Integer         | 无               | 商品销量 |
| createTime              | LocalDateTime   | @TableField(fill = FieldFill.INSERT) | 创建时间 |
| updateTime              | LocalDateTime   | @TableField(fill = FieldFill.INSERT_UPDATE) | 最后更新时间 |
| creator                 | String          | @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR) | 创建者（SysUser的id编号） |
| updater                 | String          | @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR) | 更新者（SysUser的id编号） |
| deleted                 | Boolean         | @TableLogic      | 是否删除（逻辑删除字段） |

## 内部类：Property（商品属性）
| 属性名        | 类型    | 说明 |
|---------------|---------|------|
| propertyId    | Long    | 属性编号，关联ProductPropertyDO.getId() |
| propertyName  | String  | 属性名字，冗余ProductPropertyDO.getName() |
| valueId       | Long    | 属性值编号，关联ProductPropertyValueDO.getId() |
| valueName     | String  | 属性值名字，冗余ProductPropertyValueDO.getName() |
