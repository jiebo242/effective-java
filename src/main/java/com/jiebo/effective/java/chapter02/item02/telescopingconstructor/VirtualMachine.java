package com.jiebo.effective.java.chapter02.item02.telescopingconstructor;

/**
 * 多个参数情况下采用-多个构造方法重载的形式来构建不同的实例
 * @Author jiebo2
 * @Description 重叠构造器
 * @Date 15:53 2019/2/28
 */
public class VirtualMachine {
    /**
     * 用final修饰成员变量有何意义？
     * 1.final修饰的成员变量只能通过构造器初始化时候来赋值
     * 2.这样在初始化对象完成后，就没法对对象进行变更了啊
     * 3.针对final修饰的成员变量，无法添加set方法
     */

    private final int vcpus;

    private final int memorys;

    private final int disk;

    private final int swap;

    private final String ip;

    /**
     * VirtualMachine
     * @Author jiebo2
     * @Description 包含所有参数的构造器
     * @Date 2019/2/28 16:42
     * @Param [vcpus, memorys, disk, swap, ip]
     * @Return
     */
    public VirtualMachine(int vcpus, int memorys, int disk, int swap, String ip){
        this.vcpus = vcpus;
        this.memorys = memorys;
        this.disk = disk;
        this.swap = swap;
        this.ip = ip;
    }

    public VirtualMachine(int vcpus, int memorys, int disk){
        this(vcpus, memorys, disk, 0, null);
    };

    public VirtualMachine(int vcpus, int memorys, int disk, int swap) {
        this(vcpus, memorys, disk, swap, null);
    }

    public VirtualMachine(int vcpus, int memorys, int disk, String ip) {
        this(vcpus, memorys, disk, 0, ip);
    }

    public static void main(String[] args) {
        VirtualMachine vm = new VirtualMachine(1, 2, 20);
    }

}
