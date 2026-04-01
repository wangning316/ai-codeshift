# 商品评论(entity)

## 数据库表名
product_comment

## 属性
| 属性名            | 类型                          | MyBatis-Plus注解 | 说明 |
|------------------|-------------------------------|------------------|------|
| id               | Long                          | @TableId         | 评论编号，主键自增 |
| userId            | Long                          | 无               | 评价人的用户编号（关联MemberUserDO的id编号） |
| userNickname     | String                        | 无               | 评价人名称 |
| userAvatar       | String                        | 无               | 评价人头像 |
| anonymous        | Boolean                       | 无               | 是否匿名 |
| orderId          | Long                          | 无               | 交易订单编号（关联TradeOrderDO的id编号） |
| orderItemId      | Long                          | 无               | 交易订单项编号（关联TradeOrderItemDO的id编号） |
| spuId            | Long                          | 无               | 商品SPU编号（关联ProductSpuDO的id编号） |
| spuName          | String                        | 无               | 商品SPU名称（关联ProductSpuDO的name） |
| skuId            | Long                          | 无               | 商品SKU编号（关联ProductSkuDO的id编号） |
| skuPicUrl        | String                        | 无               | 商品SKU图片地址（关联ProductSkuDO的picUrl） |
| skuProperties    | List<ProductSkuDO.Property>   | @TableField(typeHandler = JacksonTypeHandler.class) | 属性数组，JSON格式（关联ProductSkuDO的properties） |
| visible          | Boolean                       | 无               | 是否可见（true:显示；false:隐藏） |
| scores           | Integer                       | 无               | 评分星级（1-5分） |
| descriptionScores| Integer                       | 无               | 描述星级（1-5星） |
| benefitScores    | Integer                       | 无               | 服务星级（1-5星） |
| content          | String                        | 无               | 评论内容 |
| picUrls          | List<String>                  | @TableField(typeHandler = JacksonTypeHandler.class) | 评论图片地址数组 |
| replyStatus      | Boolean                       | 无               | 商家是否回复 |
| replyUserId      | Long                          | 无               | 回复管理员编号（关联AdminUserDO的id编号） |
| replyContent     | String                        | 无               | 商家回复内容 |
| replyTime        | LocalDateTime                 | 无               | 商家回复时间 |
| createTime       | LocalDateTime                 | @TableField(fill = FieldFill.INSERT) | 创建时间 |
| updateTime       | LocalDateTime                 | @TableField(fill = FieldFill.INSERT_UPDATE) | 最后更新时间 |
| creator          | String                        | @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR) | 创建者（SysUser的id编号） |
| updater          | String                        | @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR) | 更新者（SysUser的id编号） |
| deleted          | Boolean                       | @TableLogic      | 是否删除（逻辑删除字段） |
