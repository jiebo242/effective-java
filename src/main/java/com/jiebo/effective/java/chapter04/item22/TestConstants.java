package com.jiebo.effective.java.chapter04.item22;

import static com.jiebo.effective.java.chapter04.item22.UtilityClassConstants.*;
/**
 * @Author jiebo2
 * @Description
 * @Date 09:54 2019/3/15
 */
public class TestConstants {

    public static void main(String[] args) {
        System.out.println(InterfaceConstants.PI);
        System.out.println(UtilityClassConstants.PI);

        //使用静态导入的方式，可以避免用类名来修饰常量名
        System.out.println(PI);
    }
}
