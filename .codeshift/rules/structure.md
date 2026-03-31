# 项目结构
严格按照项目结构创建项目目录，特别是功能根目录和子功能目录。

├── pom.xml                                           # Maven 项目核心配置文件：依赖管理、插件、项目信息
└── src
    └── main
        ├── java
        │   └── com
        │       └── github
        │           └── wenhao
        │               └── product                   # 后端服务名称
        │                   ├── XXApplication         # Spring服务启动类
        │                   ├── exception             
        │                   │   ├── BusinessException # 自定义业务异常，包含错误码与错误消息
        │                   │   └── GlobalExceptionHandler # 全局异常处理，至少包含Spring的Bean Validation的异常
        │                   ├── common
        │                   │   └── pojo              # 公共POJO类：通用VO/BO/DTO等，全模块共享
        │                   └── feature_name          # 某个功能根目录，例如category
        │                       ├── sub-feature1      # 子功能1
        │                       │   ├── controller    # 接口控制层（API入口）
        │                       │   │   └── vo        # 接口请求参数对象或接口响应参数对象
        │                       │   ├── mapper        # 数据访问层（MyBatis/MyBatis-Plus）
        │                       │   └── service       # 业务逻辑层
        │                       ├── sub-feature2      # 子功能2
        │                       │   ├── controller    # 接口控制层（API入口）
        │                       │   │   └── vo        # 接口请求参数对象或接口响应参数对象
        │                       │   ├── mapper        # 数据访问层（MyBatis/MyBatis-Plus）
        │                       │   └── service       # 业务逻辑层
        │                       └── entity
        │                           └── po            # 数据库实体类：与表结构一一对应
        │                       
        └── resources
            └── application.yml                       # SpringBoot 项目配置文件：端口、数据库、日志等
