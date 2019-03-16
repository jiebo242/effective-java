package com.jiebo.effective.java.chapter04.item22;

/**
 * @Author jiebo2
 * @Description 不可实例化的工具类来定义常量
 * @Date 09:56 2019/3/15
 */
public final class UtilityClassConstants {

    /**
     * 定义常量的几种合理方案：
     * 1.如果常量和某个类或者接口紧密相关，则应该把常量定义在类或者接口里，如：Integer.Double中都定义了MIN_VALUE和MAX_VALUE
     * 2.如果常量能被看作是枚举类型的成员，优先使用枚举类型定义
     * 3.使用不可实例化的工具类来定义常量-本例的这种方式
     */

    private UtilityClassConstants(){

    }

    /**
     * Java7以后，可以在数字的字面量中使用下划线，主要是便于长串数字的一个阅读
     */
    public static final double PI = 3.141_592_65;
}
