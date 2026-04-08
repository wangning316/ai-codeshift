# 商品品牌_更新(mapper)

## mapper粒度
* 独立的商品品牌_更新mapper类, ProductBrandUpdateMapper，不要创建通用的数据库操作对象。

## 方法描述
* 根据`品牌编号`从数据库查询`商品品牌(entity)`。
* 根据`品牌名称`从数据库查询第一个满足条件的`商品品牌(entity)`。
* 根据`商品品牌(entity)`更新到数据库。
