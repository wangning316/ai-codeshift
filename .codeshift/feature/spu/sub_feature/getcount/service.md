# 商品SPU_分页TabCount查询(Service)

## Service粒度
 独立的商品SPU_分页TabCount查询service类，ProductSpuTabCountService。

## 方法描述
获得商品SPU分页Tab数量统计，按销售中、仓库中、售空、警戒库存、回收站5种维度统计数量

## 业务逻辑
1. 数据库统计：按销售中、仓库中、售空、警戒库存、回收站5种维度统计数量：
    - 统计销售中(key为0)商品数量：根据`商品状态`为`上架`，使用`商品SPU_分页TabCount查询(mapper)`统计数量。
    - 统计仓库中(key为1)商品数量：根据`商品状态`为`上架`，使用`商品SPU_分页TabCount查询(mapper)`统计数量。
    - 统计售空(key为2)商品数量：根据`库存`为0，使用`商品SPU_分页TabCount查询(mapper)`统计数量。
    - 统计警戒库存(key为3)商品数量：根据`库存`为小于等于10且`商品状态`不为`回收站`，使用`商品SPU_分页TabCount查询(mapper)`统计数量。
    - 统计回收站(key为4)商品数量：根据`商品状态`为`回收站`，使用`商品SPU_分页TabCount查询(mapper)`统计数量。
2. 方法返回：返回`商品SPU_分页TabCount查询(api)-响应参数`的5种维度统计数量的Map对象。
