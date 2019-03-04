package com.jiebo.effective.java.chapter02.item02.builder.level2;

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
     * 这种方式之前在openstack4j的代码里见过，当时就觉得挺好用的，也很直观，不过没具体操作过
     * 优势
     * 1.可以很方便的识别每个参数的意思，不会弄混
     * 2.和构造器方式一样，可以保证类的不可变
     * 劣势
     * 1.因为在创建对象时，需要先new一个构建器，影响些许性能
     * 2.代码可能比重叠构造器还多
     */

    private final int vcpus;

    private final int memorys;

    private final int disk;

    private final int swap;

    private final String ip;

    /**
     * VirtualMachine
     * @Author jiebo2
     * @Description 通过这个构造方法将builder对象转换为virtualmachine对象
     * @Date 2019/2/28 18:25
     * @Param [builder]
     * @Return
     */
    public VirtualMachine(Builder builder) {
        this.vcpus = builder.vcpus;
        this.memorys = builder.memorys;
        this.disk = builder.disk;
        this.swap = builder.swap;
        this.ip = builder.ip;
    }

    /**
     * Builder构建器
     * @Author jiebo2
     * @Description 静态成员类
     * 思考？这个和内部类有啥区别？内部类和一般的类有啥区别？
     * 难道成员类就是内部类，只是多了个静态修饰
     * @Date 2019/2/28 17:17
     */
    public static class Builder{
        /**
         * Builder的变量和VirtualMachine是一样的
         * 整个过程相当于先通过Builder把值存下来，拼装完成后再一次性的赋值给VirtualMachine
         * 突然发现，这个Builder不就跟level1里面我自己想的那个方式是一样的嘛，呵呵
         * 那为啥非要这么导一下，我觉得主要是保证了VirtualMachine的成员变量的final性(保留构造器方式的优点)
         */

        private int vcpus;

        private int memorys;

        private int disk;

        private int swap;

        private String ip = "还可以设置默认值";

        public Builder vcpus(int vcpus){
            this.vcpus = vcpus;
            return this;
        }

        public Builder memorys(int memorys){
            this.memorys = memorys;
            return this;
        }

        public Builder disk(int disk){
            this.disk = disk;
            return this;
        }

        public Builder swap(int swap){
            this.swap = swap;
            return this;
        }

        public Builder ip(String ip){
            this.ip = ip;
            return this;
        }

        public VirtualMachine build(){
            return new VirtualMachine(this);
        }

    }

    public static void main(String[] args) {
        VirtualMachine vm = new Builder().vcpus(1).memorys(2).disk(20).ip("修改默认值").build();
        System.out.println(vm.toString());
    }
}
