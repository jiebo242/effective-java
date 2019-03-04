package com.jiebo.effective.java.chapter02.item02.hierarchicalbuilder;

/**
 * @Author jiebo2
 * @Description
 * @Date 09:06 2019/3/1
 */
public class BuilderTest {

    /**
     * 父类-子类还得好好研究下
     * 哪些属性和方法是能继承的？
     * 调用某个方法到底调用的是父类的还是子类的？
     */

    public static void main(String[] args) {
        Son son = new Son.Builder().name("张三").age(19).wifeName("儿媳妇").build();
        System.out.println(son.toString());

        Parent parent = new Son.Builder().name("张三").age(19).wifeName("儿媳妇").build();
        System.out.println(parent.toString());

        //通过上面2个打印出来是一致的，是不是可以认为，一个引用调用的方法或者属性，并不管这个引用是哪个class(父类)，而是根据实际引用的对象是哪个class(子类)来的

        Daughter daughter = new Daughter.Builder().name("女儿").age(18).husbandName("女婿").build();
        System.out.println(daughter.toString());

        Daughter parent2 = new Daughter.Builder().name("女儿").age(18).husbandName("女婿").build();
        System.out.println(parent2.toString());
    }
}
