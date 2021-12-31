# Simplest-Blog-Backend
😸 SpringBoot2.5.7 + knife4j(增强swagger) + SpringSecurity + MyBatis-Plus | Simplest 后端代码，业务简单，值得学习！
![logo](github_image/logo.png)
## 项目背景&设计理由

​    **第一版背景**：项目的第一版名字叫做ZhiyuBlog，为什么会叫Zhiyu，这和大学期间大家都这样叫我名字所以叫着叫着就习惯了，所以我把名字用拼音改写成了网名，最后在自己的实践项目上使用了其名字，所以叫做ZhiyuBlog。可惜的是，这个项目从开源到现在没有一个star，主要是技术迭代太快，当我写这个项目用的模版渲染引擎thymeleaf，而写完后的那年前后端分离正大火大热。

*第一版历史分支地址*：[zhiyu1998/Simplest-Blog-Backend at ZhiyuBlog (github.com)](https://github.com/zhiyu1998/Simplest-Blog-Backend/tree/ZhiyuBlog)

​    **第二版背景**： 当时第一版写的时候正是临近大三，年少无知，取名字太过于主观，可能也是没有人star的原因之一吧。所以更名为：Simplest （大道至简），为什么要取这个名字？主要原因还是个人比较喜欢安静且简单，所以取下了这个名字。这个项目是在笔者科研的业余时间写出来的，借鉴了Material Design 风格的 Hexo 主题。

> 注：此项目从第一版2019年开始着手，期间从前后端开发再到部署都是一个人，个人比较菜，但项目很适合学习，在2019-2021.11中间的空隙一直没动过此项目；第二个版本是我在读研期间（2021年11月中旬）开始重构项目，也没想着部署到云（因为没人看，哈哈哈），再加上今年前端vue大更新（vue3，pinia加入vue大家庭，vueRoute4，Vite2）很多技术都需要学习，期间做此项目学习了很多，做了很多次失败的测试和实验，但没关系，我开源此项目的初衷就是力所能及的帮到你的需求！

前端地址：[Simplest](https://github.com/zhiyu1998/Simplest)

​	**LOGO设计理由（从上至下，从左至右）**：首先头上的毛为S代表本次项目的名称（Simplest）的首字母；整个吉祥物是以猫为主，主要是2021年很多人都比较喜欢猫，所以以猫为吉祥物，为什么以白猫作为吉祥物而不是黑猫、大橘、银渐层..是因为笔者比较喜欢这个配色的猫；再说卫衣的设计是因为这个项目的重构是在冬天，我经常冬天穿着卫衣在实验室写代码，所以给吉祥物也套上了我经常穿的灰色卫衣，再加上本次项目大致架构是用Vue和Spring Boot构成，所以卫衣的左侧标上了两个框架的图标；再者右手的点赞手势是因为笔者拍照的时候喜欢用这个姿势，所以这就是整个logo的设计流程。

## 后端文件架构
```
├── blog-api/src
       ├── common           json类定义
       ├── config           配置类
       └── controller       
            └── form        前端的表类型定义
       ├── db               数据库类型
            ├── mapper
            └── pojo
       ├── exception        错误定义
       ├── service
            └── Impl
       ├── utils            工具类
       └── resources        
            ├── mapper      mybatis额外需要的SQL
            ├── static      空
            └── templates   空
```
## 前端界面预览
### 主页

![home](github_image/home.png)

### 归档

![archive](github_image/archive.png)

### 标签

![tag](github_image/tag.png)

### 留言板

![message](github_image/message.png)

### 关于

![about](github_image/about.png)

### 友情链接

![friends](github_image/friends.png)

### 博客详情

![details](github_image/details.png)

![details2](github_image/details2.png)

## 架构选型

| 框架                                  | 版本   |
| ------------------------------------- | ------ |
| Spring Boot                           | 2.5.7  |
| Spring Security（暂时用Sa-token顶替） | 2.5.7  |
| knife4j                               | 2.0.9  |
| hutool                                | 5.7.16 |
| mybatis-plus                          | 3.4.3  |
| sa-token(暂时)                        | 1.28.0 |

## 部署
下载一下依赖  
> pom.xml

运行  
> BlogApiApplication

## 致谢

​	笔者一直在纠结要不要写这个致谢，看了很多开源的博客的致谢，很多感谢老婆、感谢女朋友的、感谢朋友的，笔者整个项目从头到尾都是一个人在搞也不是因为笔者生活比较自闭，但愿下一个版本（vue的下一个大版本）我能感谢我的女朋友[狗头]。那项目的结尾，我就感谢一下我自己在人生的20多年能学到这么多知识并将其运用和未来有幸能贡献此仓库的你…