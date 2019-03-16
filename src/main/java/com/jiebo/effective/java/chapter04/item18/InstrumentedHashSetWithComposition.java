package com.jiebo.effective.java.chapter04.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @Author jiebo2
 * @Description 实现HashSet的计数操作-复合方式
 * @Date 18:48 2019/3/11
 */
public class InstrumentedHashSetWithComposition<E> {

    /**
     * 在考虑是否要使用继承时，问自己2个问题：
     * 1.子类是否是真正的超类的子类型，也就是要正确区分：B是A(的扩展)，还是B只是使用到了A
     * 2.你正试图扩展的类，它的API中有没有缺陷，以及你是否愿意把超类的缺陷，传播到子类中
     * 作者提出：JDK中stack extends vector，或者Properties extends HashTable都是不合适的，因为stack并不是一种vector，Properties也并不是一种HashTable，而只是用到这种数据结构
     *
     * 我这里复合的实现方式比较简单，书中作者的比较复杂，还使用到了包装类的方式
     */
    private HashSet<E> set;
    private int addCount = 0;

    public InstrumentedHashSetWithComposition(HashSet<E> set){
        this.set = set;
    }

    public boolean add(E e){
        addCount++;
        return set.add(e);
    }

    public boolean addAll(Collection<? extends E> c){
        addCount += c.size();
        return set.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSetWithComposition<String> set = new InstrumentedHashSetWithComposition<>(new HashSet<String>());
        set.add("1");
        System.out.println(set.getAddCount());
        set.addAll(Arrays.asList("2", "3", "4"));
        System.out.println(set.getAddCount());
    }

}
