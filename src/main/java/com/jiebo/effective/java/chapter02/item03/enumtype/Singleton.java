package com.jiebo.effective.java.chapter02.item03.enumtype;

/**
 * @Author jiebo2
 * @Description 单例实现-枚举的方式
 * @Date 17:58 2019/3/1
 */
public enum Singleton {

    /**
     * 实现方式感觉就是hungryman-staticfield的一种简化写法，只是利用了enum类型正好符合单例的一些要求
     * 为啥选择枚举：
     * 1.枚举的构造器默认就是private的,所以连构造器都不用自己写了
     * 2.enum提供类序列化机制，绝对防止多次实例化
     *
     * 如果该类需要继承一个非enum类的时候，可能就不适合这种方式了
     *
     * 作者说"单元素的枚举类型经常成为实现Singleton的最佳方法"，还需体会下
     *
     * 还需学习下枚举类的底层实现
     */

    INSTANCE;

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
    }

}
