package com.jiebo.effective.java.chapter02.item03.lazyman.ordinary;

/**
 * @Author jiebo2
 * @Description 单例实现-懒汉模式-普通方式
 * @Date 17:37 2019/3/1
 */
public class Singleton {

    /**
     * 与饿汉模式比，主要优点是避免类在未使用的情况下创建多余的对象
     * 但这种普通写法最大问题多线程并发时，可能创建新的实例，无法保证单例
     */

    private static Singleton instance;

    /**
     * 构造器为私有的
     */
    private Singleton(){
    }

    public static Singleton getInstance(){
        if(null == instance){
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        /**
         * 用下面多个线程测试，没出现创建新实例的情况，还是因为并发量不够
         */

        for(int i=0; i<10; i++){
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
