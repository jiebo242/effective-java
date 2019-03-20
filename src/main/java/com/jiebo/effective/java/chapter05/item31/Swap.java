package com.jiebo.effective.java.chapter05.item31;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

/**
 * @Author jiebo2
 * @Description 交换集合中的2个元素-2中声明方式
 * @Date 17:25 2019/3/19
 */
public class Swap {

    /**
     * 无限制的类型参数-泛型实现
     * 因为这种定义相比通配符，更加复杂和不灵活
     */
    public static <E> void swapWithGenerify(List<E> list, int i, int j){
        list.set(i, list.set(j, list.get(i)));
    }

    /**
     * 无限制的通配符
     * 在定义公共的API时，这种方式更好一些，因为它更简单
     * 一般情况下：如果类型参数只在方法声明中出现一次(也就是方法体里面没用到)，就可以用通配符取代它，如果是无限制的类型参数，就用无限制的通配符取代它，如果是有限制的类型参数，那就用有限制的通配符类型取代它
     */
    public static void swapWithWildcardType(List<?> list, int i, int j){
        //下面这种写法会有编译错误，所以需要配套编写一个私有的辅助方法来捕捉通配符类型，而这个辅助方法必须是一个泛型方法
        //为啥编译错误，因为之前提到过：不能把null之外的任何值放到List<?>里面
//        list.set(i, list.set(j, list.get(i)));
        swapHelper(list, i, j);
    }

    /**
     * 辅助方法
     * 呵呵，你有没有发现，这个辅助方法的签名，正是无限制的类型参数的声明方式
     * 所以2种声明方式在功能上没啥区别，因为底层实现都用到了枚举
     */
    private static <E> void swapHelper(List<E> list, int i, int j){
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        String[] array = {"1","2","3","4"};
        List<String> argList = Arrays.asList(array);
        swapWithGenerify(argList, 0, argList.size() - 1);
        System.out.println(argList);
        swapWithWildcardType(argList, 0, argList.size() - 1);
        System.out.println(argList);
    }
}
