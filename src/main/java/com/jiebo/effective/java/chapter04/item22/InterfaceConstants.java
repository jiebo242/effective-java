package com.jiebo.effective.java.chapter04.item22;

/**
 * @Author jiebo2
 * @Description 接口定义常量定义
 * @Date 09:43 2019/3/15
 */
public interface InterfaceConstants {

    /**
     * 作者是反对使用接口定义常量的，虽然我们平常经常这么用，作者提出：接口应该只用于定义类型，而不应该被用来导出常量
     *
     * 咱们使用接口定义常量主要是简单，引入interface的变量默认是public static final修饰的
     * 而作者不建议这么做的原因：
     * 1.实现这个接口的类，在导出API的时候会包含这些常量，而这些常量对于用户使用API是没有价值的(这个我觉得咱们定义的接口常量，也不是为了继承用的，不过既然你定义了接口就控制不住不让人家实现)
     * 2.类实现这个接口代表一种承诺，哪天类修改类不需要这些常量类，它也必须实现这个接口，以确保二进制兼容性，如果这个类有子类那所有的子类都会收到影响
     */

    static final double PI = 3.141_592_65;

}
