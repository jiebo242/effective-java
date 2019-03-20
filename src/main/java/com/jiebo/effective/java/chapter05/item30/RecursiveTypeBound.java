package com.jiebo.effective.java.chapter05.item30;

import java.util.*;

/**
 * @Author jiebo2
 * @Description 列表的元素可以互相比较
 * @Date 11:34 2019/3/19
 */
public class RecursiveTypeBound {
    /**
     * 没太明白这个例子的意思
     * <E extends Comparable<E>>可以读作"针对可以与自身进行比较的每个类型E"
     */


    /**
     * 计算列表中最大值
     */
    public static <E extends Comparable<E>> E max(Collection<E> c){
        if(c.isEmpty()){
            throw new IllegalArgumentException();
        }
        E result = null;
        for(E e : c){
            if(result == null || e.compareTo(result)>0){
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"1","2"};
        List<String> argList = Arrays.asList(array);
        System.out.println(max(argList));
    }
}
