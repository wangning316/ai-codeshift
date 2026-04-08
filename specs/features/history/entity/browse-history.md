# 商品浏览记录(entity)

## 数据库表名
product_browse_history

## 属性
| 属性名     | 类型          | MyBatis-Plus注解 | 说明 |
|-----------|---------------|------------------|------|
| id        | Long          | @TableId         | 浏览记录编号，主键自增 |
| userId    | Long          | 无               | 用户编号，关联 MemberUserDO 的 id 编号 |
| spuId     | Long          | 无               | 商品SPU编号，关联 ProductSpuDO 的 id 编号 |
| userDeleted | Boolean     | 无               | 用户是否删除 |
| createTime| LocalDateTime | @TableField(fill = FieldFill.INSERT) | 创建时间 |
| updateTime| LocalDateTime | @TableField(fill = FieldFill.INSERT_UPDATE) | 最后更新时间 |
| creator   | String        | @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR) | 创建者（SysUser的id编号） |
| updater   | String        | @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR) | 更新者（SysUser的id编号） |
| deleted   | Boolean       | @TableLogic      | 是否删除（逻辑删除字段） |
