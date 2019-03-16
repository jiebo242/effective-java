package com.jiebo.effective.java.chapter04.item23.hierarchy;

/**
 * @Author jiebo2
 * @Description 类层次-抽象父类
 * @Date 11:45 2019/3/15
 */
public abstract class Figure {
    /**
     * 如何将标签类进行拆分重构：
     * 1.抽离出一个包含公共域和方法的父抽象类
     * 2.将不同的标签类进行拆分成子类，包含独立的域和方法实现
     */

    abstract double area();

}
