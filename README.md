# 电商项目 - 商品分类模块

## 项目概述
本项目实现了电商系统中的商品分类功能，包括创建商品分类等核心功能。

## 技术栈
- Java 17
- Spring Boot 2.7.0
- MyBatis-Plus 3.5.2
- MySQL 8.0
- Lombok
- Swagger

## 功能特性
- 创建商品分类
- 支持多级分类（目前限制最多两级）
- 参数校验
- 统一异常处理

## API 接口
### 创建商品分类
- **请求地址**: POST /product/category/create
- **请求参数**:
  - parentId: 父分类编号（根分类为0）
  - name: 分类名称
  - picUrl: 移动端分类图
  - sort: 分类排序
  - status: 开启状态
  - description: 分类描述（可选）

## 项目结构
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── company/
│   │           └── project/
│   │               ├── Application.java              # 项目启动类
│   │               ├── controller/                   # 控制器层
│   │               ├── service/                      # 业务逻辑层
│   │               ├── mapper/                       # 数据访问层
│   │               ├── entity/                       # 实体类
│   │               ├── common/                       # 公共代码
│   │               └── exception/                    # 异常处理
│   └── resources/
│       └── application.yml                           # 配置文件
```

## 快速开始
1. 安装JDK 17
2. 安装Maven
3. 安装MySQL并创建数据库
4. 修改`application.yml`中的数据库连接信息
5. 运行命令: `mvn spring-boot:run`