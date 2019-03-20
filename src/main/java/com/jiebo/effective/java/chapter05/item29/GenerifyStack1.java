package com.jiebo.effective.java.chapter05.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author jiebo2
 * @Description item07中堆栈的一个泛型化实现-构造时强转
 * @Date 09:30 2019/3/19
 */
public class GenerifyStack1<E> {
    /**
     * 在设计新类型的时候，如果涉及到类型的一个转化，通常只要时间允许，要把类做成泛型的，这样比需要客户端代码中进行转换的方式来得更加安全，也更加容易
     * 将一个类泛型化，主要有以下3个步骤：
     * 1.类的声明中添加一个或多个类型参数
     * 2.用相应的类型参数替换类中所有的Object类型
     * 3.编译中存在错误提示或警告，进行解决
     *
     * 本例子在item07堆栈类的泛型化过程中，解决编译错误和警告，有2种方案：
     * 1.绕过创建泛型数组，而是创建一个Object数组，并将它转换成泛型数组类型
     * 可读性更强，只需要创建数组的时候转换一次，所以优先推荐这种，不过它会导致堆污染，虽然堆污染在这种情况下并没有什么危害
     * 2.将elements域的类型从E[]改为Object[]，然后在获取元素的时候由Object转换为E
     * 每次读取元素时都需要转换
     */

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * 构造方法
     */
    @SuppressWarnings("unchecked")
    public GenerifyStack1(){
        //因为数组是要求具体化的，但是E不是一个具体化的类型，所以下面这么写法有编译错误
//        elements = new E[DEFAULT_INITIAL_CAPACITY];
        //因为数组是协变的，所以可以强转，强转后，会有警告，通过注解禁止警告
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 取元素
     */
    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    /**
     * 放元素
     */
    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 校验是否需要扩容
     */
    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, size * 2+1);
        }
    }
}
