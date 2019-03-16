package com.jiebo.effective.java.chapter04.item19;

/**
 * @Author jiebo2
 * @Description
 * @Date 18:04 2019/3/12
 */
public class Super {

    /**
     * 构造器调用了可被覆盖的方法，这个是不符合规范的
     * 因为超类的构造器在子类构造器之前运行，而如果子类覆盖了超类构造器中调用的方法，那在方法会被超类在子类的构造器之前先被调用
     */
    public Super(){
        overrideMe();
    }

    public void overrideMe(){
        System.out.println("i m super");
    }
}
