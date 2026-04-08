# 商品属性项(mapper)_删除(mapper)

## mapper粒度
- 独立的商品属性项(mapper)_删除mapper类, ProductPropertyDeleteMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据`属性项编号`从数据库查询`商品属性项(entity)`。
- 根据`属性项编号`从数据库删除`商品属性项(entity)`。

# 商品属性值_商品属性项(mapper)_删除(mapper)

## mapper粒度
- 独立的商品属性值_商品属性项(mapper)_删除mapper类, ProductPropertyValuePropertyDeleteMapper，类名不要改，与ProductPropertyDeleteMapper放在同目录，不要创建通用的数据库操作对象。

## 方法描述
- 根据`属性项编号`从数据库查询`商品属性项(entity)`。
- 根据`属性项编号`从数据库删除`商品属性项(entity)`。
