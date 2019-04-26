package com.jiebo.effective.java.chapter06.item34;

/**
 * @Author jiebo2
 * @Description 运算符枚举
 * @Date 14:33 2019/3/23
 */
public enum Operation {
    /**
     * 下面这种写法就是一般写法，但是有不足的地方：
     * 1.必须有throw语句，才能正常通过编译，而实际上是不可能执行到这行代码的
     * 2.代码是脆弱的，如果添加了新的枚举，却没有更新switch方法，枚举可以编译，但运行时传入新枚举会报错
     *
     * 这是因为这个枚举不像Planet一样，每个枚举常量的方法都是一样的执行逻辑
     * 对于Operation这种，每个枚举常量关联不同的行为的情况，使用"特定于常量的方法实现"
     * 改进方式见：OperationImprove
     */

    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, double y){
        switch (this){
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("Unknow operation: " + this);
    }

    public static void main(String[] args) {
        /**
         * 枚举默认方法ordinal可以打印出枚举对应的序号
         */
        for(Operation operation : Operation.values()){
            System.out.printf("%s is %s %n", operation, operation.ordinal());
        }
    }
}
