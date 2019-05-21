package com.jiebo.effective.java.chapter07.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author jiebo2
 * @Description List排序的4种代码写法
 * @Date 08:53 2019/5/16
 */
public class SortFourWays {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple","banana","orange","pear");

        /**
         * 匿名类实现
         * 通过匿名类来实现并实例化一个Comparator接口的对象(函数对象)
         */
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        /**
         * Lambda表达式
         * Comparator接口有注解@FunctionalInterface，所以它是一个函数接口
         * 针对函数接口，我们就可以考虑Lambda来创建接口的实例(函数对象)
         * Lambda比匿名类简洁许多，因为省略掉了类型、参数类型、返回类型等一般类和方法的信息(而编译器是通过类型推导的过程，根据上下文推断出这些信息)
         */
        Collections.sort(words, (s1, s2)->Integer.compare(s1.length(), s2.length()));

        /**
         * 方法引用-见item43
         * 这个相当于Comparator给你封装好了一个：比较器构造方法
         * 方便直接传入比较字段，实例化一个函数对象
         */
        Collections.sort(words, Comparator.comparingInt(String::length));

        /**
         * 方法引用-见item43
         * 直接使用Java8中List接口添加的sort方法
         */
        words.sort(Comparator.comparingInt(String::length));
    }
}
