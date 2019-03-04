package com.jiebo.effective.java.chapter02.item02.hierarchicalbuilder;

import lombok.Getter;

/**
 * @Author jiebo2
 * @Description 类层次结构的Builder模式-子类
 * @Date 19:36 2019/2/28
 */
@Getter
public class Daughter extends Parent{

    /**
     * 子类的结构和父类是一样的，只是扩展了成员变量
     * 单看父类和子类，都是按照Builder的写法结构来的
     * 相比父类，子类就好理解多了，主要原因是父类用了泛型，自己对泛型又不甚了解，有点看不懂代码
     */

    private final String husbandName;

    /**
     * Parant
     * @Author jiebo2
     * @Description Builder对象转目标对象的构造方法,使用到了泛型
     * @Date 2019/2/28 19:45
     * @Param [builder]
     * @Return
     */
    private Daughter(Builder builder){
        super(builder);
        this.husbandName = builder.husbandName;
    }


    /**
     * Builder
     * @Author jiebo2
     * @Description Builder的静态成员类
     * 发现一个事，如果父类的Builder不用泛型，子类的Builder写成如下，在使用Son.Builder拼参的时候是没法拿到子类Builder里面东西的：
     * public static class Builder extends Parent.Builder
     * @Date 2019/2/28 19:46
     */
    public static class Builder extends Parent.Builder<Builder>{

        private String husbandName;

        public Builder husbandName(String husbandName){
            this.husbandName = husbandName;
            return this;
        }

        @Override
        protected Builder self(){
            return this;
        };

        @Override
        public Daughter build(){
            return new Daughter(this);
        };

    }

    @Override
    public String toString() {
        return "Daughter{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", gender=" + super.getGender() +
                ", husbandName='" + husbandName + '\'' +
                '}';
    }
}
