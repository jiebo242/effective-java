package com.jiebo.effective.java.chapter05.item30;

import java.util.function.UnaryOperator;

/**
 * @Author jiebo2
 * @Description 泛型单例工厂
 * @Date 11:24 2019/3/19
 */
public class GenericSingletonFactory {
    /**
     * 没太明白这个例子的意思
     */

    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> indentityFunction(){
        return (UnaryOperator<T>)IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = {"jute","hemp","nylon"};
        UnaryOperator<String> sameString = indentityFunction();
        for(String s : strings){
            System.out.println(sameString.apply(s));
        }
        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = indentityFunction();
        for(Number n : numbers){
            System.out.println(sameNumber.apply(n));
        }
    }
}
