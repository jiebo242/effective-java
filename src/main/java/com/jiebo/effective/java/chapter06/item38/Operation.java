package com.jiebo.effective.java.chapter06.item38;

/**
 * @Author jiebo2
 * @Description 操作码opcode的接口定义
 * @Date 09:13 2019/4/24
 */
public interface Operation {

    /**
     * 通过接口定义，这样当需要扩充新的opcode时，就可以通过实现此接口来添加了
     */
    double apply(double x, double y);
}
