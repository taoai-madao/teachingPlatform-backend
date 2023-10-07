# 教学业务智慧平台

## 前言

**平台功能介绍**

1. 可供老师方便使用的教学辅助平台（存放教案，教材）
2. 方便教学材料的管理，审核，复查

**功能**

1. 资料上传保存
2. 新建文件夹分类归档
3. 试卷下载上传
4. 需要审核的资料审查，评价

**业务流程**

![业务流程图](https://taoai-store.oss-cn-hangzhou.aliyuncs.com/img/202310062018895.png)

# 技术选型

**前端**

1. Vue3 
1. Vite3
1. Vuex

**后端**

1. Java Spring Boot
2. Mybatis
3. MySql
4. Spring Cloud Gateway
5. Nacos
6. Apache Dubbo
7. OSS


# 计划清单（✅代表已实现 ❌代表未实现）

#### 前端

##### 普通用户端

- **登录页** ✅
- **注册页**✅
- **构建普通用户主体架构**✅
- **普通用户主页**✅
- **文件展示列表**✅
- **新建分类目录**✅
- **文件上传**✅
- **文件重命名✅**
- **文件删除**✅
- **文件夹移动✅**
- **文件移动**✅
- **文件预览**✅
- **回收站编写**✅
- **管理员页面可以看到用户情况**（未分端，暂定）✅
- **头像上传✅**
- **编辑个人信息✅**
- **试卷模版 听课模版下载**❌
- **听课排班**❌
- **文件提交管理用户审核**❌
- **管理用户评语展示**❌
- **在线编辑（Wrod，Pdf或者Excel）**❌

##### 管理用户端

- **管理用户主体架构**（建议复用普通用户架构）❌
- **展示普通用户提交的文件❌**
- **对提交的文件进行分类**❌
- **通过提交的文件能看到文件提交者信息❌**
- **分类显示文件是否被审查❌**
- **审查通过 / 不通过 评语❌**

##### 管理员端  	

- **管理端页面架构**❌

- **展示所有用户**❌
- **修改用户的信息（信息，权限等）**❌
- **追踪文件提交的过程❌**
- **展示在线人数**❌
- **展示所有正在进行的提交**❌
- **展示已审查通过的提交❌**
- **展示未审查通过的提交**❌

#### 后端

##### SQL

- **SQL编写**✅
  - **用户信息表**✅
  - **邮箱验证码**✅
  - **文件信息表✅**
  - **管理用户信息表**❌
  - **管理用户文件信息表**❌
  - **管理员数据信息表**❌


##### 普通用户端

- **邮箱短信** ✅
- **普通用户登录**✅
- **密码MD5加密**✅
- **普通用户注册✅**
- **头像上传**✅
- **个人信息修改**✅
- **使用空间统计**✅
- **文件上传**✅
- **文件预览✅**
- **文件重命名✅**
- **文件移动**✅
- **创建分类目录✅**
- **删除文件✅**
- **文件还原✅**
- **彻底删除文件✅**
- **文件提交审查**❌
- **评语查看**❌

##### 管理用户端

- **提交文件获取**❌
- **提交文件按（专业，课程，人名分类）**❌
- **查看提交者信息**❌
- **编写审查评语**❌

##### 管理员端（暂放普通用户端）

- **用户列表预览**✅
- **用户管理**✅
- **用户信息修改**❌
- **文件提交查看**❌
- **在线人数展示**❌
- **展示所有提交中的文件**❌
- **展示审查通过的文件❌**
- **展示未审查通过的提交**❌

# 以下是功能实现流程（前端）😌

## 普通用户端（对应页面编写即可）

- 登录注册页面
- 普通用户主页
- 头像显示
- 个人信息编写页
- 文件列表页
- 新建目录
- 文件上传页
- 文件重命名
- 文件删除
- 文件移动
- 文件预览
  - 安装对应库
- 使用空间统计
- 回收站页面

## 管理用户端



## 管理员端



# 以下是功能实现流程（后端）😌
## 数据库设计（待扩充😌）

### 用户信息表（user_info）

- user_id 用户id
- nick_name 用户昵称
- email 邮箱
- avatar 头像
- password 用户密码 （md5加密）
- join_time 加入时间
- last_login_time 最后一次登录时间
- status 用户状态
- use_space 用户使用空间（byte）
- total_space 用户总空间
- role 用户权限等级 （0：普通用户，1：管理用户，2：管理员）

```sql
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(10) NOT NULL COMMENT '用户ID',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `email` varchar(150) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `join_time` datetime DEFAULT NULL COMMENT '加入时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '0:禁用 1:正常',
  `use_space` bigint(20) DEFAULT '0' COMMENT '使用空间单位byte',
  `total_space` bigint(20) DEFAULT NULL COMMENT '总空间',
  `role` tinyint(4) DEFAULT NULL COMMENT '用户权限等级 （0：普通用户，1：管理用户，2：管理员）',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `key_email` (`email`),
  UNIQUE KEY `key_nick_name` (`nick_name`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

INSERT INTO `user_info` VALUES ('00000001', '测试账号1', 'test1@163.com', null, '16d7a4fca7442dda3ad93c9a726597e4', '2023-10-06 23:24:57','2023-10-07 00:28:44', '1', '0', '6442450944', 0);
INSERT INTO `user_info` VALUES ('00000002', '测试账号2', 'test2@163.com', null, '16d7a4fca7442dda3ad93c9a726597e4', '2023-10-06 23:24:57','2023-10-07 00:28:44', '1', '0', '6442450944', 0);
```

### 邮箱验证码（email_code）

- email 邮箱
- code 编号
- create_time 创建时间
- status （0:未使用  1:已使用）

```sql
DROP TABLE IF EXISTS `email_code`;
CREATE TABLE `email_code` (
  `email` varchar(150) NOT NULL COMMENT '邮箱',
  `code` varchar(5) NOT NULL COMMENT '编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '0:未使用  1:已使用',
  PRIMARY KEY (`email`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='邮箱验证码';
```



### 文件信息表（file_info）

- file_id 文件id
- user_id 用户id
- file_md5 文件md5值，第一次上传记录
- file_pid 父级id
- file_size 文件大小
- file_name 文件名称
- file_cover 封面
- file_path 文件路径
- create_time 文件上传时间
- last_update_time 文件最后更新时间
- folder_type 文件类型（0：文件，1：目录）
- file_category 文件类型（1：视频，2：音频，3：图片，4：文档，5：其它）
- file_type 文件类型详细（ 1:视频 2:音频  3:图片 4:pdf 5:doc 6:excel 7:txt 8:code 9:zip 10:其他）
- status 状态（0：转码中，1：转码失败，2：转码成功）
- recovery_time 文件删除时间
- del_flag 删除标记（ 0：删除 ，1：回收站 吗，2：正常）

```sql
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `file_id` varchar(10) NOT NULL COMMENT '文件ID',
  `user_id` varchar(10) NOT NULL COMMENT '用户ID',
  `file_md5` varchar(32) DEFAULT NULL COMMENT 'md5值，第一次上传记录',
  `file_pid` varchar(10) DEFAULT NULL COMMENT '父级ID',
  `file_size` bigint DEFAULT NULL COMMENT '文件大小',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `file_cover` varchar(255) DEFAULT NULL COMMENT '封面',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `create_time` datetime DEFAULT NULL COMMENT '文件上传时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '文件最后更新时间',
  `folder_type` tinyint(1) DEFAULT NULL COMMENT '0:文件 1:目录',
  `file_category` tinyint(1) DEFAULT NULL COMMENT '1:视频 2:音频  3:图片 4:文档 5:其他',
  `file_type` tinyint(1) DEFAULT NULL COMMENT ' 1:视频 2:音频  3:图片 4:pdf 5:doc 6:excel 7:txt 8:code 9:zip 10:其他',
  `status` tinyint(1) DEFAULT NULL COMMENT '0:转码中 1转码失败 2:转码成功',
  `recovery_time` datetime DEFAULT NULL COMMENT '回收站时间',
  `del_flag` tinyint(1) DEFAULT '2' COMMENT '删除标记 0:删除  1:回收站  2:正常',
  PRIMARY KEY (`file_id`,`user_id`),
  KEY `idx_create_time` (`create_time`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_md5` (`file_md5`) USING BTREE,
  KEY `idx_file_pid` (`file_pid`),
  KEY `idx_del_flag` (`del_flag`),
  KEY `idx_recovery_time` (`recovery_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文件信息';
```


## 邮箱信息发送

流程：

- 导入JavaMail依赖
- 配置SMTP 文章地址 https://help.aliyun.com/document_detail/607851.html
- 使用Redis设置邮件内容
- 创建消息对象
- 发送邮件

## 登录功能

登录流程：

- 获取用户输入的邮箱账号，密码（前端校验规则）
- 数据库校验信息，验证码
- 成功则登录，页面跳转，失败拦截

## 注册功能

注册流程：

- 用户输入邮箱
- 验证邮箱正确性
- 发送邮箱验证码
- 用户输入密码昵称
- 将数据写入数据库

## 头像上传

- 获取当前用户信息
- 检查用户对应文件夹
- 文件夹不存在则创建
- 文件夹存在则将上传的图片命名放入
- 更新用户信息

## 个人信息修改

- 获取接收到的数据
- 校验用户id是否存在
- 校验数据是否合法
- 调用sql完成数据更新

## 文件上传

- 获取文件id判断是否存在
- 如果文件存在，则获取文件的记录
  - 判断文件状态是否可用
  - 判断文件大小是否超出用户总空间超过则抛出异常
  - 不超出则对文件记录进行复制，为其设置新的属性
  - 将该条记录插入数据库中
  - 更新用户空间情况
  - 结束返回
- 如果文件不存在，则开始对文件进行分片判断用户空间是否足够存储该文件，如果不足则抛出异常
- 创建临时目录存放上传的文件分片
- 判断磁盘空间是否足够存储该文件，如果不足则抛出异常
- 将当前分片保存到临时目录，并记录临时文件大小
- 如果不是最后一个分片，则返回正在上传状态
- 如果是最后一个分片，将文件信息保存到数据库，并更新用户空间使用情况
- 返回上传完成状态，并在事务提交后调用异步方法处理文件合并操作
- 如果出现异常，标记上传失败，并删除临时目录

## 使用空间统计

- 调用sql从数据库中直接读取用户已使用的空间

## 文件预览

- 判断传入文件的文件夹是否为空，为空直接返回
- 不为空则获取图片文件后缀
- 根据传入的文件夹和图片名来获取图片文件的完整路径
- 设置浏览器响应头
- 控制浏览器缓存图片时间
- 读取图片文件数据返回

## 文件重命名

- 通过文件id与用户id从数据库中查询出对应的文件信息
- 如果文件不存在，则抛出异常
- 判断新输入的文件名与原先文件名是否相同
- 相同则返回原文件信息
- 检查要修改的目标文件的文件夹下是否有同名文件，如果存在则抛出异常
- 判断文件是否为普通文件
- 则添加原文件名后缀
- 更新文件名与最后更新时间
- 返回该对象进入数据库更新

## 文件移动

- 判断源文件和目标文件夹是否存在
- 判断目标文件夹是否已经存在重名文件
- 存在则进行冲突处理，覆盖或者重命名
- 不存在则进行递归复制
- 复制过程中如果出现异常则进行数据回滚并抛出异常
- 移动完成后更新文件信息

## 目录创建

- 判断文件名是否合法
- 判断文件夹是否已经存在，或者存在同名文件夹
- 若存在抛出提示
- 获取当前时间
- 设置新建文件夹信息
- 将信息更新到数据库
- 更新文件夹对象并返回

## 逻辑删除文件

- 接收用户id和文件id
- 查询符合条件的文件信息列表
- 如果列表为空则表示没有要删除的文件直接返回
- 如果不为空，则遍历文件信息列表设置其删除状态
- 获取当前时间，将其状态转入回收站
- 返回更新数据

## 文件还原

- 获取传入的id
- 根据id查询对应文件
- 更改对应文件状态
- 遍历原始文件信息列表，查询是否存在同名文件
- 若存在则进行重命名
- 不存在则进行更新

## 彻底删除文件

	- 调用sql语句删除数据库记录



# 开始使用

后端地址：https://github.com/taoai-madao/teachingPlatform-backend

前端地址：https://github.com/taoai-madao/teachingPlatform-user-frontend

前端运行方法：

	- 建议Node版本18.16.0
	- 建议yarn版本 1.22.19
	- 根目录下执行 yarn 命令
	- 执行 vite --mode dev

后端运行方法：

- 建议JDK版本 1.8
- mysql 8
- 本地配置 ffmpeg 环境变量

 - 在properties中
   		- 修改数据库配置
      		- 修改Reids配置
         		- 配置邮件服务器
         		- 执行上文SQL语句至少保证存在（user_info，email_code，file_info）

**后续更新请自建仓库**

测试账号：test1@163.com

测试密码：test1234

测试账号：test2@163.com

测试密码：test1234

# 后续更新计划😌

- 跨域解决
- 整体逻辑优化
- 页面整体优化
- 引用阿里云或腾讯云OSS将文件存储云端
- 使用Redis优化服务
- 扩充建立管理用户端
- 扩充建立管理员端
- 后端引入gateway完善安全
- 请求通过网关完成鉴权
- 抽取公共代码以便复用
- 使用RPC框架Dubbo完成服务调用
- 使用Nacos管理资源
- 设置定时任务，定时清理逻辑删除的文件和文件夹
