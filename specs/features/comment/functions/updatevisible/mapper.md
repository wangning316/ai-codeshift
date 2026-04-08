# 商品评价_显示隐藏(mapper)

## mapper粒度
- 独立的商品评价_显示隐藏mapper类, ProductCommentVisibleMapper，不要创建通用的数据库操作对象。

## 方法描述
- 根据`评论编号`从数据库查询`商品评价(entity)`。
- 根据`商品评价(entity)`更新到数据库。
