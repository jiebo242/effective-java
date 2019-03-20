package com.jiebo.effective.java.chapter05.item32;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author jiebo2
 * @Description 堆污染例子
 * @Date 09:27 2019/3/20
 */
public class PickTwo {

    /**
     * 这个方法很危险
     * 返回数组的类型是由传到方法的参数的编译时类型决定的，编译器没有足够的信息去做准确的决定，因为该方法返回其可变参数数组，会将堆污染传到调用堆栈上
     * 允许另一个方法访问一个泛型可变参数数组是不安全的
     */
    public static <T> T[] toArray(T... args){
        return args;
    }

    /**
     * 随机返回2个参数的数组
     */
    public static <T> T[] pickTwo(T a, T b, T c){
        switch(ThreadLocalRandom.current().nextInt(3)){
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        return null;
    }

    public static void main(String[] args) {
        //这一步会报错：java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        //因为pickTwo始终会返回一个Object[]数组
        String[] result = pickTwo("Good", "Fast", "Cheap");
        System.out.println(result);

        //这种写法就不报错
        String[] array = toArray("Good", "Fast", "Cheap");
        System.out.println(array);
    }

}
