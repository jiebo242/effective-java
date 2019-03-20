package com.jiebo.effective.java.chapter05.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author jiebo2
 * @Description item07中堆栈的一个泛型化实现-获取元素时强转
 * @Date 09:58 2019/3/19
 */
public class GenerifyStack2<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * 构造方法
     */
    public GenerifyStack2(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 存放元素
     */
    public void push(E e){
        ensureCapacity();
        /**
         * 数组是协变的，所以子类可以放在父类的数组中
         */
        elements[size++] = e;
    }

    /**
     * 获取元素
     */
    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        //下面这么写会报编译错误
//        E result = elements[--size];
        //所以进行强转,强转后有警告，通过注解禁止
        @SuppressWarnings("unchecked")
        E result = (E)elements[--size];
        elements[size] = null;
        return result;
    }

    /**
     * 容量检测
     */
    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, size * 2+1);
        }
    }
}
