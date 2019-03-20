package com.jiebo.effective.java.chapter05.item31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author jiebo2
 * @Description 在item30的泛型方法中使用通配符
 * @Date 17:16 2019/3/19
 */
public class Union {

    public static <E> Set<E> union(Set<? extends E> set1, Set<? extends E> set2){
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Double> set2 = new HashSet<>(Arrays.asList(1.0,2.0,3.0));
        Set<Number> result = Union.union(set1, set2);
        System.out.println(result);
    }
}
