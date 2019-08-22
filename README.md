<p align="center"><img src="https://github.com/cj96248/pikashop-parent/blob/master/share/readme/pika.png?raw=true"></p>

# PiKa 商城

![Java](https://img.shields.io/badge/language-Java8-green)
![AngularJS](https://img.shields.io/badge/language-AngularJS-green)
![Starts](https://img.shields.io/github/stars/cj96248/pikashop-parent)
![License](https://img.shields.io/github/license/cj96248/pikashop-parent)


项目基于Dubbo开发的B2B2C网上商城，模拟京东商城的业务原型，分模块开发，主要分为网站前台、运营商后台、商家管理后台三个子系统。

## 技术栈

- DubboX
    - Zookeeper
- AngularJS
    - AdminLTE
    - pagination
    - select2
    - kindeditor
- Database
    - MySQL
    - MyBatis

## 项目结构

```
pikashop-parent 项目主结构
|---- pikashop-auto-generator  Mybatis自动生成代码
|---- pikashop-auto-insert     数据插入Solr  
|---- pikashop-basic-common    通用逻辑
|---- pikashop-basic-dao       数据访问层，Mapper
|---- pikashop-basic-entity    模型
|---- pikashop-basic-interface 接口
|---- pikashop-basic-service   接口实现
|---- pikashop-management      运营商管理后台
|---- pikashop-seller          商家管理后台
|---- pikashop-website-portal  网站前台
|---- share                    其他文件
|      |----  sql         SQL文件
```

## 快速开始

1. 数据库
    - 数据插入，数据库文件位于share/sql
    - 数据库连接，在`basic-dao`项目下的resources目录中，有配置文件`database.properties`，其中定义了数据库的基本参数
    ```jdbc.username=root
    jdbc.password=root
    jdbc.driver=com.mysql.jdbc.Driver
    jdbc.url=jdbc:mysql://192.168.99.100:3306/pikashop```

2. Zookeeper
    -  修改如下配置`<dubbo:registry address="zookeeper://192.168.99.100:2181"/>`
        -    修改`pikashop-basic-service`配置文件`application-service.xml`
        -    修改`pikashop-management`配置文件`application-manage.xml`
        -    修改`pikashop-seller`配置文件`application-web.xml`
        -    修改`pikashop-website-portal`配置文件`application-web.xml`

3. 先启动`pikashop-basic-service`，必须首先启动，其他项目依赖其服务。
4. 启动`pikashop-management`就可以访问`http://localhost:8100`
5. 启动`pikashop-seller`就可以访问`http://localhost:8200`
6. 启动`pikashop-website-portal`就可以访问`http://localhost:8300`
