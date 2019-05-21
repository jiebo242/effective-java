package com.jiebo.effective.java.chapter07.item45;

import java.util.Arrays;
import java.util.List;

/**
 * @Author jiebo2
 * @Description Stream最常见的用法
 * @Date 08:56 2019/5/20
 */
public class CommonUsageByStream {

    public static void main(String[] args) {
        //1. List的循环，代替for循环
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangmazi");

        for(String s : list){
            System.out.println(s);
        }

        list.stream().forEach(s -> System.out.println(s));
    }
}
