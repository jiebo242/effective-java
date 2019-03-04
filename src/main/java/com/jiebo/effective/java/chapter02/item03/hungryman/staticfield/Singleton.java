package com.jiebo.effective.java.chapter02.item03.hungryman.staticfield;

/**
 * @Author jiebo2
 * @Description 单例实现-饿汉方式-静态成员
 * @Date 17:18 2019/3/1
 */
public class Singleton {

    /**
     * 饿汉方式在类装载时就实例化了
     * 优点：
     * 1.没有加锁，性能好
     * 2.能够保证单例
     * 缺点：
     * 1.如果该对象没有被使用，容易产生垃圾对象，浪费内存
     *
     * 静态成员方式的优点：
     * 1.清楚的给使用方表明这个类是一个Singleton
     * 2.写法简单
     */

    public static final Singleton instance = new Singleton();

    /**
     * 所有单例的前提是：构造器是私有的
     */
    private Singleton(){

    }
}
