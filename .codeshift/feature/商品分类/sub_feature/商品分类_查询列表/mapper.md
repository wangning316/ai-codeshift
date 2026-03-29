# 商品分类_查询列表(mapper)

## mapper粒度
* 独立的商品分类_查询列表mapper类, ProductCategoryListMapper。

## 方法描述
* 根据`分类名称`、`开启状态`、`父分类编号`、`父分类编号数组`有值的组合参数从数据库查询`商品分类(entity)`列表。