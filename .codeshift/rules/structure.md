├── pom.xml                                    # Maven 项目核心配置文件：依赖管理、插件、项目信息
└── src
    └── main
        ├── java
        │   └── com
        │       └── github
        │           └── wenhao
        │               └── product                 # 后端服务名称
        │                   └── feature             # 某个功能根目录
        │                       ├── common
        │                       │   └── pojo        # 公共POJO类：通用VO/BO/DTO等，全模块共享
        │                       ├── sub-feature1    # 子功能1
        │                       │   ├── controller  # 接口控制层（API入口）
        │                       │   │   └── vo      # 接口请求参数对象或接口响应参数对象
        │                       │   ├── mapper      # 数据访问层（MyBatis/MyBatis-Plus）
        │                       │   └── service     # 业务逻辑层
        │                       ├── sub-feature2    # 子功能2
        │                       │   ├── controller  # 接口控制层（API入口）
        │                       │   │   └── vo      # 接口请求参数对象或接口响应参数对象
        │                       │   ├── mapper      # 数据访问层（MyBatis/MyBatis-Plus）
        │                       │   └── service     # 业务逻辑层
        │                       ├── entity
        │                       │   └── po          # 数据库实体类：与表结构一一对应
        │                       └── exception       # 模块自定义异常、全局异常处理
        └── resources
            └── application.yml                     # SpringBoot 项目配置文件：端口、数据库、日志等
