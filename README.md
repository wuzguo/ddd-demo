## 工程简介

本项目改造至阿里巴巴COLA框架的Demo,添加了一些自己对DDD的认识，并增加了常用的框架和工具类，仅供参考，代码随意。

## 工程结构说明

| 模块名                  | 用途                                 | 备注                    |
| ----------------------- | ------------------------------------ | ----------------------- |
| ddd-demo-app            | 应用层，应用服务，非核心业务逻辑     |                         |
| ddd-demo-client         | 客户端，放置客户端接口和对应的DTO    | Fegin客户端。           |
| ddd-demo-controller     | 控制层，⽤于接受⽤户请求数据和响应   | 对外提供ResultFul接口。 |
| ddd-demo-domain         | 领域层，放置领域对象和核心业务逻辑   |                         |
| ddd-demo-infrastructure | 基础设施层，数据通道，DAO或RPC的代码 |                         |
| ddd-demo-starter        | SpringBoot启动类                     |                         |

## 包结构说明

| 包名               | 规范                      | 用途                                        |
| ------------------ | ------------------------- | ------------------------------------------- |
| clientobject       | XXXCO                     | 客户视图对象，⽤于传递数据，等同于DTO       |
| domainevent        | XXXEvent                  | 领域事件消息对象                            |
| command            | XXXCommand,XXXQuery       | CQRS指令对象，区分Command与Query            |
| tuunel.dataobject  | XXXDO                     | 数据对象，⽤于持久化                        |
| controller         | XXXController             | ⽤于接受⽤户请求数据与相应                  |
| service            | XXXService,XXXServiceImpl | API接⼝类                                   |
| interceptor        | XXXInterceptor            | 拦截器，⽤于处理切⾯逻辑                    |
| event.handler      | XXXHandler                | 事件订阅者，⽤于处理事件消息                |
| executor           | XXXCmd,XXXQry             | CQRS命令执⾏Executor                        |
| validator          | XXXValidator              | 校验器，⽤于校验类                          |
| convertor          | XXXConvertor              | 转化器，实现不同层级对象的转换              |
| repostiry          | XXXRepostiry              | 领域资源操作仓库对象，属于应⽤层            |
| assembler          | XXXAssember               | 组装器，组装外包服务调⽤参数                |
| domain.entity      | XXX                       | 领域Entity对象                              |
| domain.valueobject | XXXVO                     | 领域VO对象                                  |
| domain.service     | XXXDomainServic           | 领域服务对象                                |
| domain.factory     | XXXFactory                | 领域对象⼯⼚                                |
| config             | XXXConfig                 | 配置类                                      |
| tunnel             | XXXTunnel                 | 数据通道，DAO是常⻅的通道，也可以是其他通道 |
|                    |                           |                                             |
|                    |                           |                                             |

## 使用说明

从Gitlab.com拉取代码，直接运行 ddd-demo-starter 模块中的 DddDemoApplication 的启动类。

## 持续更新...

根据学习进度，持续更新....

### 纠错

欢迎大家指出不足，如有任何疑问，请邮件联系 [wuzguo@gmail.com](mailto:wuzguo@gmail.com) 或者直接修复并提交 Pull Request。

### 参考项目

COLA: https://github.com/alibaba/COLA

