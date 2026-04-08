# 商品SPU_删除(api)

## controller粒度
* 独立的商品SPU_删除controller类，ProductSpuDeleteController。

### 接口描述
删除商品SPU

### 请求地址
DELETE /product/spu/delete

### 请求方法
DELETE

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名 | 类型 | 是否必填 | 说明   |
|--------|------|----------|--------|
| id     | Long | 是       | SPU编号 |

### 响应参数
| 参数名 | 类型    | 说明               |
|--------|---------|--------------------|
| code   | int     | 响应码，200=成功    |
| msg    | String  | 响应信息           |
| data   | Boolean | 删除结果，true=成功 |
