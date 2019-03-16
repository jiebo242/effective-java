package com.jiebo.effective.java.chapter04.item17;

/**
 * @Author jiebo2
 * @Description 复数的一个简单实现-体验不可变类的实现
 * @Date 15:47 2019/3/8
 */
public final class ComplexNumber {
    /**
     * item15+item16讲的是可访问性
     * 主要讲的是在设置类、接口、域、方法的可访问性时，尽量从低到高(private\default\protected\public)
     * 作者把这个叫做"信息隐藏"，主要是为了解耦、提高可重用性，还是比较好理解的
     *
     * item17则讲的是可变性
     * 之前只是知道final修饰的作用(类=不可继承,方法=不可重写,域=不可变)，但并没有深入了解为何用final以及何时用final，估计最常用的就是static final修饰常量了，呵呵
     *
     * 很多优点：
     * 1.不可变对象比较简单
     * 2.不可变对象本质上是线程安全的，它们不要求同步，不可变对象可以被自由的共享
     * 3.不仅可以共享不可变对象，甚至可以共享它们的内部信息(因为内部的域也是final的)
     * 4.不可变对象为其他对象提供了大量的构建
     * 5.不可变对象无偿的提供失败的原子性(因为它们的状态永远不变，不存在临时不一致的可能性)
     *
     * 唯一的缺点：
     * 每个不同的值都需要一个单独的对象，当构建新对象的代价很高时，存在性能问题
     *
     * 解决方法：
     * 就是为不可变对象提供配套的"可变配套类"(前提是你确认有必要实现令人满意的性能时)-例如String和它的可变配套类StringBuffer和StringBuilder
     *
     * 使类成为不可变，遵循5条规则：
     * 1.不要提供任何会修改对象状态的方法(set方法)
     * 2.保证类不会被扩展(用final修饰class，或者通过实例化控制的方式-这种方式不常用)
     * 3.声明所有的域都是final的
     * 4.声明所有的域都是私有的
     * 5.确保对于任何可变组件的互斥访问
     *
     * 作者是强烈推荐不可变类：
     * 1.除非有很好的理由需要让类成为可变的类，否则它就应该是不可变的
     * 2.如果类不能被做成不可变的，仍然应该尽可能地限制它的可变性
     * 3.配合上可最低访问性，除非有令人信服的理由要使域变成是非final的，否则要使每个域都是private final的
     * 4.构造器应该创建完全初始化的对象，并建立起所有的约束关系(final修饰的域，也只能在构造器里初始化)
     */

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im){
        this.re = re;
        this.im = im;
    }

    /**
     * 提供域的访问方法，但不提供设值方法
     */
    public double getRe(){
        return re;
    }
    public double getIm(){
        return im;
    }

    /**
     * 加减乘除的方法实现
     * 1.注意这些算术运算，返回的都是新的ComplexNumber实例，而不是修改原实例
     * 2.这种叫"函数的方法"，对应的是"过程的方法"或"命令式的方法"
     * 函数的方法：方法返回一个函数的结果，方法是对操作数进行运算但并不修改它
     * 过程的方法或命令式的方法：则是将一个过程或者命令作用在它们的操作数上，会导致它的状态发生改变
     */
    public ComplexNumber plus(ComplexNumber cn){
        return new ComplexNumber(this.re + cn.re, this.im + cn.im);
    }

    public ComplexNumber minus(ComplexNumber cn){
        return new ComplexNumber(this.re - cn.re, this.im - cn.im);
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o instanceof ComplexNumber){
            ComplexNumber cn = (ComplexNumber)o;
            return Double.compare(this.re, cn.re) == 0 && Double.compare(this.im, cn.im) == 0;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 31 * Double.hashCode(this.re) + Double.hashCode(this.im);
    }
}
