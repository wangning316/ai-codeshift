# 商品属性项_更新(mapper)

## mapper粒度
* 独立的商品属性项_更新mapper类, ProductPropertyUpdateMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据`属性项名称`从数据库查询第一个满足条件的`商品属性项(entity)`。
- 根据`商品属性项(entity)`更新到数据库。
- 查询所有`商品SKU(entity)`对象，需查看`spu/entity/product_sku.md`。
- 根据所有`商品SKU(entity)`列表数据批量更新到数据库，需查看`spu/entity/product_sku.md`。


# 商品SKU_商品属性项_更新(mapper)

## mapper粒度
* 独立的商品SKU_商品属性项_更新mapper类, ProductSkuPropertyUpdateMapper，类名不要改，与ProductPropertyUpdateMapper放在同目录，不要创建通用的数据库操作对象。

## 方法描述
- 查询所有`商品SKU(entity)`对象，需查看`spu/entity/product_sku.md`。
- 根据所有`商品SKU(entity)`列表数据批量更新到数据库，需查看`spu/entity/product_sku.md`。
