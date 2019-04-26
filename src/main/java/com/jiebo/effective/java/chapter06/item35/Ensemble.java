package com.jiebo.effective.java.chapter06.item35;

/**
 * @Author jiebo2
 * @Description 编写枚举时，用域代替序数
 * @Date 20:25 2019/3/29
 */
public enum Ensemble {

    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    /**
     * 推荐-采用域的方式，在定义枚举时指定
     */
    public int numberOfMusicians() {
        return numberOfMusicians;
    }

    /**
     * 不推荐-使用enum自带的ordinal方法，因为这个值会根据枚举常量的顺序进行变化
     * enum.ordinal()方法的注释上已经明确说明：大多数程序员都不需要这个方法，它是设计用于像EnumSet和EnumMap这种基于枚举的通用数据结构的
     */
    public int numberOfMusicians2(){
        return this.ordinal() + 1;
    }


}
