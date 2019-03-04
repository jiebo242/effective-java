package com.jiebo.effective.java.chapter02.item03.staticinnerclass;

/**
 * @Author jiebo2
 * @Description 单例实现-静态内部类(静态成员类)
 * @Date 18:13 2019/3/1
 */
public class Singleton {

    /**
     * 为了解决饿汉(类未使用情况下的多余对象的创建)和懒汉(高并发情况下保证不了单例及性能问题)的问题，提出了这种静态内部类的实现方式
     * 利用了以下原理(https://blog.csdn.net/chenrushui/article/details/71191672)：
     * 1.因为内部的静态类只会被加载一次，只会有一个实例对象，所以是线程安全的,不会创建多个对象
     * 2.内部类的加载机制: java中的内部类是延时加载的，只有在第一次使用时加载；不使用就不加载
     *
     * 想想这种思路也挺对的，首先最简单最方便实际上是饿汉方式，但最大问题是类加载的时候就实例化了，所以利用到静态内部类的一个lazy加载机制
     * 突然想到enumtype也存在和饿汉写法相同的问题，那岂不是也可以用静态内部类的方式来实现呢?
     * 呵呵尝试了下不行，因为Singleton如果是enum类型，没有构造方法给SingletonHolder用啊(不信你把现在这个类的public class Singleton改成public enum Singleton)
     */

    private Singleton(){

    }

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run(){
                    Singleton instance = Singleton.getInstance();
                    System.out.println(instance.hashCode());
                }
            }.start();
        }
    }
}
