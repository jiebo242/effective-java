package com.jiebo.effective.java.chapter06.item34;

/**
 * @Author jiebo2
 * @Description 运算符枚举-改进
 * @Date 14:33 2019/3/23
 */
public enum OperationImprove {
    /**
     * "特定于常量的方法实现"
     * 将不同枚举对应的实现在定义枚举时进行重写
     */

    PLUS("+"){
        @Override
        public double apply(double x, double y){ return x + y; }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y){ return x - y; }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y){ return x * y; }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y){ return x / y; }
    };

    private final String symbol;

    OperationImprove(String symbol){
        this.symbol = symbol;
    }

    /**
     * 定义抽象方法，供每个枚举值进行重写
     */
    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        double x = 3;
        double y = 2;
        for(OperationImprove operationImprove : OperationImprove.values()){
            System.out.printf("%f %s % f = %f %n", x, operationImprove, y, operationImprove.apply(x, y));
        }
    }

}
