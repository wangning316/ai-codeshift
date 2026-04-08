# 商品评价_创建(mapper)

## mapper粒度
- 独立的商品评价_创建mapper类, ProductCommentCreateMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据`商品评价(entity)`插入数据库。

# 商品SKU_查询(mapper)

## mapper粒度
- 独立的商品SKU_查询mapper类, ProductSkuForCommentCreateMapper，建在目录comment/create/mapper/下，不要创建通用的数据库操作对象。

## 方法描述
- 根据`商品SKU编号`查询唯一`商品SKU(entity)`。

# 商品SPU_查询(mapper)

## mapper粒度
- 独立的商品SPU_查询mapper类, ProductSpuForCommentCreateMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据`商品SPU编号`查询唯一`商品SPU(entity)`。
