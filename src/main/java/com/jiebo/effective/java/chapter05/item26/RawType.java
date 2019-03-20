package com.jiebo.effective.java.chapter05.item26;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author jiebo2
 * @Description 泛型简介
 * @Date 13:52 2019/3/18
 */
public class RawType {

    /**
     * 泛型：在声明类或者接口时，指定一个或多个类型参数，如List<E> Map<K, V>
     * 原生态类型：不带任何实际类型参数的泛型名称，如List<E>对应的原生态类型就是List
     * 原生态类型的存在主要是为了提供兼容性，因为泛型是JDK1.5中才提出的
     * 作者建议：不要使用原生态类型，因为如果使用了原生态类型，就失掉了泛型在安全性和描述性方面的所有优势
     * 不过有几个小小的例外：
     * 1.必须在类文字中使用原生态类型：List.class而不能List<String>.class
     * 2.泛型使用instanceof时，list.instanceof List,而不能list.instanceof List<E>
     *
     * Q1：原生态类型List和参数化类型List<Object>有什么区别？
     * 前者逃避了泛型检查，后者则明确告知编译器，它能够持有任意类型的对象；
     * 可以将List<String>传递给List,但是不能将它传给List<Object>,因为List<String>是原生态类型List的子类型,但不是参数化类型List<Object>的子类型(List<String>和List<Object>是同级的)
     * 使用List这样的原生态类型，会失掉类型安全性，而使用List<Object>则不会
     *
     * Q2：无限制通配符类型Set<?>和原生态类型Set之间有什么区别？
     * 如果使用泛型，但又不确定或者不关心实际的类型参数，就可以用问号代替
     * 通配符类型是安全的，原生态类型不安全
     * 可以将任何元素放进使用原生态类型的集合中，因此很容易破坏该集合的类型约束条件
     * 但不能将任何元素(除null之外)放到Collection<?>中
     *
     * Q3：泛型List<E>和无限制通配符类型List<?>之间的区别？
     * 泛型是一种确定的类型参数
     * 而无限制通配符是一种不确定或者不关心的类型参数
     */

    /**
     * 原生态类型
     */
    private static void addToList(List list, Object element){
        list.add(element);
    }

    /**
     * 参数化的类型
     */
    private static void addToListObject(List<Object> list, Object element){
        list.add(element);
    }

    /**
     * 无限制通配符类型
     */
    private static void addToListWildcard(List<?> list, Object element){
        list.add(null);
        //下面这种写法有编译错误
//        list.add(element);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        addToList(list, "element");
        //下面这种写法是有编译错误的
//        addToListObject(list, "element");
    }
}
