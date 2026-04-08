# 项目简介
商品SPU管理

# 项目结构
严格按照项目结构创建项目目录，特别是功能根目录和子功能目录。
```
├── pom.xml                                   # Maven 项目核心配置文件：依赖管理、插件、项目信息
└── src
    └── main
        ├── java
        │   └── com
        │       └── github
        │           └── wenhao
        │               └── product                   # 后端服务名称
        │                   ├── XXApplication         # Spring服务启动类
        │                   ├── exception             
        │                   │   ├── BusinessException # 自定义业务异常，包含错误码字符串与错误消息
        │                   │   └── GlobalExceptionHandler # 全局异常处理，至少包含Spring的Bean Validation的异常
        │                   ├── common
        │                   │   └── pojo              # 公共POJO类：通用VO/BO/DTO等，全模块共享
        │                   │       └── CommonResult  # 通用api返回对象，包含code、msg、data(T泛型)
        │                   └── feature_name          # 某个功能根目录，例如category
        │                       ├── fucntion-1        # 子功能1
        │                       │   ├── controller    # 接口控制层（API入口）
        │                       │   │   └── vo        # 接口请求参数对象或接口响应参数对象
        │                       │   ├── mapper        # 数据访问层（MyBatis/MyBatis-Plus）
        │                       │   └── service       # 业务逻辑层
        │                       ├── function-2        # 子功能2
        │                       │   ├── controller    # 接口控制层（API入口）
        │                       │   │   └── vo        # 接口请求参数对象或接口响应参数对象
        │                       │   ├── mapper        # 数据访问层（MyBatis/MyBatis-Plus）
        │                       │   └── service       # 业务逻辑层
        │                       └── entity
        │                           └── po            # 数据库实体类：与表结构一一对应
        │                       
        └── resources
            └── application.yml                           # SpringBoot 项目配置文件：端口、数据库、日志等
```

# 技术栈
- 语言：Java 17
- 框架：Spring、Spring Bean Validation、Mybatis-plus、lombok、Mapstruct、guava
- 数据库： MySQL

# 功能代码生成规范
## 功能结构
```
specs
├── features                          # 业务领域集
│   └── feature                       # 具体某个业务领域
│       ├── entity
│       │   └── entity.md             # 数据库表契约
│       └── functions                 # 业务功能集
│           └── function              # 具体某个业务功能
│               ├── api.md            # 功能API契约
│               ├── service.md        # 功能业务逻辑
│               ├── mapper.md         # 功能数据库操作
│               └── feginclient.md    # 功能第三方API契约
└── scaffold                          # 项目脚手架
    └── scaffold.md
```

## 命令
- 生成功能：生成业务领域下的某个业务功能代码时需要同时读取`entity`和`function`目录中的所有规范文件，以保证生成的代码与功能各规范保持一致。
- 重新生成功能：重新生成业务领域下的某个业务功能代码时务必先删除该功能已存在的所有代码然后再生成。
- 生成项目脚手架：生成项目脚手架定义的所有内容。
- 重新生成项目脚手架：务必先删除项目脚手架已存在的所有代码然后再生成。

## 注意
- 编译代码：每次生成代码完成之后都运行命令`mvn compile`确保代码可成功编译。
- 规避操作：绝不生成测试用例和测试类代码。

## 接口生成-api
- 接口使用Spring的@RestController实现接口，保证代码与`api`定义的请求参数、响应参数完全一致性。
- 接口使用Spring的Bean Validation功能对参数`是否必填`为`是`的参数对象(@Valid)和参数(例如@NotNull)进行对应的校验。
- 使用swagger描述接口，以便生成完善的API接口文档。

## 业务逻辑生成-service
- 接收接口的参数并按照业务逻辑实现代码。

## 数据库操作对象生成-mapper
- 使用MyBatis-Plus实现数据的增删改查操作。
- 根据业务逻辑中提到的数据库操作实现对应的MyBatis-Plus方法。

## 数据库持久化对象-entity
- 使用MyBatis-Plus实现的数据库持久化对象。
- 根据持久化对象的定义实现对应的MyBatis-Plus对象。
