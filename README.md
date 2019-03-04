# effective-java
effective-java[第三版]书中的代码示例
# 作者提供的本书代码示例
https://github.com/jbloch/effective-java-3e-source-code.git
# 目录结构
| chapter | item | explanation |
|:-:|:-:|:-:|
| 02 | 02 | 实体类多个参数的情况下，推荐使用构建器Build |
|    | 03 | Singleton单例的多种实现方式：饥饿方式、懒加载方式、枚举方式、静态内部类方式(饥饿+懒加载的融合) |
|    | 05 | 推荐依赖注入的方式来引入资源，有诸多好处 |
|    | 06 | 避免创建不必要的对象，但是要看是什么类型的对象，创建新的还是复用已有的是要比较各方面代价后的一个结果 |
|    | 07 | 及时将过期的引用置为null，但并不是每个对象都要手动清除引用，大部分还是交给GC来做，文中主要说明了内存泄漏的3个主要来源 |
|    | 09 | 针对需手工关闭的资源，JDK1.7之后有了一种新的写法，不用再手动close资源了 |
