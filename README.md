# 大数据岗位各公司面试题汇总

# 滴滴
### 1、left semi join 为什么会比join快，且在mr处理的过程中，是通过什么原理/过程让其匹配到对应数据后不再继续匹配？

​		left semi join是以左表为准，在右表中查找匹配的记录，如果查找成功，则仅返回左边的记录，否则返回`null`，其基本实现流程如下图所示。

![spark-sql-semi-join](http://sharkdtu.com/images/spark-sql-semi-join.png)

[参考链接：](http://sharkdtu.com/posts/spark-sql-join.html)




### 2、在查询日志的过程中，怎么判断节点任务执行慢是因为数据倾斜还是节点本身性能问题(不是与其它节点比较，即不能再次运行对比)？

<span style='color:文字颜色;background:背景颜色;font-size:文字大小;font-family:字体;'>文字</span>



### 3、数据库的四种隔离机制，mysql属于哪种，通过什么实现的？共享锁和排他锁有什么区别？mysql的事务机制？


### 4、mysql的索引采用什么方式，你对索引的理解，索引为什么能加速查询，B+树的存储结构，索引算法有哪些？


### 5、聚簇索引与非聚簇索引的差异，索引的最左匹配原则是什么？


