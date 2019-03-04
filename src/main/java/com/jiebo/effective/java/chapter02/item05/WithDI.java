package com.jiebo.effective.java.chapter02.item05;


/**
 * @Author jiebo2
 * @Description 使用DI(依赖注入)方式的实现
 * @Date 10:03 2019/3/4
 */
public class WithDI {

    private BaseDependent baseDependent;

    /**
     * 使用依赖注入有以下好处：
     * 1.BaseDependent的实例化对象是统一的IOC容器进行管理
     * 2.不用关系BaseDependent的构造方法和实例化过程
     * 3.可以灵活的使用BaseDependent的子类实例化对象，以适用不同的场景
     *
     * 这种通过构造器手动注入依赖的方式是最简单的实现了，但原理都是一样的
     * Spring主要通过Ioc容器来管理：
     * 1.xml的配置bean的方式
     * 2.@Resource的注解方式配置Bean
     */
    public WithDI(BaseDependent baseDependent){
        this.baseDependent = baseDependent;
    }
}
