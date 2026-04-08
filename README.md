# ai-codeshift

Harness Engineering

```
specs
├── AGENTS.md                         # 项目简介、项目目录结构、技术栈、功能代码生成规范
├── features                          # 业务领域集
│   └── feature                       # 业务领域
│       ├── entity
│       │   └── entity.md             # 数据库表契约
│       └── functions                 # 业务功能集
│           └── function              # 业务功能，原子化
│               ├── api.md            # 业务功能API契约
│               ├── service.md        # 业务逻辑
│               ├── mapper.md         # 数据库操作
│               └── feginclient.md    # 第三方API契约
└── scaffold                          # 项目脚手架
    └── scaffold.md
```

## RooCode设置

导入`.roo\codeshift.yaml`文件。输入生成功能代码的指令，如`生成功能：业务band的功能create`。
