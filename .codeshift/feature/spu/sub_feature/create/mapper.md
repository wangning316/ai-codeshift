# 商品SPU_创建(Service)

## mapper粒度
* 独立的商品SPU_创建mapper类, ProductSpuCreateMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据商品`分类编号`从数据库查询`商品分类(entity)`，需查看`category/entity/product_category.md`。
- 根据商品`品牌编号`从数据库查询`商品品牌(entity)`，需查看`brand/entity/product_brand.md`。
- 根据`属性项编号`列表批量重数据库查询`商品属性项(entity)`，需查看`property/entity/product_property.md`。
- 根据`商品SPU(entity)`插入数据库。
- 根据商品`SPU编号`从数据库查询所有`商品SKU(entity)`。
- 根据`商品SKU(entity)`列表批量插入数据库。
