package com.jiebo.effective.java.chapter05.item32;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author jiebo2
 * @Description PickTwo的安全写法-将泛型数组修改为List
 * @Date 09:47 2019/3/20
 */
public class SafePickTwo {

    /**
     * 在item28中提到过，必要时候使用泛型集合代替泛型数组
     */
    public static <T> List<T> pickTwo(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0:
                return Arrays.asList(a, b);
            case 1:
                return Arrays.asList(a, c);
            case 2:
                return Arrays.asList(b, c);
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> result = pickTwo("Good", "Fast", "Cheap");
        System.out.println(result);
    }
}
