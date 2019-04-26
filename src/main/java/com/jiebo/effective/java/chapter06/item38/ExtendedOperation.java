package com.jiebo.effective.java.chapter06.item38;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author jiebo2
 * @Description 扩展的opcode枚举值定义
 * @Date 09:14 2019/4/24
 */
public enum ExtendedOperation implements Operation {
    /**
     * 实际上我感觉既然是opcode枚举的扩展，为啥不直接把新的枚举值添加到BasicOperation代码里得了
     * 这里通过接口来模拟枚举的扩展，可能就是为了实现：将同一个枚举可以拆分到多个enum类，更清晰方便吧
     */

    /**
     * 再定义不同opcode的接口的实现
     * 呵呵，这个枚举定义还必须放在前面，不然报编译错误
     */
    PLUS("^"){
        @Override
        public double apply(double x, double y){
            return Math.pow(x, y);
        }
    },
    MINUS("%"){
        @Override
        public double apply(double x, double y){
            return x % y;
        }
    };

    /**
     * 先定义下枚举的公共属性和方法
     * 像这种公共的东西，实现同一个接口的enum里都得copy一份
     * 如果共享内容多的话，则需要考虑单独封装一个辅助类或者静态辅助方法，避免代码的冗余
     */
    private final String symbol;

    ExtendedOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        /**
         * 当一个枚举类型，需要像普通类那样变成可扩展或拆分的时候，就可以采用定义接口，enum来实现接口的方式来实现了(因为enum是无法直接扩展的，enum无法直接继承enum)
         */
        double x = 3.14;
        double y = 2.14;

        test1(BasicOperation.class, x, y);
        test1(ExtendedOperation.class, x, y);
        System.out.println("==============================");
        test2(Arrays.asList(BasicOperation.values()), x, y);
        test2(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    /**
     * 声明方式1
     * 这个方法的声明方式比较复杂，确保Class对象既表示是枚举类型，又表示是Operation的子类型
     */
    private static <T extends Enum<T> & Operation> void test1(Class<T> opEnumType, double x, double y){
        for(Operation op : opEnumType.getEnumConstants()){
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    /**
     * 声明方式2
     * 这种方式比较简单，通过有限制的通配符类型限制传入的是Operation子类型的一个集合
     */
    private static void test2(Collection<? extends Operation> opSet, double x, double y){
        for(Operation op : opSet){
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }



}
