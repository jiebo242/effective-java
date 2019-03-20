package com.jiebo.effective.java.chapter05.item31;

import java.util.*;

/**
 * @Author jiebo2
 * @Description 在item28例子修改为通配符的方式
 * @Date 17:00 2019/3/19
 */
public class Chooser<E> {

    private final List<E> choiceList;

    public Chooser(Collection<? extends E> collection){
        choiceList = new ArrayList<>(collection);
    }

    public E choose(){
        Random random = new Random();
        return choiceList.get(random.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        //通过使用通配符提高了灵活性，这样传入的collection的类型不是那么固定,不用必须和Chooser的类型一摸一样
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        Chooser<Number> chooser = new Chooser(intList);
    }
}
