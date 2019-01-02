## RongSystem介绍

融媒体平台基于RouYi3.0开源框架搭建。
需要将应急广播、山洪预警、村务平台进行融合。

# 成员
开发小组人员：张超，张鸿权，戴誉琪，刘衍斌。

环境依赖
----
* JDK >= 1.8
* MySQL >= 5.7
* Maven >= 3.0


# 开发注意
1. Clone到本地仓库
2. 导入Idea编译环境，等待MAVEN加载完毕
3. Alibaba Druid数据库连接池配置文件在：
    rouyi-admin/resources/application-druid.yml
    数据库用的是我远程数据库服务器，无需修改    
4. 若涉及到数据库的操作，找我新建远程服务器账户
5. 所有的Clone都要在git操作下add-commit-push，切记不要修改Master分支，建立自己的分支

# 目录结构
'''
com.ruoyi     
├── common            // 工具类
│       └── annotation                    // 自定义注解
│       └── config                        // 全局配置
│       └── constant                      // 通用常量
│       └── enums                         // 通用枚举
│       └── exception                     // 通用异常
│       └── json                          // JSON数据处理
│       └── support                       // 字符集处理
│       └── utils                         // 通用类处理
│       └── xss                           // XSS过滤处理
├── framework         // 框架核心
│       └── aspectj                       // 注解实现
│       └── config                        // 系统配置
│       └── datasource                    // 数据权限
│       └── manager                       // 异步处理
│       └── shiro                         // 权限控制
│       └── util                          // 通用工具
│       └── web                           // 前端控制
├── ruoyi-generator   // 代码生成
├── ruoyi-quartz      // 定时任务
├── ruoyi-system      // 系统代码
├── ruoyi-admin       // 后台服务
├── ruoyi-xxxxxx      // 其他模块
'''

# 系统部署
该系统采用Jar包的形式直接运行在我的Linux服务器
自己测试的时候使用mvn命令打包成jar包

# Links
* 我的服务器域名：www.teavamc.com
* 账号密码：admin/admin123
* RuoYi框架文档地址：http://doc.ruoyi.vip
