# 商品SPU_查询精简列表(service)

## service粒度
* 独立的商品SPU_查询精简列表service类，ProductSpuListAllSimpleService。

## 方法描述
查询`已启用状态`的商品SPU精简信息列表

## 业务逻辑
1. 数据库操作：使用`商品SPU_查询精简列表(mapper)`的数据库操作对象，查询`状态`为`上架`的所有`商品SPU(entity)`列表。将查询到的商品SPU列表，按照`sort`排序字段进行`降序`排序。
2. 数据转换：将数据库查询并排序后的`商品SPU(entity)`列表，转换为`商品SPU_查询精简列表(api)-响应参数`数据对象。
3. 方法返回：返回`商品SPU_查询精简列表(api)-响应参数`数据对象。
