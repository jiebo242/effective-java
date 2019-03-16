package com.jiebo.effective.java.chapter04.item24;

/**
 * @Author jiebo2
 * @Description 嵌套类的一个测试
 * @Date 10:15 2019/3/16
 */
public class TestNested {

    public static void main(String[] args) {

        /**
         * 静态成员类的声明方式，需要指定外围类，如果是在外围类内部声明则不用指定
         * 不需要实例化外围类
         */
        Nested.PublicMemberClass publicMemberClass = new Nested.PublicMemberClass();

        /**
         * 非静态成员类的声明方式
         * 需要先实例化外围类
         */
        Nested.NonstaticMemberClass nonstaticMemberClass = new Nested().new NonstaticMemberClass();
    }
}
