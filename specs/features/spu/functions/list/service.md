# 商品SPU_查询列表(service)

## service粒度
* 独立的商品SPU_查询列表service类，ProductSpuListService。

## 方法描述
根据SPU编号集合查询商品SPU实体列表，并严格保持传入ID的顺序

## 业务逻辑
1. 数据库操作：根据`商品SPU_查询列表(api)-请求参数（Query）-商品SPU编号列表`，使用`商品SPU_查询列表(mapper)`的数据库操作对象查询`商品SPU(entity)`列表。
2. 数据库操作：根据`商品SPU_查询列表(api)-请求参数（Query）-商品SPU编号列表`，使用`商品SPU_查询列表(mapper)`的数据库操作对象查询`商品SKU(entity)`列表。
3. 数据转换：将对应的`商品SKU(entity)`列表设置到每个`商品SPU(entity)`中，最后返回`商品SPU_查询列表(api)-响应参数`数据对象。
4. 方法返回：返回`商品SPU_查询列表(api)-响应参数`数据对象。
