# 商品SPU_查询(Service)

## Service粒度
- 独立的商品SPU_查询service类，ProductSpuGetService。

## 方法描述
查询商品SPU明细，包含关联的SKU列表

## 业务逻辑
1. 数据库操作：根据`商品SPU_查询(api)-请求参数（Query）-商品SPU编号`，使用`商品SPU_查询(mapper)`数据库操作对象，根据SPU编号查询唯一的`商品SPU(entity)`。
2. 数据库操作：若SPU数据存在，根据SPU编号调用`商品SPU_查询(mapper)`数据库操作对象，查询该SPU关联的全部`商品SKU(entity)`列表。
3. 数据转换：通过转换器将`商品SPU(entity)`和`商品SKU(entity)列表`转换为`查询商品SPU-响应参数`数据对象。
4. 方法返回：返回`查询商品SPU-响应参数`数据对象。
