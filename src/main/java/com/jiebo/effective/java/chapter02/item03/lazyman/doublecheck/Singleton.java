package com.jiebo.effective.java.chapter02.item03.lazyman.doublecheck;

/**
 * @Author jiebo2
 * @Description 单例实现-懒汉模式-双重检验锁
 * @Date 17:37 2019/3/1
 */
public class Singleton {

    /**
     * 与饿汉模式比，主要优点是避免类在未使用的情况下创建多余的对象
     * 但这种普通写法最大问题多线程并发时，可能创建新的实例，无法保证单例
     *
     * 通过双重检验的方式可以保证单例，不过性能上会有所影响
     * 思考问题：为何要双重检查？为何要使用volatile修饰词
     *
     * 使用volatile创建对象会被分解为如下3行伪代码(指令)：
     * memory = allocate();    //1:分配对象的内存空间
     * ctorInstance(memory);    //2:初始化对象
     * instance = memory;        //3:设置instance指向刚分配的内存地址
     * 但是，上诉的2、3之间可能会被重排序。经常重排序后的时序图可能如下，此时B线程判定Instance不为空（但是此时的instance并未被初始化），所以B线程将会访问一个还未被初始化的对象
     */

    private static volatile Singleton instance;

    /**
     * 构造器为私有的
     */
    private Singleton(){
    }

    public static Singleton getInstance(){
        if(null == instance){
            synchronized (Singleton.class){
                if(null == instance){
                    instance = new Singleton();
                }
            }
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
