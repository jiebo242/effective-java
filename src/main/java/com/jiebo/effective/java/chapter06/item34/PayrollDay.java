package com.jiebo.effective.java.chapter06.item34;

/**
 * @Author jiebo2
 * @Description 薪酬计算
 * @Date 15:08 2019/3/23
 */
public enum PayrollDay {
    /**
     * 枚举提供计算方法：根据给定的某工人的基本工资(按小时)和当天工作时长，计算当天的报酬
     * 这里要区分的是工作日和周末的计算方法是不一样的
     *
     * 本例的写法虽然简洁，但是有个问题：
     * 增加新枚举时，如果没有更新switch，则会按工作日的计算规则进行计算
     *
     * 这种场景(有些枚举计算逻辑一样，有些不一样)和Planet(每种枚举的逻辑都一样)、Operation(每种枚举的逻辑都不一样)还不一样
     * 这里的优化方案，就是采用Planet和Operation写法的混合方式：内置嵌套一个私有的策略枚举(内嵌的这个枚举的写法和Operation是一样的)
     * 改造后见PayrollDayImprove虽然代码没有本例简洁，但是更加安全，也更加灵活
     */

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int BASE_WORK_HOURS = 8;

    /**
     * 计算薪酬:weekday超过基本工作时长的工资按2倍计算，不满基本时长则只有基本工资 weekend是工作时长的2倍工资，
     * @param hourWorked 工作时长小时
     * @param payRate 每小时薪资
     * @return 当日的薪酬
     */
    public int pay(int hourWorked, int payRate){
        int basePay = hourWorked * payRate;
        int overtimePay;
        switch (this){

            case SATURDAY:
            case SUNDAY:
                overtimePay = basePay;
                break;
            default:
                overtimePay = hourWorked <= BASE_WORK_HOURS ? 0 : (hourWorked - BASE_WORK_HOURS)*payRate;
        }
        return basePay + overtimePay;

    }

    public static void main(String[] args) {
        int hourWorked = 10;
        int payRate = 100;
        for(PayrollDay payrollDay : PayrollDay.values()){
            System.out.printf("%s 应得工资 %s %n", payrollDay, payrollDay.pay(hourWorked, payRate));
        }
    }
}
