# 商品属性项_更新(api)

## controller粒度
* 独立的商品属性项_更新controller类，ProductPropertyUpdateController。

### 接口描述
更新商品属性项

### 请求地址
PUT /product/property/update

### 请求方法
PUT

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Body）
| 参数名      | 类型    | 是否必填 | 说明           | 校验说明 |
|------------|---------|----------|----------------|----------|
| id         | Long    | 是       | 属性项编号（更新必填） | 必填，无注解校验 |
| name       | String  | 是       | 属性项名称     | @NotBlank，校验不通过提示：名称不能为空 |
| remark     | String  | 否       | 备注           | 无校验 |

### 响应参数
| 参数名  | 类型    | 说明               |
|--------|---------|--------------------|
| code   | int     | 响应码，200=成功    |
| msg    | String  | 响应信息           |
| data   | Boolean | 更新结果，true=成功 |
