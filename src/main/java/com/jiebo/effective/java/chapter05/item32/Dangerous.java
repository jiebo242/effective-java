package com.jiebo.effective.java.chapter05.item32;

import java.util.Arrays;
import java.util.List;

/**
 * @Author jiebo2
 * @Description 不安全的可变参数类型
 * @Date 20:38 2019/3/19
 */
public class Dangerous {
    /**
     * 泛型和可变参数一起用的时候，会不安全，不能良好的合用
     * 原因是可变参数设施是构建在顶级数组之上的一个技术露底，同时可能产生堆污染
     * 不过因为带有泛型可变参数或者参数化类型的方法在实践中用处很大，所以Java语言的设计者选择容忍这一矛盾的存在，比如JAVA类库中Arrays.asList(T...a)、Collections.addAll(Collection<? super T>C, T...elements)的都是类型安全的
     *
     * 如果要编写带有泛型(或者参数化)可变参数的方法，需要注意2点：
     * 1.确保该方法是类型安全的
     * 那泛型可变参数方法在下列条件下是安全的：
     * (1)它没有在可变参数数组中保存任何值
     * (2)它没有对不被信任的代码开放该数组(或者其克隆程序)
     * 以上两条只要任何一条被破坏，就要立刻进行修正
     * 2.使用@SafeVarargs对方法进行注解
     * 如果不想用SafeVarargs注解，也可以用item28提到的使用List参数代替可变参数(也就是用List代替数组)
     * 这种优势在于编译器可以证明该方法是类型安全的，无需添加注解
     * 缺点在于客户端代码有点繁琐，运行速度会慢一点
     */

    public static void dangerous(List<String>... stringLists){
        List<Integer> intList = Arrays.asList(42);
        Object[] objects = stringLists;
        //这条语句会导致堆污染，即用一个参数化类型变量(object)指向一个不是该类型的对象(List<Integer>)
        objects[0] = intList;
        //这条语句有一个隐形的类型转换
        String s = stringLists[0].get(0);
    }

    public static void main(String[] args) {
        //运行这个测试方法，会报错java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        //不过我倒是觉得上面方法写的用问题，明显故意将Integer转换为String啊
        dangerous(Arrays.asList("There be dragons!"));
    }
}
