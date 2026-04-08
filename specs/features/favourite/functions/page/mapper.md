# 商品收藏_分页查询(mapper)

## mapper粒度
- 独立的商品收藏_分页查询mapper类, ProductFavouritePageMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据分页参数`页码`pageNo、`页面大小`pageSize查询，并同时支持按以下有值的参数查询：`用户编号`，从数据库查询所有`商品属性项(entity)`列表并带分页属性。


# 商品SPU_批量查询(mapper)

## mapper粒度
- 独立的商品SPU_批量查询mapper类, ProductSpuBatchListMapper，建在目录favourite/page/mapper/下，不要创建通用的数据库操作对象。

## 方法描述
- 根据`商品SPU编号`列表从数据库查询所有`商品SPU(entity)`数据，需查看`spu/entity/product_spu.md`。
