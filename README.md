# 大数据岗位各公司面试题汇总

# 滴滴
### 1、left semi join 为什么会比join快，且在mr处理的过程中，是通过什么原理/过程让其匹配到对应数据后不再继续匹配？

​		left semi join是以左表为准，在右表中查找匹配的记录，如果查找成功，则仅返回左边的记录，否则返回`null`，其基本实现流程如下图所示。

![spark-sql-semi-join](http://sharkdtu.com/images/spark-sql-semi-join.png)

[参考链接：](http://sharkdtu.com/posts/spark-sql-join.html)




### 2、在查询日志的过程中，怎么判断节点任务执行慢是因为数据倾斜还是节点本身性能问题(不是与其它节点比较，即不能再次运行对比)？



### 3、数据库的四种隔离机制，mysql属于哪种，通过什么实现的？共享锁和排他锁有什么区别？mysql的事务机制？



### 4、mysql的索引采用什么方式，你对索引的理解，索引为什么能加速查询，B+树的存储结构，索引算法有哪些？



### 5、聚簇索引与非聚簇索引的差异，索引的最左匹配原则是什么？



### 6、canal和Maxwell的区别？



### 7、Kafka对于传入数据的输出是否有序，对于每一个管道内的输入是否有序？



### 8、简述MR的执行过程



### 9、常见引擎参数的调节



### 10、HDFS常用命令



### 11、对于map join的理解

同第一个问题

### 12、数据存储格式ORC、parquet的区别



### 13、spark怎样申请Executor，采用了哪种client/cluster，为什么？对于client_thrift server  的了解










