package com.jiebo.effective.java.chapter04.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @Author jiebo2
 * @Description 实现HashSet的计数操作-继承方式
 * @Date 17:13 2019/3/11
 */
public class InstrumentedHashSetWithExtend<E> extends HashSet<E> {
    /**
     * 首先要明确并不是说所有的继承方式都不提倡，而是要看场景的
     * 1.继承会打破子类的封装性，让子类更加脆弱
     * 一种情况是子类的实现依赖于超类的不稳定方法，超类的方法一旦变动就会影响到子类(作者在书中提到了子类复用HashSet的addAll方法，而addAll如果实现逻辑发生变化，会影响到子类)
     * 还有一种情况，就算子类没有重写超类的方法，也会存在问题，因为超类后续可能会添加相同和子类签名相同的方法
     */

    private int addCount = 0;

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSetWithExtend<String> set = new InstrumentedHashSetWithExtend<>();
        set.add("1");
        System.out.println(set.getAddCount());
        set.addAll(Arrays.asList("2", "3", "4"));
        System.out.println(set.getAddCount());
        //打印结果
        //1
        //7 因为addAll会调用add方法，所以重复计数了2次
        //这里就涉及到继承导致的脆弱性了，如果我们为了计数正确，重写addAll方法，但这样有很多问题：实现起来困难、耗时，容易出错，并且可能降低性能
    }
}
