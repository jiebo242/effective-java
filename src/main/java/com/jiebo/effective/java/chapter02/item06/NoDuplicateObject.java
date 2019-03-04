package com.jiebo.effective.java.chapter02.item06;

/**
 * @Author jiebo2
 * @Description 重复创建不必要的对象
 * @Date 14:28 2019/3/4
 */
public class NoDuplicateObject {
    /**
     * 首先明确重复的对象是可以创建的，不会影响应用功能，但主要是有以下2方面问题：
     * 1.创建大量的不必要的对象，浪费JVM内存，而且因为内存占用量大更容易进行GC
     * 2.有些复杂重量级的对象创建的时候成本很高，影响性能(这里作者强调对于轻量级的对象是没有必要自己维护对象池的，而重量级的对象如线程、数据库连接的实例化成本高，推荐使用对象池)
     *
     * 而哪些对象只需要创建一个实例就够了：
     * 1.相同功能的对象(比如一些工具类)
     * 2.对象是不可变的
     *
     * 避免创建重复不必要的对象，主要有以下方法：
     * 1.使用静态工厂类创建实例，而非构造器
     * 2.将对象设置为类的静态成员属性
     * 3.计算时候尽量使用基本类型而不是装箱基本类型(想想实体类里面的属性基本都用的装箱类型，这里就涉及到基本类和装箱类的对比和选择了)
     *
     * 基本类型更节约空间，计算速度更快节约时间，但不能为null，但作为一般实体对象的属性，该属性可能是null，所以一般采用的装箱类型
     * 1.计算时优先使用基本类型
     * 2.实体类还是优先使用装箱类型，因为一般的实体不会大量进行运算操作的，而更多的用于存储数据
     * 一句话：要比对2种方式的代价(性能、代码风格、安全等)哪个更高来决定
     */

    /**
     * 每调用一次方法，都会新建一个Pattern实例
     */
    public boolean isRomanNumeral(String originString){
        return originString.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * 因为Pattern实例是一个规则，是可复用的，而且创建一个Pattern对象的成本高
     * 所以考虑把此正则表达式静态化，成为类初始化的一部分
     */
    private static final String ROMANREGEX = "^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
    public boolean isRomanNumeral2(String originString){
        return originString.matches(ROMANREGEX);
    }

    public static void main(String[] args) {
        NoDuplicateObject test = new NoDuplicateObject();
        long start = System.currentTimeMillis();
        System.out.println(test.isRomanNumeral("test"));
        System.out.println(test.isRomanNumeral("test2"));
        System.out.println(test.isRomanNumeral("test3"));
        System.out.println(test.isRomanNumeral("VI"));
        System.out.println(System.currentTimeMillis()-start);

        /**
         * 下面这种方式确实耗时更短
         */
        long start2 = System.currentTimeMillis();
        System.out.println(test.isRomanNumeral2("test"));
        System.out.println(test.isRomanNumeral2("test2"));
        System.out.println(test.isRomanNumeral2("test3"));
        System.out.println(test.isRomanNumeral2("VI"));
        System.out.println(System.currentTimeMillis()-start2);
    }

}
