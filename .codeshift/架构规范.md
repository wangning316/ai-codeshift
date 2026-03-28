# 架构实现规范

## Java SDK
* 使用Java 17

## 接口实现-api
* 接口使用Spring的@RestController实现接口。
* 使用swagger描述接口，以便生成完善的API接口文档。

## 业务逻辑实现-service
* 接收接口的参数并按照业务逻辑描述进行参数校验、数据转换、数据库操作、返回数据等。

## 数据库操作-mapper
* 使用MyBatis-Plus实现数据的增删改查操作。
* 根据业务逻辑中提到的数据库操作实现对应的MyBatis-Plus方法。

## 数据库持久化对象-entity
* 使用MyBatis-Plus实现的数据库持久化对象。
* 根据持久化对象的定义实现对应的MyBatis-Plus对象。