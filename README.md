# Gulimall

#### 介绍

【尚硅谷】谷粒商城项目	分布式基础篇完成！

  初次使用，请阅读 README.md 文件。

---

#### 前置要求

> 学习项目的前置知识
>
* 熟悉 SpringBoot 以及常见整合方案
* 了解 SpringCloud
* 熟悉 git，maven
* 熟悉 linux，redis，docker 基本操作
* 了解 html，css，js，vue
* 熟练使用 idea 开发项目

---

#### 安装教程

1. 安装所需环境：

   - 后端：jdk(1.8)、maven(3.6.3)
   - 前端：node.js(14.16.0)、npm(6.14.11)、git(2.28.0)、vue(4.5.14)
   - 其他：阿里云ECS(centos7.x)、docker、mysql5.7、redis、阿里云对象存储（OSS）

   ---

   > 注：所列出版本均为参照，如发生版本冲突，请更换适应版本。

2. 克隆仓库到本地：

   > git clone git@github.com:XTY-yunsheng/guli_mall.git

3. 下载前端依赖：

   进入前端项目guli_mall_front/gulimall-admin-vue终端

   > npm install

---

#### 使用说明

1. 数据库数据准备

   * 连接数据库：
     * 使用图形化工具Navicat Premium连接阿里云服务器docker - mysql容器数据库。
   * 创建数据库：
     * 人人开源后端工程数据库：gulimall_admin
     * 微服务模块对应的数据库：gulimall_oms、gulimall_pms、gulimall_sms、gulimall_ums、gulimall_wms

   * 导入数据：
     * renren-fast模块下db文件夹mysql.sql、sys_menus
     * 项目db文件夹下所有文件，在对应数据库执行

2. 配置阿里云nacos配置中心配置项

   > 注：该项配置可作为学习阿里云nacos注册中心和配置中心使用，如不使用配置中心，可参照其他微服务模块修改对应yml文件

   * 本地启动nacos配置中心：

     * bin目录下双击startup.cmd脚本文件
     * 浏览器访问：http://localhost:8848/nacos/

   * 创建命名空间并新建配置文件：

     * 命名空间 gulimall-gateway

       gulimall-gateway.yml

       ```yaml
       spring:
           application:
               name: gulimall-gateway
       ```

     * 命名空间 gulimall-third-party（配置项改成自己对应信息）

       oss.yml 

       ```yaml
       spring:
           cloud:
               alicloud:
                   access-key: LTAI5tLJosw24GkxoKM6CyYw
                   secret-key: DeoFBDduEBYX0mOqqDyXJzDTjKQ5Oe
                   oss:
                       endpoint: oss-cn-hangzhou.aliyuncs.com
       ```

     * 命名空间 gulimall-coupon（配置项改成自己对应信息）

       datasource.yml 

       ```yaml
       spring:
         datasource:
           username: root
           password: 123456
           url: jdbc:mysql://120.79.133.75:3306/gulimall_sms
           driver-class-name: com.mysql.jdbc.Driver
       ```

        mybatis.yml 

       ```yaml
       mybatis-plus:
         mapper-locations: classpath:/mapper/**/*.xml
         global-config:
           db-config:
             id-type: auto
       ```

        other.yml 

       ```yaml
       spring:
         cloud:
           nacos:
             discovery:
               server-addr: 127.0.0.1:8848
         application:
           name: gulimall-coupon
       #  jackson:
       #    date-format: yyyy-MM-dd HH:mm:ss
       
       server:
         port: 7000
       #logging:
       #  level:
       #    com.atguigu.gulimall: debug
       ```

3. 修改项目配置文件

   * 修改各个微服务下配置文件数据源等配置信息

4. 启动项目

   * 后端：若电脑内存配置不是很高，可以先启动 gulimall_gateway、gulimall_product、renren-fast 三个服务

   * 前端：进入项目 /guli_mall_front/gulimall-admin-vue 目录终端，输入命令 npm run dev

     > 注：前端项目也可使用vscode工具打开，运行同上

   * 前后端联调测试基本功能

---

#### 分布式基础篇总结

1. 分布式基础概念
   * 微服务、注册中心、配置中心、远程调用、Feign、网关

2. 基础开发
   * SpringBoot2.0、SpringCloud、Mybatis-Plus、Vue组件化、阿里云对象存储
3. 环境
   * Linux、Docker、MySQL、Redis、逆向工程&人人开源
4. 开发规范
   * 数据校验JSR303、全局异常处理、全局统一返回、全局跨域处理
   * 枚举状态、业务状态码、VO与TO与PO划分、逻辑删除
   * Lombok：@Data、@Slf4j
