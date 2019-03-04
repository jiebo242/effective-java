package com.jiebo.effective.java.chapter02.item07;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author jiebo2
 * @Description 过期对象引用的手动消除
 * @Date 15:51 2019/3/4
 */
public class Stack {
    /**
     * 栈中的元素
     */
    private Object[] elements;
    /**
     * 当前栈中元素的数量
     */
    private int size = 0;
    /**
     * 栈容量的初始化大小
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 2;

    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 栈中存放元素
     */
    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 栈中获取元素
     */
    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object e = elements[--size];
        elements[size] = null;
        return e;
    }

    /**
     * 检查容量，及时扩容
     */
    private void ensureCapacity(){
        //扩容的条件可灵活设置
        if(elements.length == size){
            elements = Arrays.copyOf(elements, size * 2 +1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.size);
        stack.push("element1");
        stack.push("element1");
        stack.push("element1");
        stack.push("element1");
        stack.push("element1");
        stack.push("element1");
        stack.push("element1");
        stack.push("element1");
        stack.push("element1");
        System.out.println(stack.size);
        System.out.println(stack.pop());
        System.out.println(stack.size);
    }
}
