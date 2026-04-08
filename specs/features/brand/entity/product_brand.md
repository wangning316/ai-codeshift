# 商品品牌(entity)

## 数据库表名
product_brand

## 属性
| 属性名     | 类型          | MyBatis-Plus注解 | 说明 |
|-----------|---------------|------------------|------|
| id        | Long          | @TableId         | 品牌编号 |
| name      | String        | 无               | 品牌名称 |
| picUrl    | String        | 无               | 品牌图片 |
| sort      | Integer       | 无               | 品牌排序 |
| description| String       | 无               | 品牌描述 |
| status    | Integer       | 无               | 状态（枚举CommonStatusEnum） |
| createTime| LocalDateTime | @TableField(fill = FieldFill.INSERT) | 创建时间 |
| updateTime| LocalDateTime | @TableField(fill = FieldFill.INSERT_UPDATE) | 最后更新时间 |
| creator   | String        | @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR) | 创建者（SysUser的id编号） |
| updater   | String        | @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR) | 更新者（SysUser的id编号） |
| deleted   | Boolean       | @TableLogic      | 是否删除（逻辑删除字段） |
