package com.jiebo.effective.java.chapter05.item28;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author jiebo2
 * @Description 列表实现-返回一个集合中随机的一个元素
 * @Date 17:43 2019/3/18
 */
public class ChooserList<T> {

    private final List<T> choiceList;

    public ChooserList(Collection<T> choices){
        choiceList = new ArrayList<>(choices);
    }

    public T choose(){
        Random random = ThreadLocalRandom.current();
        return choiceList.get(random.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

        ChooserArray<Integer> chooserArray = new ChooserArray<>(intList);
        ChooserList<Integer> chooserList = new ChooserList<>(intList);

        for (int i = 0; i < 10; i++) {
            Integer choiceArray = chooserArray.choose();
            System.out.println(choiceArray);
            Integer choiceList = chooserList.choose();
            System.out.println(choiceList);
            System.out.println("=============");
        }
    }
}
