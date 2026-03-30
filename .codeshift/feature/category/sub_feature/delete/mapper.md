# 商品分类_删除(mapper)

## mapper粒度
* 独立的商品分类_删除mapper类, ProductCategoryDeleteMapper，不要创建通用的数据库操作对象。

## 方法描述
* 根据`分类编号`从数据库查询`商品分类(entity)`。
* 根据`分类编号`从数据库删除`商品分类(entity)`。