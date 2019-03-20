package com.jiebo.effective.java.chapter05.item30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author jiebo2
 * @Description 泛型方法
 * @Date 11:12 2019/3/19
 */
public class Union {
    /**
     * 泛型方法的使用和泛型类一样，目的是通过泛型的使用，避免客户端的类型转换，更加安全、更容易使用
     * 静态工具方法尤其适合于泛型化
     * 本节另外2个例子没明白啥意思，后续回来再研究
     */

    /**
     * <E>是声明类型参数的类型参数列表，处在方法的修饰符和其返回值之间
     */
    public static <E> Set<E> union(Set<E> set1, Set<E> set2){
        Set<E> result = set1;
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(Arrays.asList("Tom","Dick","Harry"));
        Set<String> set2 = new HashSet<>(Arrays.asList("Larry","Moe","Curly"));
        Set<String> result = Union.union(set1, set2);
        System.out.println(result);
    }
}
