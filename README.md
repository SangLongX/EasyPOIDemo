[TOC]

## EasyPOI 

EasyPOI demo
基于SpringBoot，集成EasyPOI、Mybatis、MySQL等，实现从数据库导出excel功能

### 说明

- 通用导出规则：<br/>

  - **使用者要熟知SQL**<br/>
    对于in参数的输入框，格式必须以`'item1','item2'...'`的格式；<br/>
  - **多参数须注意**<br>
    1. 多个参数前必须有and连接[^如果多条件的部分条件没有填写，会删除后面的一些条件，详情见2]
    2. 如果填充数据小于表单数，默认前排补充、后排删除[^即 - 如果有三个须填充内容，填充完第一、第三个后提交，会把第三个认作第二个，而第三个为null，致使第三个条件被删除，导致查询结果出错]
  - 2018/11/20版：通用导出增加SQL：<br/>
    在MagicElements中添加enum，以**SQL_QUERY开头**，格式如
    ​    ```java
    // abbr 英文简写，可区分要查询的功能，**abbr要唯一**
    // cnDes 这是页面select要显示的中文说明
    // full SQL语句，规则见 **通用导出规则**
    SQL_QUERY_EXAMPLE("abbr", "cnDes", "full")
    ​    ```

- 导入规则：

  - 2019/05/22版：按列来实现，excel指定列必须指定成员变量；<br/>数据默认从第二行开始（第一行默认为开头）；<br/>excel如果有多个sheet，多个sheet的实例为同一个（暂不支持多sheet多格式）<br/>

    增加规则：<br/>

    1 - 增加实体 <br/>

    2 - 增加继承IExcelEnum的Enum 

### 表创建
- 导入表
    ```sql
    CREATE TABLE `wheel` (
      `brand` varchar(50) DEFAULT NULL,
      `material` varchar(50) DEFAULT NULL,
      `price` double DEFAULT NULL,
      `out_com_date` date DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    ```

### 修订历史

- 2018/11/16

  - 添加通用导出
  - 特定导出合并
  - 界面优化

- 2018/11/20

  - 通用导出bugFix
  - 界面优化 

- 2019/05/22

  - 增加导入功能
  - 增加主页

  