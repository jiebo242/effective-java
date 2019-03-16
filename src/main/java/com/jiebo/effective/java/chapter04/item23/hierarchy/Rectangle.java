package com.jiebo.effective.java.chapter04.item23.hierarchy;

/**
 * @Author jiebo2
 * @Description 类层次-矩形实现
 * @Date 11:51 2019/3/15
 */
public class Rectangle extends Figure {

    final double length;
    final double width;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }


    @Override
    double area() {
        return length * width;
    }
}
