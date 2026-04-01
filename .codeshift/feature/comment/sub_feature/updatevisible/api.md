## 商品分类_更新(api)

## controller粒度
* 独立的商品分类_更新controller类，ProductCategoryUpdateController。
* 
### 接口描述
更新商品分类

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
| id         | Long    | 是       | 分类编号（更新必填） | 必填，无注解校验 |
| parentId   | Long    | 是       | 父分类编号     | @NotNull，校验不通过提示：父分类编号不能为空 |
| name       | String  | 是       | 分类名称       | @NotBlank，校验不通过提示：分类名称不能为空 |
| picUrl     | String  | 是       | 移动端分类图   | @NotBlank，校验不通过提示：移动端分类图不能为空 |
| sort       | Integer | 是       | 分类排序       | 必填，无额外注解校验 |
| status     | Integer | 是       | 开启状态       | @NotNull，校验不通过提示：开启状态不能为空 |
| description| String  | 否       | 分类描述       | 无校验 |

### 响应参数
| 参数名  | 类型    | 说明               |
|--------|---------|--------------------|
| code   | int     | 响应码，200=成功    |
| msg    | String  | 响应信息           |
| data   | Boolean | 更新结果，true=成功 |