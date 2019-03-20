package com.jiebo.effective.java.chapter05.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * @Author jiebo2
 * @Description 在item29例子中添加2个通配符实现的方法
 * @Date 15:31 2019/3/19
 */
public class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size==0){
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    /**
     * 按顺序将一系列的元素全部放到堆栈中
     */
    //不使用通配符
    public void pushAllWithoutWildcardType(Iterable<E> src){
        for(E e : src){
            this.push(e);
        }
    }
    //使用通配符
    public void pushAllWithWildcardType(Iterable<? extends E> src){
        for(E e : src){
            this.push(e);
        }
    }

    /**
     * 从堆栈中取出每个元素，并将元素添加到指定的集合中
     */
    //不使用通配符
    public void popAllWithoutWildcardType(Collection<E> dst){
        while(!isEmpty()){
            dst.add(this.pop());
        }
    }
    //使用通配符
    public void popAllWithWildcardType(Collection<? super E> dst){
        while(!isEmpty()){
            dst.add(this.pop());
        }
    }

    public static void main(String[] args) {
        //通过测试，来看为何使用通配符
        //因为通配符更加灵活，能够避免参数化类型的不可变性，让入参更灵活
        Stack<Number> numberStack = new Stack<>();

        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        //不使用通配符的方法这种写法会有编译错误，因为参数化类型之间不能转换，如果定义集合是Iterable<Number> integers，下面的写法就可以，因为不存在类型转换
//        numberStack.pushAllWithoutWildcardType(integers);
        numberStack.pushAllWithWildcardType(integers);

        Collection<Object> objects = new ArrayList<>();
        //不使用通配符的方法这种写法会有编译错误，因为参数化类型之间不能转换，如果定义集合是Collection<Number> objects，下面的写法就可以，因为不存在类型转换
//        numberStack.popAllWithoutWildcardType(objects);
        numberStack.popAllWithWildcardType(objects);

        System.out.println(objects);
    }
}
