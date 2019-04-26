package com.jiebo.effective.java.chapter06.item34;

/**
 * @Author jiebo2
 * @Description 枚举-行星
 * @Date 20:03 2019/3/22
 */
public enum Planet {
    /**
     * 在JAVA1.5支持枚举类型前，都是使用int常量来实现枚举的,默认父类为java.lang.Enum
     *
     * int枚举模式，存在不足：
     * 1.编译上不具有类型安全，也几乎没有描述性(因为实际上就是int，所以只要传入一个int值就行，不会有编译错误)
     * 2.没有命名空间，只能自己在int定义时添加前缀来区分
     * 3.int常量是编译时常量，在编译时就已将常量值替换到了代码中，如果值有变化，则必须重新编译代码
     * 4.打印的时候就是一个数字，没有含义
     *
     * 而枚举类型的出现，就解决了以上int常量枚举的不足
     * Java枚举是一种特殊的类，本质上是int值，枚举的构造器默认也只能是私有的，枚举值实际上是static final的，从而保证它是单例的、受控的(每个枚举值相当于是这个枚举类的一个单例的实例)
     * 枚举类型除了能够完善了int枚举模式的不足，枚举类型还可以进行增强：
     * 1.枚举可以添加任意的方法和域
     * 2.可以实现任意的接口
     * 3.默认提供了所有Object方法的高级实现，默认实现了Comparable接口、Serializable接口
     * 4.枚举默认的toString()返回的是每个枚举值的声明名称
     * 5.枚举有一个静态的values方法，按照声明顺序返回它的值数组
     * 6.枚举类型有一个默认的valueOf(String)方法，它将常量的名字转变成常量本身
     * 7.枚举默认方法ordinal可以打印出枚举对应的序号
     * 枚举的这些默认方法都继承自父类java.lang.Enum
     *
     * 注意：
     * 1.除了常量域，枚举的构造器不可以访问枚举的静态域，因为在构造器运行时，这些静态域还没有被初始化
     * 2.枚举在性能上，相比int常量，在装载和初始化枚举时有空间和时间成本，但在实践时几乎注意不到
     * 3.如果多个(但非所有)枚举常量同时共享相同的行为，需要考虑策略枚举，详见例子PayrollDay
     */

    MERCURY(3.302e+23, 2.439e6),
    VENUS  (4.869e+24, 6.052e6),
    EARTH  (5.975e+24, 6.378e6),
    MARS   (6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26, 6.027e7),
    URANUS (8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    /**
     * 下面就是给枚举添加一些域和方法(和一般的类是一样的)，来增强枚举的功能
     */

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private static final double G = 6.67300E-11;


    /**
     * 构造器，默认是private的
     */
    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double surfaceWeight(double mass){
        return mass * surfaceGravity;
    }

    public static void main(String[] args) {
        /**
         * enum类型，有默认的vlaues和valueOf方法，同时toString方法打印的是枚举值
         * printf可以拼装stringformat，%s打印字符串，%f打印double类型，%n是换行符
         */
        for(Planet planet : Planet.values()){
            System.out.printf("weight on %s is %f %n", planet, planet.surfaceWeight(1));
        }
    }

}
