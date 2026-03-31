# 项目脚手架
按照下列规范生成项目脚手架。
├── pom.xml                                               # Maven 项目核心配置文件：依赖管理、插件、项目信息
└── src
    └── main
        ├── java
        │   └── com
        │       └── github
        │           └── wenhao
        │               └── product                        # 后端服务名称
        │                   ├── XXApplication              # Spring服务启动类
        │                   └── exception             
        │                       ├── BusinessException      # 自定义业务异常，包含错误码与错误消息
        │                       └── GlobalExceptionHandler # 全局异常处理，至少包含Spring的Bean Validation的异常
        └── resources
            └── application.yml                            # SpringBoot 项目配置文件：端口、数据库、日志等

# pom.xml

* groupId:com.github.wenhao
* artifactId:product
* version:1.0.0

* name:Product
* description:商品管理

## parent
org.springframework.boot:spring-boot-starter-parent:2.7.18

## properties
java.version:17
project.build.sourceEncoding:UTF-8

##  dependencies
* org.springframework.boot:spring-boot-starter-web
* org.springframework.boot:spring-boot-starter-validation
* org.mybatis:mybatis:3.5.19
* com.baomidou:mybatis-plus-boot-starter:3.5.15
* mysql:mysql-connector-java:8.0.30
* org.projectlombok:lombok:1.18.24
* org.springdoc:springdoc-openapi-ui:1.7.0

* org.springframework.boot:spring-boot-maven-plugin


# Spring服务启动类
* 生成SpringBootApplication的启动类ProductApplication。

# application.yml

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/product_db?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false
    username: root
    password: 
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis-plus:
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      logic-delete-field: deleted
      logic-delete-value: 1
      logic-not-delete-value: 0
```
