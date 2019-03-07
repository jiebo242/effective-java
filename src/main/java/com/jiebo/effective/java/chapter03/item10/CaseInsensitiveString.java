package com.jiebo.effective.java.chapter03.item10;


import java.util.Objects;

/**
 * @Author jiebo2
 * @Description equals方法-对称性验证
 * @Date 15:50 2019/3/5
 */
public class CaseInsensitiveString {
    /**
     * 首先确定是否需要重写equals方法:
     * 1.object或者超类的equals方法不能满足当前类的对比要求的时候
     * 2.当前类的equlas方法会提供给外部使用
     *
     * 以下几种情况是不需要重写euqlas方法的：
     * 1.每个实例都是唯一的，这种情况object的equals方法都够用类，也就是直接对比2个实例的引用
     * 2.类没必要提供逻辑相等的equals方法
     * 3.超类的euqlas方法可以复用且满足需求
     *
     * 如果实在要重写，需符合这5个约定：
     * 自反性、对称性、传递性、一致性、非null性
     */

    private final String s;

    public CaseInsensitiveString(String s){
        //JDK以及一些常用的第三方框架已经封装好了一些工具方法，注意整理和使用
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CaseInsensitiveString){
            //比较类里面的属性s的值
            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        }
        //这里看着好像写的没问题，还扩展了灵活性，
        //但问题就在于因为是比对的不同的对象：CaseInsensitiveString和String，会导致对称性，因为2个对象交换着进行equals，并不是用的同一个equals方法
        if(obj instanceof String){
            return s.equalsIgnoreCase((String)obj);
        }
        return false;
    }

    public static void main(String[] args) {
        //验证对称性
        CaseInsensitiveString s1 = new CaseInsensitiveString("java");
        String s2 = "java";
        CaseInsensitiveString s3 = new CaseInsensitiveString("java");

        //交换着进行比对，结果是不同的
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s1));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        //输出结果，因为没有重写hashcode方法，导致equals相同的对象，hashcode不同，这个是有问题的
        //true
        //false
        //true
        //true
        //1872034366
        //3254818
        //1581781576
    }

}
