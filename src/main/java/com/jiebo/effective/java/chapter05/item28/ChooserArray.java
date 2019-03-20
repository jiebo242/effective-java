package com.jiebo.effective.java.chapter05.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author jiebo2
 * @Description 数组实现-返回一个集合中随机的一个元素
 * @Date 17:22 2019/3/18
 */
public class ChooserArray<T> {
    /**
     * 作者把这条起名：列表优于数组，不过我感觉更准备的说法：泛型列表优于泛型数组
     * 为啥这么说呢？
     * 1.数组是协变的、可以具体化的；数组提供了运行时的类型安全，但是没有编译时的类型安全
     * 2.泛型列表是不可变的，可以擦除的；泛型则是在编译时就提供了类型安全
     * 一句话：使用泛型数组时，如果出现了编译错误或警告，你的第一反应应该是用列表代替数组，虽然可能会损失一些性能或代码简洁性，但是换回的却是更高的类型安全性和互用性
     *
     * PS：
     * 泛型是通过擦除实现的，也就是说泛型只是编译时强化它们的类型信息，并在运行时丢弃(擦除)它们的元素类型信息，这样可以使得泛型与没有泛型的代码随意进行互用
     * E、List<E>、List<String>这样的类型称为不可具体化的类型，直观的说，不可具体化的类型是指运行时表示法包含的信息比它的编译时表示法包含的信息更少的类型
     * 泛型和数组是不搭的
     *
     *
     * 通过ChooserArray和ChooserList的代码比对来展现以上观点
     */

    private final T[] choiceArray;

    public ChooserArray(Collection<T> choices){
        //这里不强转的话，会有编译错误
        //不过强转后，会有警告
        //此时，我们要第一反应用列表代替数组
        choiceArray = (T[])choices.toArray();
    }

    /**
     * 从集合中随机取出一个元素
     */
    public T choose(){
        Random random = ThreadLocalRandom.current();
        return choiceArray[random.nextInt(choiceArray.length)];
    }
}
