package com.jiebo.effective.java.chapter02.item02.builder.level1;

import lombok.ToString;

/**
 * 多个参数情况下采用-构建器方法构建不同的实例
 * VirtualMachine
 * @Author jiebo2
 * @Description 建造者模式
 * @Date 2019/2/28 16:58
 */
@ToString
public class VirtualMachine {

    /**
     * 这个是我自己想的构建器方式，呵呵，最后发现也就是形式上比较像Builder
     * 但是本质上还是是JavaBeans的set方法，只是set方法名改了，加上类return当前对象
     * 所以这种方式的缺点和JavaBeans方式是一样的了
     * 好处是可以一个语句将各变量进行赋值，而不用像set那个分成多个set语句
     */

    private int vcpus;

    private int memorys;

    private int disk;

    private int swap;

    private String ip;

    public VirtualMachine vcpus(int vcpus){
        this.vcpus = vcpus;
        return this;
    }

    public VirtualMachine memorys(int memorys){
        this.memorys = memorys;
        return this;
    }

    public VirtualMachine disk(int disk){
        this.disk = disk;
        return this;
    }

    public VirtualMachine swap(int swap){
        this.swap = swap;
        return this;
    }

    public VirtualMachine ip(String ip){
        this.ip = ip;
        return this;
    }

    public static void main(String[] args) {
        VirtualMachine vm = new VirtualMachine().vcpus(1).memorys(2).disk(20);
        System.out.println(vm.toString());
    }
}
