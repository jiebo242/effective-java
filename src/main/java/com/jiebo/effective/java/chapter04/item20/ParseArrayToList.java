package com.jiebo.effective.java.chapter04.item20;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Author jiebo2
 * @Description 骨架实现类-使用方式()
 * @Date 15:48 2019/3/13
 */
public class ParseArrayToList {
    /**
     * AbstractList就是List接口的一个抽象骨架实现类
     * 下面采用了一个匿名内部实现类的一个方式来使用了"抽象骨架实现类"
     */

    public static List<Integer> parseArraysToList(int[] array){
        Objects.requireNonNull(array);

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return array[index];
            }

            @Override
            public int size() {
                return array.length;
            }

            /**
             * 需要重写这个方法,不然在进行Collections.shuffle(list)这个操作时，会报java.lang.UnsupportedOperationException
             * 因为抽象骨架实现类AbstractList是没有实现这个set方法的
             */
            @Override
            public Integer set(int i, Integer val){
                int oldVal = array[i];
                array[i] = val;
                return oldVal;
            }
        };

    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for(int i=0; i<array.length; i++){
            array[i] = i;
        }
        List<Integer> list = ParseArrayToList.parseArraysToList(array);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
