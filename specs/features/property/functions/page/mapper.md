# 商品属性项_分页查询(mapper)

## mapper粒度
* 独立的商品属性项_分页查询mapper类, ProductPropertyPageMapper，不要创建通用的数据库操作对象。

## 方法描述
* 根据分页参数`页码`pageNo、`页面大小`pageSize查询，并同时支持按以下有值的参数查询：`属性项名称`、`状态`、`创建时间范围`，从数据库查询所有`商品属性项(entity)`列表并带分页属性。
