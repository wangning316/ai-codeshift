# 商品SPU_分页TabCount查询(api)

## controller粒度
* 独立的商品SPU_分页TabCount查询controller类，ProductSpuTabCountController。

### 接口描述
获得商品SPU分页Tab数量统计（按状态统计总数）

### 请求地址
GET /product/spu/get-count

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
无

### 响应参数
| 参数名 | 类型               | 说明                     |
|--------|--------------------|--------------------------|
| code   | Integer            | 响应码，200=成功         |
| msg    | String             | 响应提示信息             |
| data   | Map<Integer, Long> | 状态-数量键值对：key=状态值，value=对应数量 |
