package com.jiebo.effective.java.chapter02.item02.javabeans;

import lombok.Setter;

/**
 * 多个参数情况下采用-setter方法构建不同的实例
 * VirtualMachine
 * @Author jiebo2
 * @Description JavaBeans模式
 * @Date 2019/2/28 16:58
 */
@Setter
public class VirtualMachine {

    /**
     * 之前我也一直用的是这种方式拼装对象，但是书里说有2个比较大问题：
     * 1.在构造对象构成中JavaBeans可能处于不一致的状态
     * 我理解就是因为先用无参构造方法new了一个对象，而每个变量都需要set，在完成全部set操作期间，很可能此对象发生了变化
     * 2.JavaBeans模式使得把类做成不可变的可能性不复存在
     * 因为这种方式下不能用final修饰成员变量，所以成员变量的值在初始化之后是可以变化
     */

    private int vcpus;

    private int memorys;

    private int disk;

    private int swap;

    private String ip;

    public static void main(String[] args) {
        VirtualMachine vm = new VirtualMachine();
        vm.setVcpus(1);
        vm.setMemorys(2);
        vm.setDisk(20);
    }
}
