package com.jiebo.effective.java.chapter04.item19;

import java.util.Date;

/**
 * @Author jiebo2
 * @Description 设计一个专门为了继承而编写的类
 * @Date 18:10 2019/3/12
 */
public class Sub extends Super{

    /**
     * 作者是不建议继承的，不过某些场景下(见item18)确实需要继承
     * 那设计一个专门为了继承而编写的类需要注意些什么呢？
     * 1.提供很好的说明文档，那这个文档要说明什么呢？
     * (1)这个文档相当于一个永久的承诺，在这个类的整个生命周期中都必须遵守
     * (2)精确的描述覆盖每个方法所带来的影响
     * (3)指明该方法调用类哪些可覆盖的方法，以什么顺序调用的，而每个调用的结果又会如何影响后续处理过程
     * (4)如果方法调用到了可覆盖的方法，那在它的文档注释的末尾应该包含关于这些调用的描述信息
     * 这里作者举例了：AbstractCollection.remove的描述作为例子
     * 2.类必须以精心挑选的受保护方法的形式，提供适当的钩子，以便进入其内部工作中。
     * 这个我个人理解就是将一些超类public方法用到的实现方法，也得以protected的形式暴露给子类，以便子类在需要时进行重写
     * 这里作者举例了：AbstractList.remove方法用到的removeRange
     * 3.对于为了继承而设计的类，唯一的测试方法就是编写子类
     *
     * 在编写超类时，需注意：
     * 1.构造器决不能调用可被覆盖的方法
     * 因为超类的构造器在子类构造器之前运行，而如果子类覆盖了超类构造器中调用的方法，那在方法会被超类在子类的构造器之前先被调用
     * 本节编写的例子就是为了说明这种方式的危害写的
     * 构造器可以调用私有的、final修饰的、静态的方法，因为这些方法无法被覆盖
     * 2.实现了Clonable或者Serializable接口的类，编写clone或者readObject方法时，都不可调用可被覆盖的方法，不管是直接调用还是间接调用
     *
     * 程序文档有句格言：好的API文档应该描述一个给定的方法做了什么工作，而不是描述它是如何做到的
     * 但为了设计一个类能够被安全的子类化，我们必须描述清楚这些实现细节
     *
     * 这些个问题的最佳解决方案就是：对于那些并非为了安全地进行子类化而设计和编写文档的类，要禁止子类化
     * 1.final声明类
     * 2.把构造器变成私有或者包级私有，并且增加一些公有的静态工厂来代替构造器
     *
     */


    private final Date date;

    public Sub(){
        date = new Date();
    }

    @Override
    public void overrideMe(){
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();

        Super sup = new Sub();
        sup.overrideMe();

    }

}
