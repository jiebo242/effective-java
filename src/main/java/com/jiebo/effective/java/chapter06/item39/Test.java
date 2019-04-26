package com.jiebo.effective.java.chapter06.item39;

import java.lang.annotation.*;

/**
 * @Author jiebo2
 * @Description 编写一个注解
 * @Date 20:13 2019/4/25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    /**
     * 本条就是通过编写一个Test注解，一步步的来更深入了解注解的编写和使用
     * 1.元注解-注解类声明中的注解
     * @Retention 表示注解的生命周期：源码级别（source），类文件级别（class）或者运行时级别（runtime）
     *      像@Override的就是源码级别有效，注解将被编译器丢弃（该类型的注解信息只会保留在源码里，源码经过编译后，注解信息会被丢弃，不会保留在编译好的class文件里）
     * @Target 用来约束注解可以应用的地方，常用的：类、方法、域、参数...
     * 2.一般来讲，注解永远不会改变被注解代码的语义，只是标示可以通过工具进行特殊的处理
     * 3.个人理解：注解的识别应该是通过反射，而对应的处理则应该是通过切面
     * 4.除了框架师需要新增注解，基本上使用java或者框架已有的注解足够了，毕竟添加一个注解还是挺麻烦的(除了定义注解，还要编写相关的处理类)
     *
     *
     * 参考帖子：https://mp.weixin.qq.com/s/7MSHRa75d5fDeRlZE3_3pA
     */

    /**
     * 注解支持使用的类型：所有基本类型(但不能是包装类)、String、Class、Enum、Annotation、上述类型的数组
     */
    int value() default 0;

    String[] name() default "";

    Class<? extends Throwable> exception() default Exception.class;
}
