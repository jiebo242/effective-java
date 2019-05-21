package com.jiebo.effective.java.chapter07.item42;

import java.util.function.DoubleBinaryOperator;

/**
 * @Author jiebo2
 * @Description 使用lambda来重构item34中的Operation枚举类型
 * @Date 09:11 2019/5/16
 */
public enum Operation {

    /**
     * 通过直接在枚举构造方法里传入一个"函数接口"来实现不同的运算方法
     * DoubleBinaryOperator是在java.util.function中预定义的众多函数接口之一
     * 相比item34中的写法简洁了许多
     */

    PLUS("+", (x, y)->x+y),
    MINUS ("-", (x, y) -> x - y),
    TIMES ("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op){
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }

    /**
     * 1.Lambda对标的是通过匿名类提供函数对象，写法上简洁许多
     * 2.可以简单理解：对函数接口(有注解@FunctionalInterface)的对象就叫函数对象
     * 3.Lambda最多三行，一行最好，超过三行就要考虑其他方式了
     * 4.什么时候用Lambda，什么时候用匿名类
     *   (1)函数接口的实例化优先考虑Lambda
     *   (2)非函数类接口(抽象类or多个抽象方法的接口)的实例化优先考虑匿名类
     */
}
