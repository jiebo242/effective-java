package com.jiebo.effective.java.chapter04.item24;

/**
 * @Author jiebo2
 * @Description 嵌套类
 * @Date 09:53 2019/3/16
 */
public class Nested {

    /**
     * 分类：
     * 嵌套类(nested class)分四种：静态成员类(static member class)、非静态成员类(nonstatic member class)、匿名类(anonymous class)、局部类(local class)，后三种又称为内部类(inner class)
     *
     * 1.静态成员类：
     * 可以用public\protected\default\private修饰，被修饰后的作用域和修饰变量或方法一致
     * 可以把它看成一个普通的类，只是碰巧被声明在另一个类的内部而已
     * 可以访问外围类的所有成员(包括私有的)，当然，需要先实例化一个外围类(因为静态成员类并没有和外围类的实例有啥关联，它是独立的)
     *
     * 常见用法：作为公有的辅助类，配合外围类一起使用才有意义，比如：Calculator.Operation
     *
     * 2.非静态成员类：
     * 可以用public\protected\default\private修饰，被修饰后的作用域和修饰变量或方法一致
     * 每个实例都隐形的和外围类的一个实例相关联
     * 这种关联关系需消耗非静态成员类实例的空间，并且会增加构造的时间开销
     * 非静态成员类实例方法内部，可以直接调用外围实例上的方法或者属性(包括私有的)
     *
     * 常见用法：更多的是作为外围类的一个扩展，比如：Set和List集合的迭代器iterator采用这种方式
     *
     * 3.匿名类：
     * 不是外围类的成员
     * 在使用的同时被声明和实例化，可以出现在代码中任何允许存在表达式的地方
     * 保持简短(10行或更少)，提高可读性
     *
     * 常见用法：动态的创建小型函数对象和过程对象(现在优先选择lambda)，或者在静态工厂方法的内部
     *
     * 4.局部类
     * 使用最少
     * 在任何"可以声明局部变量"的地方，都可以声明局部类
     *
     * 作者建议：
     * 如果声明类不要求访问外围实例，就尽量使用静态成员类，因为非静态成员类实例保存外围类的引用，消耗时间和空间，并可能会导致内存泄漏(因为外围实例在符合垃圾回收时却依然得以保留，而且这个外围实例的引用是不可见的)
     * 如果一个嵌套类需要在单个方法之外依然可见或者它太长不适合放在方法内部时，就应该使用成员类
     * 如果成员类的每个实例都需要一个指向其外围实例的引用，就把成员类做成非静态的，否则就是静态的
     * 如果你只需要在一个地方创建实例，并且已经有了一个预置的类型可以说明这个类的特性，就要把它做成匿名类，否则就是局部类
     *
     */

    private String outsideString = "outsideString";

    public String getOutsideString(){
        return outsideString;
    }


    public void newThread(){
        /**
         * 匿名类
         */
        new Thread(){
            @Override
            public void run(){

            }
        }.start();
    }


    /**
     * 公有的静态成员类
     */
    public static class PublicMemberClass{
        private String publicMemberClassString;

        public String getPublicMemberClassString(){
            Nested nested = new Nested();
            String outsideString = nested.getOutsideString();
            return publicMemberClassString;
        }
    }

    /**
     * 私有的静态成员类，和公有的静态成员类唯一区别就是作用域，只能在外围类内部使用
     */
    private static class PrivateMemberClass{

    }

    /**
     * 非静态成员类
     */
    public class NonstaticMemberClass {
        private String nonstaticMemberClassString;

        public String getNonstaticMemberClassString(){
            String outsideStrin = outsideString;
            return nonstaticMemberClassString;
        }
    }

    /**
     * 局部类
     */

    {
        class InnerClass{}//块内局部类
    }

    public void test(){
        class InnerClass{}//方法内局部类
    }

}

