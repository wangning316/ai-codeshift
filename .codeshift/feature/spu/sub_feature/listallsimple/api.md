# 商品SPU_查询精简列表(api)

## controller粒度
* 独立的商品SPU_查询精简列表controller类，ProductSpuListAllSimpleController。

### 接口描述
获得商品SPU精简列表，主要用于前端的下拉选项

### 请求地址
GET /product/spu/list-all-simple

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
无

### 响应参数
| 参数名              | 类型        | 说明                     |
|--------------------|-------------|--------------------------|
| code               | Integer     | 响应码，200=成功          |
| msg                | String      | 响应提示信息             |
| data               | Array       | 商品SPU精简信息列表      |
| data.id            | Long        | 主键                     |
| data.name          | String      | 商品名称                 |
| data.price         | Integer     | 商品价格，单位：分       |
| data.marketPrice   | Integer     | 商品市场价，单位：分     |
| data.costPrice     | Integer     | 商品成本价，单位：分     |
| data.stock         | Integer     | 商品库存                 |
| data.salesCount    | Integer     | 商品销量                 |
| data.virtualSalesCount | Integer | 商品虚拟销量           |
| data.browseCount   | Integer     | 商品浏览量               |
