# 商品SPU_查询(mapper)

## mapper粒度
- 独立的商品SPU_查询mapper类， ProductSpuGetMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据`商品SPU编号`从数据库查询`商品SPU(entity)`。
- 根据`商品SPU编号`从数据库查询所有`商品SKU(entity)`，需查看`spu/entity/product_sku.md`。
