package com.jiebo.effective.java.chapter04.item23.hierarchy;

/**
 * @Author jiebo2
 * @Description 类层次-圆形实现
 * @Date 11:48 2019/3/15
 */
public class Circle extends Figure{

    final double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
