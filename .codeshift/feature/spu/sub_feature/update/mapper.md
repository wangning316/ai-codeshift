# 商品分类_更新(mapper)

## mapper粒度
* 独立的商品分类_更新mapper类, ProductCategoryUpdateMapper，不要创建通用的数据库操作对象。

## 方法描述
* 根据`父分类编号`从数据库查询`商品分类(entity)`。
* 根据`商品分类(entity)`更新到数据库。
* - 根据商品`SPU编号`从数据库查询所有`商品SKU(entity)`。
