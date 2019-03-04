package com.jiebo.effective.java.chapter02.item02.hierarchicalbuilder.withoutgenerictype;

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
        /**
         * 书里的写法使用到了泛型，但自己不明白泛型的作用
         * 自己尝试了写了个不用泛型的，但是发现以下的写法都是不支持的
         * 看来泛型的作用和写法还需深入研究
         */

        //不能用的写法
//        Son son = new Son.Builder().name("张三").age(19).build();
//        Parent parent = new Son.Builder().name("张三").age(19).wifeName("儿媳妇").build();

        //可以用的写法,只能用Parent来接受对象，但toString的方法确实Son的
        Parent parent = new Son.Builder().wifeName("儿媳妇").name("张三").age(19).build();
        System.out.println(parent.toString());

        /**
         * 呵呵，明白为啥wifeName只能放在最前，而且只能用Parent来接收了
         * 因为没有用泛型，导致：
         * 1.先拼装其他属性，会调用到父类的方法，而父类此方法没有使用泛型，而是直接返回了父类的Builder，所以没法继续拼装子类的属性了
         * 2.为啥build后只能用parent接收，因为父类的Builder的build()因为没用泛型，返回的就是父类对象啊
         * 突然明白泛型的作用了，顾名思义，泛型就是一个比较宽泛的类型，没有限定死某个固定的class，使得初入参更加的灵活，尤其是在继承里面使用更加方便
         *
         * 当然这里不用泛型好像也不影响实际使用，就是一些限制比较死，但是不用泛型更好理解代码
         */

    }
}
