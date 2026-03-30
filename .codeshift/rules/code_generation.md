# 功能规范

## 功能结构
.codeshift/
├── feature                  # 某个功能目录
│   └── feature              # 具体某个子功能目录
│       ├── entity           # 功能涉及的数据库对象目录
│       │   └── po.md        # 数据库对象
│       └── sub-feature      # 具体某个子功能目录
│           │── api.md       # 子功能api的RESTful接口定义
│           │── mapper.md    # 子功能mapper数据库操作对象定义
│           └── service.md   # 子功能service业务逻辑定义

## 功能生成规则

* 生成某个子功能的代码时需要同时获取`entity`，子功能目录下所有的规范，以保证生成的代码与功能各规范保持一致。
* 重新生成某个子功能时需先删除该功能相关之前的代码再同时获取`entity`，子功能目录下所有的规范，最后在重新生成，以便子功能下规范变更时保证重新生成的代码与功能各规范保持一致。
* **重要：**各子功能都有自己独立的controller、service、mapper类文件，不要将不同子功能的controller、service、mapper方法合并到同一个类文件内。
* 绝不生成单元测试代码。

## 接口生成-api
* 接口使用Spring的@RestController实现接口，保证代码与`api`定义一致性。
* 接口使用Spring的Bean Validation功能对参数`是否必填`为`是`的参数对象(@Valid)和参数(例如@NotNull)进行对应的校验，严格按照定义的校验规则进行校验。
* 使用swagger描述接口，以便生成完善的API接口文档。

## 业务逻辑生成-service
* 接收接口的参数并按照业务逻辑实现代码。

## 数据库操作对象生成-mapper
* 使用MyBatis-Plus实现数据的增删改查操作。
* 根据业务逻辑中提到的数据库操作实现对应的MyBatis-Plus方法。

## 数据库持久化对象-entity
* 使用MyBatis-Plus实现的数据库持久化对象。
* 根据持久化对象的定义实现对应的MyBatis-Plus对象。
