package com.jiebo.effective.java.chapter07.item43;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @Author jiebo2
 * @Description 方法引用(method reference)代码示例
 * @Date 10:49 2019/5/18
 */
public class Freq {

    /**
     * 1.方法引用也是提供函数对象(函数接口的实例)的一种方式
     * 2.方法引用是在lambda表达式上，省略掉参数的一种更加简洁的写法
     * 3.根据简洁性和可读性，选择是方法引用还是lambda
     *
     * 对比一下：匿名函数，Lambda、方法引用 三种方式的写法，实际上是依次优化的一个过程
     */

    public static void main(String[] args) {
        /**
         * 实现一个：设置map的value时，如果key不存在则直接添加，如果key存在，则将新value和老value相加后放入
         */
        Map<String, Integer> frequencyTable = new HashMap<>();

        /**
         * 匿名函数
         */
        for(String str : args){
            frequencyTable.merge(str, 1, new BiFunction<Integer, Integer, Integer>(){

                @Override
                public Integer apply(Integer count, Integer incr) {
                    return count + incr;
                }
            });
        }

        frequencyTable.clear();

        /**
         * lambda表达式
         * 相比匿名函数，省略掉了类信息、方法信息(方法名、回参)、参数类型，只有参数和方法体
         */
        for(String str : args){
            frequencyTable.merge(str, 1, (count, incr) -> count + incr);
        }

        frequencyTable.clear();

        /**
         * method reference方式
         * 相比Lambda，省略掉了参数信息，只有方法体(不过这个是一个已有的方法的引用)
         * 方法引用的类型有：静态、有限制、无限制、类构造器、数组构造器，写法大同小异，可参考书中表格
         */
        for(String str : args){
            frequencyTable.merge(str, 1, Integer::sum);
        }

    }
}
