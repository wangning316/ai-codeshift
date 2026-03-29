# 电商项目 - 商品分类模块

## 项目简介
这是一个基于Spring Boot + MyBatis-Plus的电商项目中的商品分类模块，实现了商品分类的增删改查功能。

## 技术栈
- Java 17
- Spring Boot 2.7.0
- MyBatis-Plus 3.5.2
- MySQL 8.0
- Lombok
- Swagger/OpenAPI

## 功能特性
- 商品分类的创建、删除、更新和查询
- 支持多级分类结构
- 统一的异常处理
- 参数校验
- API文档自动生成

## 项目结构
```
src/
├── main/
│   ├── java/
│   │   └── com/company/project/
│   │       ├── Application.java              # 项目启动类
│   │       ├── controller/                   # 控制器层
│   │       │   └── vo/                      # 请求/响应对象
│   │       ├── service/                      # 业务逻辑层
│   │       │   └── impl/                    # 业务逻辑实现
│   │       ├── mapper/                       # 数据访问层
│   │       ├── entity/                       # 实体类
│   │       │   └── po/                      # 持久化对象
│   │       ├── exception/                    # 异常处理
│   │       └── common/                       # 公共组件
│   │           ├── enums/                    # 枚举类
│   │           └── pojo/                     # 公共POJO类
│   └── resources/
│       └── application.yml                   # 配置文件
```

## 快速开始
1. 安装JDK 17、Maven 3.6+
2. 配置MySQL数据库
3. 修改`application.yml`中的数据库连接信息
4. 运行`mvn spring-boot:run`启动项目
5. 访问`http://localhost:8080/swagger-ui.html`查看API文档

## API接口
- 创建商品分类: `POST /product/category/create`
- 查询商品分类: `GET /product/category/{id}`
- 更新商品分类: `PUT /product/category/update`
- 删除商品分类: `DELETE /product/category/delete/{id}`
- 查询商品分类列表: `GET /product/category/list`

## 数据库表结构
```sql
CREATE TABLE product_category (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '分类编号',
    parent_id BIGINT NOT NULL DEFAULT 0 COMMENT '父分类编号（根分类为0）',
    name VARCHAR(255) NOT NULL COMMENT '分类名称',
    pic_url VARCHAR(500) COMMENT '移动端分类图（建议180*180分辨率）',
    sort INT DEFAULT 0 COMMENT '分类排序',
    status INT DEFAULT 1 COMMENT '开启状态（0-禁用，1-启用）',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '最后更新时间',
    creator VARCHAR(64) COMMENT '创建者',
    updater VARCHAR(64) COMMENT '更新者',
    deleted TINYINT DEFAULT 0 COMMENT '是否删除（逻辑删除字段）'
) COMMENT='商品分类表';