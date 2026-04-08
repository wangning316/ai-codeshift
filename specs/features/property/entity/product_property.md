# 商品属性项(entity)

## 数据库表名
product_property

## 属性
| 属性名     | 类型          | MyBatis-Plus注解 | 说明 |
|-----------|---------------|------------------|------|
| id        | Long          | @TableId         | 属性项编号 |
| name      | String        | 无               | 属性项名称 |
| remark    | String        | 无               | 备注 |
| createTime| LocalDateTime | @TableField(fill = FieldFill.INSERT) | 创建时间 |
| updateTime| LocalDateTime | @TableField(fill = FieldFill.INSERT_UPDATE) | 最后更新时间 |
| creator   | String        | @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR) | 创建者（SysUser的id编号） |
| updater   | String        | @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR) | 更新者（SysUser的id编号） |
| deleted   | Boolean       | @TableLogic      | 是否删除（逻辑删除字段） |

## 常量
| 常量名       | 类型    | 值    | 说明 |
|--------------|---------|-------|------|
| ID_DEFAULT   | Long    | 0L    | SPU单规格时，默认属性ID |
| NAME_DEFAULT | String  | "默认" | SPU单规格时，默认属性名称 |
