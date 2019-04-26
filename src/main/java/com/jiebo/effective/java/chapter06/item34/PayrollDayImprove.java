package com.jiebo.effective.java.chapter06.item34;

//静态引用，可以直接使用枚举值，不用带前缀
import static com.jiebo.effective.java.chapter06.item34.PayrollDayImprove.PayType.*;

/**
 * @Author jiebo2
 * @Description 薪酬计算-改进
 * @Date 15:48 2019/3/23
 */
public enum PayrollDayImprove {
    /**
     * 通过再内嵌一个策略枚举进行解决
     * 这种方式适合与枚举值的方法逻辑，既不是都不同也不是都相同
     * 这种写法的思维方式就是：既然上层枚举的计算逻辑是有几种不同的分类，那就干脆按照这个分类再定义一个策略枚举，然后给每个上层枚举设置对应的策略枚举值
     *
     * 虽然代码没有PayrollDay简洁，但是更加安全，也更加灵活
     */

    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY),
    THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
    SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDayImprove(PayType payType){
        this.payType = payType;
    }

    public int pay(int hourWorked, int payRate){
        return payType.pay(hourWorked, payRate);
    }

    /**
     * 内嵌一个策略枚举来计算工资
     * 这个枚举的写法和OperationImprove是一样的
     * 书里这个类的写法和我这边自己的想的不一样，它是抽离的更细，因为只是计算超时工资的方法是不一样的，所以书里重写的是计算超时工资的方法
     */
    enum PayType{
        WEEKDAY{
            @Override
            int pay(int hourWorked, int payRate) {
                int basePay = hourWorked * payRate;
                int overtimePay = hourWorked <= BASE_WORK_HOURS ? 0 : (hourWorked - BASE_WORK_HOURS)*payRate;
                return basePay + overtimePay;
            }
        },
        WEEKEND{
            @Override
            int pay(int hourWorked, int payRate) {
                int basePay = hourWorked * payRate;
                int overtimePay= basePay;
                return basePay + overtimePay;
            }
        };

        private static final int BASE_WORK_HOURS = 8;

        abstract int pay(int hourWorked, int payRate);
    }

    public static void main(String[] args) {
        int hourWorked = 10;
        int payRate = 100;
        for(PayrollDay payrollDay : PayrollDay.values()){
            System.out.printf("%s 应得工资 %s %n", payrollDay, payrollDay.pay(hourWorked, payRate));
        }
    }
}
