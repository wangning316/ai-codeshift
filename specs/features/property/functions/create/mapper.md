# 商品属性项_创建(mapper)

## mapper粒度
- 独立的商品属性项_创建mapper类, ProductPropertyCreateMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据`属性项名称`从数据库查询第一个满足条件的`商品属性项(entity)`。
- 根据`商品属性项(entity)`插入数据库。
