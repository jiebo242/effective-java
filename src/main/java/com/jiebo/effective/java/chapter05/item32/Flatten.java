package com.jiebo.effective.java.chapter05.item32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author jiebo2
 * @Description 安全使用泛型可变参数的例子-按顺序返回包含输入参数的列表
 * @Date 09:55 2019/3/20
 */
public class Flatten {
    /**
     * 两种方式：
     * 1.保证安全+使用@SafeVarargs
     *
     * 2.使用List代替数组实现可变参数的传递
     */

    //实现方式1
    public static <E> List<E> flattenWithVarargs(List<? extends E>... lists){
        List<E> result = new ArrayList<>();
        for(List<? extends E> list : lists){
            result.addAll(list);
        }
        return result;
    }

    //实现方式2
    public static <E> List<E> flattenWithList(List<List<? extends E>> lists){
        List<E> result = new ArrayList<>();
        for(List<? extends E> list : lists){
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flattenWithVarargs(
                Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6,7));
        System.out.println(flatList);

        List<Integer> flatList2 = flattenWithList(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6,7))
                );
        System.out.println(flatList2);
    }
}
