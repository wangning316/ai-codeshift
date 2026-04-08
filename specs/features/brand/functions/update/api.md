## 商品品牌_更新(api)

## controller粒度
* 独立的商品品牌_更新controller类，ProductBrandUpdateController。
* 
### 接口描述
更新商品品牌

### 请求地址
PUT /product/category/update

### 请求方法
PUT

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Body）
| 参数名      | 类型    | 是否必填 | 说明           | 校验说明 |
|------------|---------|----------|----------------|----------|
| id         | Long    | 是       | 品牌编号       | @NotNull，校验不通过提示：品牌编号不能为空 |
| name       | String  | 是       | 品牌名称       | @NotNull，校验不通过提示：品牌名称不能为空 |
| picUrl     | String  | 是       | 品牌图片       | @NotNull，校验不通过提示：品牌图片不能为空 |
| sort       | Integer | 是       | 品牌排序       | @NotNull，校验不通过提示：品牌排序不能为空 |
| status     | Integer | 是       | 状态           | @NotNull，校验不通过提示：状态不能为空 |
| description| String  | 否       | 品牌描述       | 无校验 |

### 响应参数
| 参数名  | 类型    | 说明               |
|--------|---------|--------------------|
| code   | int     | 响应码，200=成功    |
| msg    | String  | 响应信息           |
| data   | Boolean | 更新结果，true=成功 |
