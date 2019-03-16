package com.jiebo.effective.java.chapter04.item23.taggedclass;

/**
 * @Author jiebo2
 * @Description 标签类-不推荐
 * @Date 11:22 2019/3/15
 */
public class Figure {

    /**
     * 一句话：强烈不推荐标签类，因为它过于冗长，容易出错，并且效率低下
     *
     * 什么是标签类？本类就是一个标签类
     * 1.包含多种风格
     * 2.通过标签域进行逻辑区分
     * 3.违背来封装的原则，层次上混乱
     *
     * 本类就是一个标签类
     * 1.多个实现乱七八糟的挤在一个类里，破坏可读性
     * 2.单个实例承担者属于其他风格的不相关的域，内存占用也增加了
     * 3.因为每个标签的构造器不一样，所以域不能做成final的，除非构造器初始化不相关的域
     * 4.每个标签的构造器不一样，标签域也不一样，如果初始化了错误的域，程序运行就会失败
     * 5.添加新的标签或者风格时，必须记得给每个条件语句都添加一个条件，否则会运行时失败
     * 6.实例的数据类型没有提供任何关于其风格的线索
     */

    enum Shape {
        //矩形
        RECTANGLE,
        //圆形
        CIRCLE
    }

    final Shape shape;

    double length;
    double width;

    double radius;

    //圆形的构造器
    Figure(double radius){
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    //矩形的构造器
    Figure(double length, double width){
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    //公用的计算面积方法-具体实现根据标签来区分
    double area(){
        switch (this.shape){
            case CIRCLE:
                return Math.PI * (this.radius * this.radius);
            case RECTANGLE:
                return this.length * this.width;
            default:
                throw new AssertionError(shape);
        }
    }
}
