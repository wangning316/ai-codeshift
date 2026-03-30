# 商品分类(entity)

## 数据库表名
product_category

## 属性
| 属性名     | 类型          | MyBatis-Plus注解 | 说明 |
|-----------|---------------|------------------|------|
| id        | Long          | @TableId         | 分类编号 |
| parentId  | Long          | 无               | 父分类编号（根分类为0） |
| name      | String        | 无               | 分类名称 |
| picUrl    | String        | 无               | 移动端分类图（建议180*180分辨率） |
| sort      | Integer       | 无               | 分类排序 |
| status    | Integer       | 无               | 开启状态（枚举CommonStatusEnum） |
| createTime| LocalDateTime | @TableField(fill = FieldFill.INSERT) | 创建时间 |
| updateTime| LocalDateTime | @TableField(fill = FieldFill.INSERT_UPDATE) | 最后更新时间 |
| creator   | String        | @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR) | 创建者（SysUser的id编号） |
| updater   | String        | @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR) | 更新者（SysUser的id编号） |
| deleted   | Boolean       | @TableLogic      | 是否删除（逻辑删除字段） |