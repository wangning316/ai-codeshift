## 商品分类_查询列表(api)

## controller粒度
* 独立的商品分类_查询列表controller类，ProductCategoryListController。

### 接口描述
获得商品分类列表

### 请求地址
GET /product/category/list

### 请求方法
GET

### 请求头
| 参数名        | 类型   | 是否必填 | 说明               |
|--------------|--------|----------|--------------------|
| Content-Type | String | 是       | 固定值：application/json |

### 请求参数（Query）
| 参数名     | 类型            | 是否必填 | 说明               |
|-----------|-----------------|----------|--------------------|
| name      | String          | 否       | 分类名称           |
| status    | Integer         | 否       | 开启状态           |
| parentId  | Long            | 否       | 父分类编号         |
| parentIds | Collection<Long>| 否       | 父分类编号数组     |

### 响应参数
| 参数名            | 类型            | 说明                     |
|------------------|-----------------|--------------------------|
| code             | int             | 响应码，200=成功         |
| msg              | String          | 响应信息                 |
| data             | Array           | 商品分类列表数据         |
| data.id          | Long            | 分类编号                 |
| data.parentId    | Long            | 父分类编号               |
| data.name        | String          | 分类名称                 |
| data.picUrl      | String          | 移动端分类图             |
| data.sort        | Integer         | 分类排序                 |
| data.status      | Integer         | 开启状态                 |
| data.description | String          | 分类描述                 |
| data.createTime  | LocalDateTime   | 创建时间                 |