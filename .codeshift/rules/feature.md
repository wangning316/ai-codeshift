# 功能代码生成规范

## 功能结构
.codeshift/
├── feature                  # 功能目录
    └── XXfeature            # 具体某个子功能目录
        ├── entity           # 功能涉及的数据库对象目录
        │   └── po.md            # 数据库对象
        └── sub-feature          # 子功能目录    
            └── create
                │── api.md       # 子功能api的RESTful接口定义
                │── mapper.md    # 子功能mapper数据库操作对象定义
                └── service.md   # 子功能service业务逻辑定义

## 命令
**重要：**仅接收以下两种命令开头的用户指令。
* 生成功能：生成功能下的某个子功能代码时需要同时读取`rules`、`entity`，子功能目录下所有的规范，以保证生成的代码与功能各规范保持一致。
* 重新生成功能：重新生成功能下的某个子功能代码时务必先删除该功能已存在的所有代码然后再生成。

## 注意
* 验证：每次生成代码完成之后都运行命令`mvn compile`确保代码可成功编译。
* 规避操作：绝不生成测试用例和测试类代码。

## 接口生成-api
* 接口使用Spring的@RestController实现接口，保证代码与`api`定义的请求参数、响应参数完全一致性。
* 接口使用Spring的Bean Validation功能对参数`是否必填`为`是`的参数对象(@Valid)和参数(例如@NotNull)进行对应的校验。
* 使用swagger描述接口，以便生成完善的API接口文档。

## 业务逻辑生成-service
* 接收接口的参数并按照业务逻辑实现代码。

## 数据库操作对象生成-mapper
* 使用MyBatis-Plus实现数据的增删改查操作。
* 根据业务逻辑中提到的数据库操作实现对应的MyBatis-Plus方法。

## 数据库持久化对象-entity
* 使用MyBatis-Plus实现的数据库持久化对象。
* 根据持久化对象的定义实现对应的MyBatis-Plus对象。
