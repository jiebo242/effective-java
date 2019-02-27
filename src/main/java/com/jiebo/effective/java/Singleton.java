package com.jiebo.effective.java;

import org.junit.Test;

/**
 * 单例模式
 * @Author jiebo2
 * @Description
 * @Date 18:02 2019/2/27
 */
public class Singleton {

    private static volatile Singleton singleton;

    /**
     * Singleton
     * @Author jiebo2
     * @Description 构造方法设置为private
     * @Date 2019/2/27 18:25
     * @Param []
     * @Return
     */
    private Singleton(){

    }

    /**
     * getInstance
     * @Author jiebo2
     * @Description 双重检验锁方式
     * @Date 2019/2/27 18:11
     * @Param []
     * @Return com.jiebo.effective.java.Singleton
     */
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * testSingleton
     * @Author jiebo2
     * @Description 单例模式验证单元测试
     * @Date 2019/2/27 18:10
     * @Param []
     * @Return void
     */
    public static void main(String[] args){
        for(int i=0; i<100; i++){
            new Thread(){
                @Override
                public void run(){
                    Singleton singleton = Singleton.getInstance();
                    //所有线程获取到的实例的hashcode均相同，说明是同一个实例
                    System.out.println(singleton.hashCode());
                }
            }.start();

        }
    }


}
