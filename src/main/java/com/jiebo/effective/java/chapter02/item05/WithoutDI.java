package com.jiebo.effective.java.chapter02.item05;


/**
 * @Author jiebo2
 * @Description 不使用DI方式的实现
 * @Date 10:03 2019/3/4
 */
public class WithoutDI {

    private BaseDependent baseDependent;

    /**
     * 每次使用的时候都new一个依赖的对象，主要有以下问题：
     * 1.BaseDependent的实例数量不受控制，每个依赖它的地方都自己实例化
     * 2.一旦BaseDependent的构造方法发生变化，大家都得改，耦合性大
     * 3.不能灵活的使用BaseDependent的子类实例化对象
     */
    public WithoutDI(){
        this.baseDependent = new BaseDependent();
    }
}
