package com.jiebo.effective.java.chapter02.item02.hierarchicalbuilder.withoutgenerictype;

import lombok.ToString;

/**
 * @Author jiebo2
 * @Description 类层次结构的Builder模式-父类
 * @Date 19:36 2019/2/28
 */
@ToString
public abstract class Parent {

    /**
     * 和一个类的Builder模式思想上是一样的
     * 只是将两个子类的公共部分进行封装，并使用到了泛型(泛型可以理解为是一种递归类型的参数，泛型这块还需加强学习？)
     * 为啥要写成抽象类？我觉得因为包含抽象的静态成员类，而静态成员类是因为包含类抽象方法
     */

    /**
     * 父类的成员属性不能用private修饰，不然子类无法继承的
     * 但是还有一种说法是子类是能够继承父类的private属性和方法的，只是不能重写
     * 现象就是子类可以调用父类的非private方法来获取or操作父类的private属性
     */
    final String name;

    final int age;

    final int gender;

    /**
     * Parant
     * @Author jiebo2
     * @Description Builder对象转目标对象的构造方法,不使用泛型
     * @Date 2019/2/28 19:45
     * @Param [builder]
     * @Return
     */
    Parent(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
    }


    /**
     * Builder
     * @Author jiebo2
     * @Description Builder的静态成员类，而且也是抽象类，不使用泛型的写法
     * @Date 2019/2/28 19:46
     */
    public abstract static class Builder{

        private String name;

        private int age;

        private int gender;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder gender(int gender){
            this.gender = gender;
            return this;
        }


        //不能这么写，因为Parent为抽象类，不能实例话,所以得下面得写法
        /*public Parent build(){
            return new Parent(this);
        }*/

        public abstract Parent build();

    }

}
