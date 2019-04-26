package com.jiebo.effective.java.chapter06.item38;

/**
 * @Author jiebo2
 * @Description 基本的opcode枚举值定义
 * @Date 09:14 2019/4/24
 */
public enum BasicOperation implements Operation {

    /**
     * 再定义不同opcode的接口的实现
     * 呵呵，这个枚举定义还必须放在前面，不然报编译错误
     */
    PLUS("+"){
        @Override
        public double apply(double x, double y){
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y){
            return x - y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y){
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y){
            return x / y;
        }
    };

    /**
     * 先定义下枚举的公共属性和方法
     */
    private final String symbol;

    BasicOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }

}
